package io.github.evertontech.movepass.service;

import io.github.evertontech.movepass.dto.EmpresaDTO;
import io.github.evertontech.movepass.model.entity.Empresa;
import io.github.evertontech.movepass.model.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa criar(EmpresaDTO dto) {
        var entidade = EmpresaDTO.paraEntidade(dto);
        return empresaRepository.save(entidade);
    }

    public Iterable<Empresa> listar() {
        return empresaRepository.findAllByAtivoTrue();
    }

    public Optional<Empresa> obterPorId(Long id) {
        return empresaRepository.findByIdAndAtivoTrue(id);
    }

    public Empresa atualizar(EmpresaDTO dto, Long empresaId) {
        var entidade = EmpresaDTO.paraEntidade(dto, empresaId);
        return empresaRepository.save(entidade);
    }
}
