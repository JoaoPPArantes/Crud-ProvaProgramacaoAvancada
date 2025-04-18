package com.example.crudprova.service;


import com.example.crudprova.dto.PessoaDTO;
import com.example.crudprova.dto.PessoaResponseDTO;
import com.example.crudprova.entites.Pessoa;
import com.example.crudprova.entites.Trabalho;
import com.example.crudprova.repository.PessoaRepository;
import com.example.crudprova.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {


    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public PessoaResponseDTO salvar(PessoaDTO dto) {
        Trabalho trabalho = trabalhoRepository.findById(dto.getTrabalhoId())
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setCpf(dto.getCpf());
        pessoa.setTrabalho(trabalho);

        pessoa = pessoaRepository.save(pessoa);

        return toResponseDTO(pessoa);
    }

    public List<PessoaResponseDTO> listarTodas() {
        return pessoaRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public PessoaResponseDTO buscarPorId(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));
        return toResponseDTO(pessoa);
    }

    public PessoaResponseDTO atualizar(Long id, PessoaDTO dto) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa nao encontrada"));

        Trabalho trabalho = trabalhoRepository.findById(dto.getTrabalhoId())
                .orElseThrow(() -> new IllegalArgumentException("Trabalho não encontrado"));


        pessoa.setNome(dto.getNome());
        pessoa.setCpf(dto.getCpf());
        pessoa.setTrabalho(trabalho);

        pessoa = pessoaRepository.save(pessoa);

        return toResponseDTO(pessoa);
    }

    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }

    private PessoaResponseDTO toResponseDTO(Pessoa pessoa) {
        PessoaResponseDTO dto = new PessoaResponseDTO();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setCpf(pessoa.getCpf());
        dto.setEnderecoTrabalho(pessoa.getTrabalho().getEndereco());
        return dto;
    }


}
