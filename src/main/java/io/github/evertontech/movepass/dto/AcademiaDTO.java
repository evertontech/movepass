package io.github.evertontech.movepass.dto;

import io.github.evertontech.movepass.model.entity.Academia;
import jakarta.validation.MessageInterpolator;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AcademiaDTO(
        @NotBlank @Size(min = 3, max = 35) String nome,
        @NotBlank String endereco) {

    public static Academia paraEntidade(AcademiaDTO dto, Long id) {
        var entidade = new Academia();
        entidade.setId(id);
        entidade.setNome(dto.nome());
        entidade.setEndereco(dto.endereco());
        return entidade;
    }

    public static Academia paraEntidade(AcademiaDTO dto) {
        return paraEntidade(dto, null);
    }
}
