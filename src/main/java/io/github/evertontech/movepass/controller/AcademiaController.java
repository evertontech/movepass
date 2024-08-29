package io.github.evertontech.movepass.controller;

import io.github.evertontech.movepass.dto.AcademiaDTO;
import io.github.evertontech.movepass.model.entity.Academia;
import io.github.evertontech.movepass.service.AcademiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/academias")
@Tag(name = "Academia", description = "Endpoints para Gerenciar Academias")
public class AcademiaController {

    @Autowired
    AcademiaService academiaService;

    @PostMapping
    @Operation(summary = "Cria uma Academia")
    public Academia criar(@RequestBody AcademiaDTO dto) {
        return academiaService.criar(dto);
    }

    @GetMapping
    @Operation(summary = "Lista Todas as Academias")
    public Iterable<Academia> listarTodos() {
        return academiaService.listarTodos();
    }
}
