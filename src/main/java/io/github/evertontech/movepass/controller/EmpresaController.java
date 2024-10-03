package io.github.evertontech.movepass.controller;

import io.github.evertontech.movepass.dto.EmpresaDTO;
import io.github.evertontech.movepass.dto.FuncionarioDTO;
import io.github.evertontech.movepass.model.entity.Empresa;
import io.github.evertontech.movepass.model.entity.Funcionario;
import io.github.evertontech.movepass.service.EmpresaService;
import io.github.evertontech.movepass.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public Empresa criar(@RequestBody EmpresaDTO dto) {
        return empresaService.criar(dto);
    }

    @PostMapping(path = "/{empresaId}/funcionarios")
    public Funcionario criarFuncionario(@RequestBody FuncionarioDTO dto, @PathVariable Long empresaId) {
        return funcionarioService.criarFuncionario(dto, empresaId);
    }

    @GetMapping
    public Iterable<Empresa> listar() {
        return empresaService.listar();
    }

    @GetMapping(path = "/{empresaId}/funcionarios")
    public Iterable<Funcionario> listarFuncionariosAtivosPorEmpresaId(@PathVariable Long empresaId) {
        return funcionarioService.listarFuncionariosAtivosPorEmpresaId(empresaId);
    }

    @GetMapping(path = "/{empresaId}")
    public Optional<Empresa> obterEmpresaPorId(@PathVariable Long empresaId) {
        return empresaService.obterPorId(empresaId);
    }
}
