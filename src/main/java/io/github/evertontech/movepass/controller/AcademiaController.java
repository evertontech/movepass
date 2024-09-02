package io.github.evertontech.movepass.controller;

import io.github.evertontech.movepass.dto.AcademiaDTO;
import io.github.evertontech.movepass.exception.RegistroNaoEncontradoException;
import io.github.evertontech.movepass.model.entity.Academia;
import io.github.evertontech.movepass.service.AcademiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/academias")
@Tag(name = "Academia", description = "Endpoints para Gerenciar Academias")
public class AcademiaController {

    @Autowired
    AcademiaService academiaService;

    @ExceptionHandler(RegistroNaoEncontradoException.class)
    public ResponseEntity<String> registroNaoEncontrado(RegistroNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @PostMapping
    @Operation(summary = "Criar uma Academia")
    public ResponseEntity<Academia> criar(@RequestBody @Valid AcademiaDTO dto) {
        var academia = academiaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(academia);
    }

    @GetMapping
    @Operation(summary = "Listar Todas as Academias Ativas")
    public ResponseEntity<Iterable<Academia>> listarTodasAtivas() {
        var academias = academiaService.listarTodasAtivas();
        return ResponseEntity.ok(academias);
    }

    @GetMapping(path = {"/{id}"})
    @Operation(summary = "Obter Academia Ativa por Id")
    public ResponseEntity<Academia> obterAtivaPorId(@PathVariable Long id) {
        var academia = academiaService.obterAtivaPorId(id);
        return ResponseEntity.ok(academia);
    }

    @PutMapping(path = {"/{id}"})
    @Operation(summary = "Atualizar academia por Id")
    public ResponseEntity<Academia> atualizar(@RequestBody @Valid AcademiaDTO dto, @PathVariable Long id) {
        var academia = academiaService.atualizar(dto, id);
        return ResponseEntity.ok(academia);
    }

    @DeleteMapping(path = {"/{id}"})
    @Operation(summary = "Inativar Academia por Id")
    public ResponseEntity<Academia> inativar(@PathVariable Long id) {
        var academia = academiaService.inativar(id);
        return ResponseEntity.ok(academia);
    }
}
