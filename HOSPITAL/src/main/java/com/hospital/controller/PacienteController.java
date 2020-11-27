package com.hospital.controller;

import com.hospital.dto.PacienteDto;
import com.hospital.model.Paciente;
import com.hospital.repository.IPacienteRepo;

import com.hospital.service.core.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class PacienteController {


    private PacienteServiceImpl pacienteService;
    private IPacienteRepo pacienteRepo;

    public PacienteController(PacienteServiceImpl pacienteService, IPacienteRepo pacienteRepo) {
        this.pacienteService = pacienteService;
        this.pacienteRepo = pacienteRepo;
    }

    @GetMapping("/pacientes")
    public String pacienteList(Model model) {
        model.addAttribute("pacientes", pacienteService.findAll());
        return "pacientes";
    }

    @GetMapping("/pacientes/add")
    public String pacienteAdd(Model model) {
        model.addAttribute("pacientes", new PacienteDto());
        return "pacienteAdd";
    }

    @RequestMapping(value ="/pacientes/add", method = RequestMethod.POST)
    public String pacienteSave(PacienteDto pacienteDto, @RequestParam("imgUrl") MultipartFile image, Model model) {

        try {

            pacienteService.createPaciente(pacienteDto, image);
            return "redirect:/pacientes";
        } catch(Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
    }
    }

    @GetMapping("pacientes/edit/{id}")
    public String pacienteEdit(Model model, @PathVariable Integer id) {
        model.addAttribute("paciente", pacienteService.findById(id));
        return "pacienteEdit";
    }

    @GetMapping("/pacientes/delete/{id}")
    public String pacienteDelete(Model model, @PathVariable Integer id) {
        pacienteService.deleteById(id);
        return "redirect:/pacientes";
    }

}
