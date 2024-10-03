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

    public Funcionario criarFuncionario(FuncionarioDTO dto, Long empresaId) {
        var entidade = FuncionarioDTO.paraEntidade(dto, empresaId);
        return funcionarioRepository.save(entidade);
    }

    public Iterable<Funcionario> listarFuncionariosAtivos() {
        return funcionarioRepository.findAllByAtivoTrue();
    }

    public Iterable<Funcionario> listarFuncionariosAtivosPorEmpresaId(Long id) {
        return funcionarioRepository.findAllByAtivoTrueAndEmpresaId(id);
    }

    public Funcionario obterFuncionarioAtivoPorId(Long id) {
        var pesquisa = funcionarioRepository.findByIdAndAtivoTrue(id);
        if (pesquisa.isEmpty()) {
            throw new RegistroNaoEncontradoException();
        }
        return pesquisa.get();
    }

    public Funcionario atualizarFuncionarioAtivo(FuncionarioDTO dto, Long id) {
        obterFuncionarioAtivoPorId(id);
        var entidade = FuncionarioDTO.paraEntidade(dto, id);
        return funcionarioRepository.save(entidade);
    }

    public void inativarFuncionarioAtivo(Long id) {
        var funcionario = obterFuncionarioAtivoPorId(id);
        funcionario.inativar();
        funcionarioRepository.save(funcionario);
    }
}
