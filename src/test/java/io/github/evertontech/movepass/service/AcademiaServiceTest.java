package io.github.evertontech.movepass.service;

import io.github.evertontech.movepass.dto.AcademiaDTO;
import io.github.evertontech.movepass.model.entity.Academia;
import io.github.evertontech.movepass.model.repository.AcademiaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AcademiaServiceTest {

    @Autowired
    AcademiaService academiaService;

    @MockBean
    AcademiaRepository academiaRepository;

    @Test
    @DisplayName("Deve criar uma academia no banco de dados")
    void criarTest() {
        var dto = new AcademiaDTO("HE Fitness", "Av. Campos do Jordão");
        when(academiaRepository.save(any(Academia.class))).thenReturn(AcademiaDTO.paraEntidade(dto));
        var resposta = academiaService.criar(dto);
        assertNotNull(resposta);
        verify(academiaRepository, times(1)).save(any(Academia.class));
    }
}
