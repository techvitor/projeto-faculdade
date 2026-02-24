package com.br.vitorferreira.schoolProject.Controller;

import com.br.vitorferreira.schoolProject.Model.PessoaModel;
import com.br.vitorferreira.schoolProject.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public Optional<PessoaModel> procurarPorId(@PathVariable Long id){
        return pessoaService.procurarPorId(id);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        pessoaService.deleteById(id);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity alterarPessoa(@RequestBody PessoaModel pessoaModel, @PathVariable Long id){
        return pessoaService.alterarPessoa(pessoaModel, id).map(pessoaExistente -> {
            pessoaModel.setId(id);
            PessoaModel atualizado = pessoaService.criarPessoa(pessoaExistente);

            return ResponseEntity.ok(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }


}
