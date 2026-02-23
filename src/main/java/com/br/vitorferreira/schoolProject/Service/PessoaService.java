package com.br.vitorferreira.schoolProject.Service;


import com.br.vitorferreira.schoolProject.Model.PessoaModel;
import com.br.vitorferreira.schoolProject.Repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaModel> findAll(){
        return pessoaRepository.findAll();
    }

    public PessoaModel criarPessoa(PessoaModel pessoaModel){
        return pessoaRepository.save(pessoaModel);
    }

    public Optional<PessoaModel> findById(Long id){
        return pessoaRepository.findById(id);
    }

    public void deleteById(long id){
        pessoaRepository.deleteById(id);
    }

}
