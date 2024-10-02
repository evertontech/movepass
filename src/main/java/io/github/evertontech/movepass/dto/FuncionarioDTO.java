package io.github.evertontech.movepass.dto;

import io.github.evertontech.movepass.model.entity.Funcionario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDTO {

    private String nome;
    private String email;

    public static Funcionario paraEntidade(FuncionarioDTO dto, Long id) {
        var entidade = new Funcionario();
        entidade.setNome(dto.getNome());
        entidade.setEmail(dto.getEmail());
        entidade.setId(id);
        return entidade;
    }

    public static Funcionario paraEntidade(FuncionarioDTO dto) {
        return paraEntidade(dto, null);
    }
}
