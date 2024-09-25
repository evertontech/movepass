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
    FuncionarioService funcionarioService;

    @PostMapping
    public Funcionario criar(@RequestBody FuncionarioDTO dto) {
        return funcionarioService.criar(dto);
    }

    @GetMapping
    public Iterable<Funcionario> listar() {
        return funcionarioService.listar();
    }

    @GetMapping(path = "/{id}")
    public Funcionario obterPorId(@PathVariable Long id) {
        return funcionarioService.obterPorId(id);
    }

    @PutMapping(path = "/{id}")
    public Funcionario atualizar(@RequestBody FuncionarioDTO dto, @PathVariable Long id) {
        return funcionarioService.atualizar(dto, id);
    }

    @DeleteMapping(path = "/{id}")
    public void inativar(@PathVariable Long id) {
        funcionarioService.inativar(id);
    }
}
