package io.github.evertontech.movepass.controller;

import io.github.evertontech.movepass.dto.EmpresaDTO;
import io.github.evertontech.movepass.model.entity.Empresa;
import io.github.evertontech.movepass.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public Empresa criar(@RequestBody EmpresaDTO dto) {
        return empresaService.criar(dto);
    }

    @GetMapping
    public Iterable<Empresa> listar() {
        return empresaService.listar();
    }

    @GetMapping(path = "/{id}")
    public Optional<Empresa> obterPorId(@PathVariable Long id) {
        return empresaService.obterPorId(id);
    }
}
