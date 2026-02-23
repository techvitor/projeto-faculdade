package com.br.vitorferreira.schoolProject.Controller;

import com.br.vitorferreira.schoolProject.Model.PessoaModel;
import com.br.vitorferreira.schoolProject.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoalController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaModel> findAll(){
        return  pessoaService.findAll();
    }

    @PostMapping
    public PessoaModel criarPessoa(@RequestBody PessoaModel pessoaModel){
        return  pessoaService.criarPessoa(pessoaModel);
    }

    @GetMapping("/newGet/{id}")
    public Optional<PessoaModel> findById(@PathVariable Long id){
        return pessoaService.findById(id);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        pessoaService.deleteById(id);
    }

}
