package io.github.evertontech.movepass.controller;

import io.github.evertontech.movepass.dto.FuncionarioDTO;
import io.github.evertontech.movepass.model.entity.Funcionario;
import io.github.evertontech.movepass.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public Iterable<Funcionario> listarFuncionariosAtivos() {
        return funcionarioService.listarFuncionariosAtivos();
    }

    @GetMapping(path = "/{id}")
    public Funcionario obterFuncionarioAtivoPorId(@PathVariable Long id) {
        return funcionarioService.obterFuncionarioAtivoPorId(id);
    }

    @PutMapping(path = "/{id}")
    public Funcionario atualizarFuncionarioAtivo(@RequestBody FuncionarioDTO dto, @PathVariable Long id) {
        return funcionarioService.atualizarFuncionarioAtivo(dto, id);
    }

    @DeleteMapping(path = "/{id}")
    public void inativarFuncionarioAtivo(@PathVariable Long id) {
        funcionarioService.inativarFuncionarioAtivo(id);
    }
}
