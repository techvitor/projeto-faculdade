package com.br.vitorferreira.schoolProject.Service;


import com.br.vitorferreira.schoolProject.Model.ProfessorModel;
import com.br.vitorferreira.schoolProject.Repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorModel criarProfessor(ProfessorModel professorModel){
        return professorRepository.save(professorModel);
    }

    public void deletarProfessorId(Long id){
        professorRepository.deleteById(id);
    }

    public Optional<ProfessorModel> procurarPorId(Long id){
        return professorRepository.findById(id);
    }

    public List<ProfessorModel> listarProfessores(){
        return professorRepository.findAll();
    }

    public Optional<ProfessorModel> alterarProfessor(ProfessorModel novosDados, Long id){
        return  professorRepository.findById(id).map(professorExistente -> {
            professorExistente.setNome(novosDados.getNome());
            professorExistente.setDepartamento(novosDados.getDepartamento());
            professorExistente.setTitularidade(novosDados.getTitularidade());

            return professorRepository.save(professorExistente);
        });
    }
}
