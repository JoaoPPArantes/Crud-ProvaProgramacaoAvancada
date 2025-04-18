package com.example.crudprova.entites;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "trabalho_id")
    private Trabalho trabalho;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Trabalho getTrabalho() {
        return trabalho;
    }
    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

}
