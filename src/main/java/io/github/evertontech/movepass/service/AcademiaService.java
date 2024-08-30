package io.github.evertontech.movepass.service;

import io.github.evertontech.movepass.dto.AcademiaDTO;
import io.github.evertontech.movepass.model.entity.Academia;
import io.github.evertontech.movepass.model.repository.AcademiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Iterable<Academia> listarTodasAtivas() {
        return academiaRepository.findAllByAtivoTrue();
    }

    public Optional<Academia> ObterAtivaPorId(Long id) {
        return academiaRepository.findByIdAndAtivoTrue(id);
    }
}
