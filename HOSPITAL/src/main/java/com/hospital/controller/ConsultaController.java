package com.hospital.controller;

import com.hospital.model.Consulta;
import com.hospital.service.core.IConsultaService;
import com.hospital.service.core.IEspecialidadService;
import com.hospital.service.core.IMedicoService;

import com.hospital.service.core.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConsultaController {

    @Autowired
    private IConsultaService consultaService;

    @Autowired
    private PacienteServiceImpl pacienteService;
    @Autowired
    private IMedicoService medicoService;
    @Autowired
    private IEspecialidadService especialidadService;


//    public ConsultaController(ConsultaService consultaService, PacienteService pacienteService, MedicoService medicoService, EspecialidadService especialidadService) {
//        this.consultaService = consultaService;
//        this.pacienteService = pacienteService;
//        this.medicoService = medicoService;
//        this.especialidadService = especialidadService;
//    }

    @GetMapping("/consultas")
    public String consultaList(Model model){
        model.addAttribute("consultas", consultaService.findAll());
        return "consultas";
    }

    @GetMapping("/consultas/add")
    public String consultaAdd(Model model){
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("pacientes", pacienteService.findAll());
        model.addAttribute("medicos", medicoService.findAll());
        model.addAttribute("especialidades", especialidadService.findAll());

        return "consultaAdd";
    }

    @PostMapping("/consultas/save")
    public String consultaSave(Consulta consulta){
        consultaService.createOrUpdate(consulta);
        return "redirect:/consultas";

    }

    @GetMapping("/consultas/edit/{id}")
    public String consultaEdit(Model model, @PathVariable Integer id){
        model.addAttribute("consulta", consultaService.findById(id));
        model.addAttribute("pacientes", pacienteService.findAll());
        model.addAttribute("medicos", medicoService.findAll());
        model.addAttribute("especialidades", especialidadService.findAll());

        return "consultaAdd";
    }

    @GetMapping("/consultas/delete/{id}")
    public String consultaDelete(Model model, @PathVariable Integer id){
        consultaService.deleteById(id);
        return "redirect:/consultas";
    }
}

























