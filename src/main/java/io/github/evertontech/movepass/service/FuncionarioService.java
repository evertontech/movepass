package io.github.evertontech.movepass.service;

import io.github.evertontech.movepass.dto.FuncionarioDTO;
import io.github.evertontech.movepass.exception.RegistroNaoEncontradoException;
import io.github.evertontech.movepass.model.entity.Funcionario;
import io.github.evertontech.movepass.model.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public Funcionario criar(FuncionarioDTO dto) {
        var entidade = FuncionarioDTO.paraEntidade(dto);
        return funcionarioRepository.save(entidade);
    }

    public Iterable<Funcionario> listar() {
        return funcionarioRepository.findAllByAtivoTrue();
    }

    public Funcionario obterPorId(Long id) {
        var pesquisa = funcionarioRepository.findByIdAndAtivoTrue(id);
        if (pesquisa.isEmpty()) {
            throw new RegistroNaoEncontradoException();
        }
        return pesquisa.get();
    }

    public Funcionario atualizar(FuncionarioDTO dto, Long id) {
        obterPorId(id);
        var entidade = FuncionarioDTO.paraEntidade(dto, id);
        return funcionarioRepository.save(entidade);
    }

    public void inativar(Long id) {
        var funcionario = obterPorId(id);
        funcionario.inativar();
        funcionarioRepository.save(funcionario);
    }
}
