package com.example.crudprova.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {
    private Long id;
    private String nome;
    private String cpf;
    private Long trabalhoId;

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
    public Long getTrabalhoId() {
        return trabalhoId;
    }
    public void setTrabalhoId(Long trabalhoId) {
        this.trabalhoId = trabalhoId;
    }
}

