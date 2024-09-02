package io.github.evertontech.movepass.dto;

import io.github.evertontech.movepass.model.entity.Academia;

public record AcademiaDTO(String nome, String endereco) {

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
