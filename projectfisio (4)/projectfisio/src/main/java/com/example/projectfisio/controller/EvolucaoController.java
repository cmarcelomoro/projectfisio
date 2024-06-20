package com.example.projectfisio.controller;


import com.example.projectfisio.model.Evolucao;
import com.example.projectfisio.model.Paciente;
import com.example.projectfisio.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/evolucao")
public class EvolucaoController {

    @Autowired
    private PacienteService pService;
    @Autowired
    private EvolucaoService eService;
    @Autowired
    PacienteRepository pacienteRepository;



    @GetMapping("/registrar/{pacienteId}")
    public String carregarFormEvolucao(@PathVariable Long pacienteId, Model model){

        Paciente paciente = pacienteRepository.findById(Math.toIntExact(pacienteId)).orElse(null);
        Evolucao novaEvolucao = new Evolucao();
        novaEvolucao.setPaciente(paciente);

        model.addAttribute("evolucao", novaEvolucao);

        model.addAttribute("paciente",pService.buscarPaciente(pacienteId));

        return "form_evolucao";
    }

    @PostMapping("/salvar/{pacienteId}")
    public String salvarEvolucao(@ModelAttribute Evolucao evolucao,@PathVariable Long pacienteId){

        Paciente paciente = pService.buscarPaciente(pacienteId);

        eService.salvarEvolucao(evolucao,paciente);

        return "redirect:/evolucao/listar/"+pacienteId;
    }
    @GetMapping("/listar/{pacienteId}")
    public String listarEvolucoes(@PathVariable Long pacienteId,Model model){
        List<Evolucao> listaEvolucoes = eService.retornaListaEvolucoes(pacienteId);
        Paciente paciente = pService.buscarPaciente(pacienteId);

        model.addAttribute("paciente",paciente);
        model.addAttribute("evolucoes",listaEvolucoes);

        return "tabela_evolucao";
    }


}
