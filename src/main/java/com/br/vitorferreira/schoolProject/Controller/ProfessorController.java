package com.br.vitorferreira.schoolProject.Controller;


import com.br.vitorferreira.schoolProject.Model.ProfessorModel;
import com.br.vitorferreira.schoolProject.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/professor")
public class ProfessorController {


    @Autowired
    private ProfessorService professorService;


    @GetMapping
    public List<ProfessorModel> listarProfessores(){
        return professorService.listarProfessores();
    }

    @GetMapping("/{id}")
    public Optional<ProfessorModel> procurarPorId(@PathVariable Long id){
        return professorService.procurarPorId(id);
    }

    @PostMapping
    public ProfessorModel criarProfessor(@RequestBody ProfessorModel professorModel){
        return professorService.criarProfessor(professorModel);
    }


    @DeleteMapping("/delete/{id}")
    public void deletarProfessor(@PathVariable Long id){
        professorService.deletarProfessorId(id);
    }

    @PutMapping("/put/{id}")
    public Optional<ProfessorModel> alterarProfesor(@PathVariable Long id, @RequestBody ProfessorModel professorModel){
        return professorService.alterarProfessor(professorModel, id).map(professorExistente -> {
            professorModel.setId(id);
            professorExistente.setNome(professorModel.getNome());
            professorExistente.setDepartamento(professorModel.getDepartamento());
            professorExistente.setTitularidade(professorModel.getTitularidade());
            ProfessorModel professorAtualizado = professorService.criarProfessor(professorExistente);

            return professorService.criarProfessor(professorAtualizado);
        });
    }



}


