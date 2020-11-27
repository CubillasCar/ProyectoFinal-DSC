package com.hospital.controller;

import com.hospital.model.Especialidad;
import com.hospital.service.core.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EspecialidadController {


    @Autowired
    private IEspecialidadService especialidadService;

//    public EspecialidadController(EspecialidadService especialidadService) {
//        this.especialidadService = especialidadService;
//    }

    @GetMapping("/especialidades")
    public String especialidadList(Model model){
        model.addAttribute("especialidades", especialidadService.findAll());
        return "especialidades";
    }

    @GetMapping("/especialidades/add")
    public String especialidadAdd(Model model){
        model.addAttribute("especialidad", new Especialidad());
        return "especialidadAdd";
    }

    @PostMapping("/especialidades/save")
    public String especialidadSave(Especialidad especialidad){
        especialidadService.createOrUpdate(especialidad);
        return "redirect:/especialidades";
    }

    @GetMapping("/especialidades/edit/{id}")
    public String especialidadEdit(Model model, @PathVariable Integer id){
        model.addAttribute("especialidad", especialidadService.findById(id));
        return "especialidadAdd";
    }

    @GetMapping("/especialidades/delete/{id}")
    public String especialidadDelete(Model model, @PathVariable Integer id){
        especialidadService.deleteById(id);
        return "redirect:/especialidades";
    }


}
