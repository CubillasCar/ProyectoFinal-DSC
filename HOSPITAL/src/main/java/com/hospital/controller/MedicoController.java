package com.hospital.controller;

import com.hospital.model.Medico;
import com.hospital.service.core.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MedicoController {


    @Autowired
    private IMedicoService medicoService;

//    public MedicoController(MedicoService medicoService) {
//        this.medicoService = medicoService;
//    }

    @GetMapping("/medicos")
    public String medicoList(Model model){
        model.addAttribute("medicos", medicoService.findAll());
        return "medicos";
    }

    @GetMapping("/medicos/add")
    public String medicoAdd(Model model){
        model.addAttribute("medico", new Medico());
        return "medicoAdd";
    }

    @PostMapping("/medicos/save")
    public String medicoSave(Medico medico){
        medicoService.createOrUpdate(medico);
        return "redirect:/medicos";
    }

    @GetMapping("/medicos/edit/{id}")
    public String medicoEdit(Model model, @PathVariable Integer id){
        model.addAttribute("medico", medicoService.findById(id));
        return "medicoAdd";
    }

    @GetMapping("/medicos/delete/{id}")
    public String medicoDelete(Model model, @PathVariable Integer id){
        medicoService.deleteById(id);
        return "redirect:/medicos";
    }

}
