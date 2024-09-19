package io.github.evertontech.movepass.service;

import io.github.evertontech.movepass.dto.AcademiaDTO;
import io.github.evertontech.movepass.exception.RegistroNaoEncontradoException;
import io.github.evertontech.movepass.model.entity.Academia;
import io.github.evertontech.movepass.model.repository.AcademiaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AcademiaServiceTest {

    @Autowired
    AcademiaService academiaService;

    @MockBean
    AcademiaRepository academiaRepository;

    public Academia criarAcademia() {
        var numero = new Random().nextLong();
        var academia = new Academia();
        academia.setId(numero);
        academia.setNome("Academia " + numero);
        academia.setEndereco("Endereco " + numero);
        return academia;
    }

    public AcademiaDTO criarDtoFake() {
        var numero = new Random().nextLong();
        return new AcademiaDTO("Academia " + numero, "Endereço " + numero);
    }

    @Test
    @DisplayName("Deve criar uma academia no banco de dados")
    void criarTest() {
        var dto = criarDtoFake();
        when(academiaRepository.save(any(Academia.class))).thenReturn(AcademiaDTO.paraEntidade(dto));
        var academia = academiaService.criar(dto);
        assertNotNull(academia);
        verify(academiaRepository, times(1)).save(any(Academia.class));
    }

    @Test
    @DisplayName("Deve listar todas as academias ativas")
    void listarAcademiasAtivasTest() {
        var academiasMock = Arrays.asList(criarAcademia(), criarAcademia());
        when(academiaRepository.findAllByAtivoTrue()).thenReturn(academiasMock);
        var academias = academiaService.listarTodasAtivas();
        assertNotNull(academias);
        assertNotNull(academias.iterator().next().getId());
        assertTrue(academias.iterator().next().getAtivo());
        verify(academiaRepository, times(1)).findAllByAtivoTrue();
    }

    @Test
    @DisplayName("Deve obter uma academia ativa pelo id")
    void obterPorIdTest() {
        var academiaMock = Optional.of(criarAcademia());
        when(academiaRepository.findByIdAndAtivoTrue(anyLong())).thenReturn(academiaMock);
        var academia = academiaService.obterAtivaPorId(anyLong());
        assertNotNull(academia);
        assertTrue(academia.getAtivo());
        verify(academiaRepository, times(1)).findByIdAndAtivoTrue(anyLong());
    }

    @Test
    @DisplayName("Deve lançar excessão ao tentar obter uma academia inexistente")
    void obterPorIdTest2() {
        Optional<Academia> academiaMock = Optional.empty();
        when(academiaRepository.findByIdAndAtivoTrue(anyLong())).thenReturn(academiaMock);
        assertThrows(RegistroNaoEncontradoException.class, () -> academiaService.obterAtivaPorId(anyLong()));
    }

    @Test
    @DisplayName("Deve atualizar uma academia existente")
    void atualizarAcademiaTest() {
        var academiaMock = criarAcademia();
        when(academiaRepository.findByIdAndAtivoTrue(anyLong())).thenReturn(Optional.of(academiaMock));
        when(academiaRepository.save(any(Academia.class))).thenReturn(academiaMock);
        var academia = academiaService.atualizar(criarDtoFake(), anyLong());
        assertNotNull(academia);
        assertTrue(academia.getAtivo());
    }

    @Test
    @DisplayName("Deve inativar uma academia ativa")
    void inativarAcademiaTest() {
        Optional<Academia> academiaMock = Optional.of(criarAcademia());
        when(academiaRepository.findByIdAndAtivoTrue(anyLong())).thenReturn(academiaMock);
        academiaService.inativar(anyLong());
        assertFalse(academiaMock.get().getAtivo());
    }
}
