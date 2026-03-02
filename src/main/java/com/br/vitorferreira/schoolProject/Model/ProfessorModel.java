package com.br.vitorferreira.schoolProject.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "TBL_PROFESSOR")
public class ProfessorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String departamento;

    private String titularidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTitularidade() {
        return titularidade;
    }

    public void setTitularidade(String titularidade) {
        this.titularidade = titularidade;
    }
}
