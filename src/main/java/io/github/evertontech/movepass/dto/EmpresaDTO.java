package io.github.evertontech.movepass.dto;

import io.github.evertontech.movepass.model.entity.Empresa;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
public class EmpresaDTO {

    @NotNull
    @Size(min = 3)
    private String nome;

    @NotNull
    @CNPJ
    private String cnpj;

    public static Empresa paraEntidade(EmpresaDTO dto, Long id) {
        var entidade = new Empresa();
        entidade.setId(id);
        entidade.setNome(dto.getNome());
        entidade.setCnpj(dto.getCnpj());
        return entidade;
    }

    public static Empresa paraEntidade(EmpresaDTO dto) {
        return paraEntidade(dto, null);
    }
}
