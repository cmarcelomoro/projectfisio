package com.example.projectfisio.controller;


import com.example.projectfisio.model.Evolucao;
import com.example.projectfisio.model.Paciente;
import com.example.projectfisio.repository.DadosMedicosRepository;
import com.example.projectfisio.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private DadosMedicosRepository dadosMedicosRepository;
    @Autowired
    private  PacienteService pService;



    @GetMapping(path = "/cadastro")
    public String formCadastro(@ModelAttribute Paciente paciente, Model model){

        model.addAttribute("paciente",new Paciente());
        return "form_paciente";
    }


    @GetMapping(path = "/listar")
    public String listarPacientes(@ModelAttribute Paciente paciente, Model model){

        List<Paciente> listaPacientes = (List<Paciente>) pacienteRepository.findAll();
        model.addAttribute("pacientes",listaPacientes);
        return "tabela_paciente";
    }

    @PostMapping(path = "/salvar")
    public String salvarPaciente(@ModelAttribute Paciente paciente){

        pService.salvarPaciente(paciente);
        return "redirect:/home";
    }

    @GetMapping(path="/excluir/{id}")
    public String excluirPaciente(@PathVariable Integer id,Model model){

        pacienteRepository.deleteById(id);
        List<Paciente> listaPacientes = (List<Paciente>) pacienteRepository.findAll();
        model.addAttribute("pacientes",listaPacientes);
        return "redirect:/paciente/listar";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        // Busca o paciente pelo ID
        Paciente paciente = pService.buscarPaciente(id);

        // Verifica se o paciente existe
        if (paciente !=null) {
            // Adiciona o paciente ao modelo para ser utilizado no formulário
            model.addAttribute("paciente", paciente);
            return "form_edicao_paciente";
        } else {
            // Se o paciente não for encontrado, redireciona para uma página de erro ou outra página apropriada
            return "redirect:/error";
        }
    }

    @PostMapping("/editar/{id}")
    public String processarFormularioEdicao(@PathVariable Long id, @ModelAttribute Paciente paciente) {
        // Atualiza o paciente no banco de dados

        pService.atualizarPaciente(id, paciente);
        return "redirect:/paciente/listar";
    }




}
