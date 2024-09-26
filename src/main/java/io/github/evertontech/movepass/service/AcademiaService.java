package io.github.evertontech.movepass.service;

import io.github.evertontech.movepass.dto.AcademiaDTO;
import io.github.evertontech.movepass.exception.RegistroNaoEncontradoException;
import io.github.evertontech.movepass.model.entity.Academia;
import io.github.evertontech.movepass.model.repository.AcademiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademiaService {

    @Autowired
    AcademiaRepository academiaRepository;

    public Academia criarAcademia(AcademiaDTO dto) {
        var entidade = AcademiaDTO.paraEntidade(dto);
        return academiaRepository.save(entidade);
    }

    public Iterable<Academia> listarTodasAsAcademiasAtivas() {
        return academiaRepository.findAllByAtivoTrue();
    }

    public Academia obterAcademiaAtivaPorId(Long id) {
        var pesquisa = academiaRepository.findByIdAndAtivoTrue(id);
        if (pesquisa.isEmpty()) {
            throw new RegistroNaoEncontradoException();
        }
        return pesquisa.get();
    }

    public Academia atualizarAcademiaAtiva(AcademiaDTO dto, Long id) {
        obterAcademiaAtivaPorId(id);
        var entidade = AcademiaDTO.paraEntidade(dto, id);
        return academiaRepository.save(entidade);
    }

    public Academia inativarAcademiaAtiva(Long id) {
        var entidade = obterAcademiaAtivaPorId(id);
        entidade.inativar();
        return academiaRepository.save(entidade);
    }
}
