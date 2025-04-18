package com.example.crudprova.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaResponseDTO {
        private Long id;
        private String nome;
        private String cpf;
        private String enderecoTrabalho;

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
        public String getEnderecoTrabalho() {
                return enderecoTrabalho;
        }
        public void setEnderecoTrabalho(String enderecoTrabalho) {
                this.enderecoTrabalho = enderecoTrabalho;
        }
}
