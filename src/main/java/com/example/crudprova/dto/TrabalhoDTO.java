package com.example.crudprova.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrabalhoDTO {
    private Long id;
    private String endereco;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
