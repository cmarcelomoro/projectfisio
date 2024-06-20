package com.example.projectfisio.controller;


import com.example.projectfisio.model.Paciente;
import com.example.projectfisio.model.Sessao;
import com.example.projectfisio.repository.PacienteRepository;
import com.example.projectfisio.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping(path="/")
public class HomeController {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    SessaoRepository sessaoRepository;
    @RequestMapping(path="/home")
    public String home(Model model){

        Calendar hoje = Calendar.getInstance();

        int ano = 2024;
        int mes = Calendar.MONTH;
        int dia = Calendar.DAY_OF_MONTH;

        hoje.set(ano,mes,dia);

        List<Paciente> listaPacientes =(List<Paciente>) pacienteRepository.findAll();
        model.addAttribute("novaSessao",new Sessao());
        model.addAttribute("pacientes",listaPacientes);
        model.addAttribute("dia",dia);
        return "home";
    }

    @GetMapping(path="/registrar")
    public String registrarSessao(Model model){

        return "form_sessao";
    }







}
