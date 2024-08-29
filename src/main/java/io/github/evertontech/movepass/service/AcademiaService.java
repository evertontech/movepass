package io.github.evertontech.movepass.service;

import io.github.evertontech.movepass.dto.AcademiaDTO;
import io.github.evertontech.movepass.model.entity.Academia;
import io.github.evertontech.movepass.model.repository.AcademiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademiaService {

    @Autowired
    AcademiaRepository academiaRepository;

    public Academia criar(AcademiaDTO dto) {
        var entidade = new Academia();
        entidade.setNome(dto.nome());
        entidade.setEndereco(dto.endereco());
        return academiaRepository.save(entidade);
    }

    public Iterable<Academia> listarTodos() {
        return academiaRepository.findAll();
    }
}
