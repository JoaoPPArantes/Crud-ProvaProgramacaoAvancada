package com.example.crudprova.service;


import com.example.crudprova.dto.TrabalhoDTO;
import com.example.crudprova.entites.Trabalho;
import com.example.crudprova.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public TrabalhoDTO salvar(TrabalhoDTO dto) {
        Trabalho trabalho = new Trabalho();
        trabalho.setEndereco(dto.getEndereco());
        trabalho = trabalhoRepository.save(trabalho);
        return toDTO(trabalho);
    }

    public List<TrabalhoDTO> listar() {
        return trabalhoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public TrabalhoDTO buscarPorId(Long id) {
        Trabalho trabalho = trabalhoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Trabalho não encontrado"));

        return toDTO(trabalho);
    }

    public TrabalhoDTO atualizar(Long id, TrabalhoDTO dto) {
        Trabalho trabalho = trabalhoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Trabalho não encontrado"));
        trabalho.setEndereco(dto.getEndereco());
        trabalho = trabalhoRepository.save(trabalho);
        return toDTO(trabalho);
    }

    public void deletar(Long id) {
        trabalhoRepository.deleteById(id);
    }

    private TrabalhoDTO toDTO(Trabalho trabalho) {
        TrabalhoDTO dto = new TrabalhoDTO();
        dto.setId(trabalho.getId());
        dto.setEndereco(trabalho.getEndereco());
        return dto;
    }

}
