package io.github.evertontech.movepass.dto;

import io.github.evertontech.movepass.model.entity.Empresa;
import io.github.evertontech.movepass.model.entity.Funcionario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDTO {

    private String nome;
    private String email;

    public static Funcionario paraEntidade(FuncionarioDTO dto, Long empresaId, Long funcionarioId) {
        var funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setId(funcionarioId);
        funcionario.setEmpresa(new Empresa());
        funcionario.getEmpresa().setId(empresaId);
        return funcionario;
    }

    public static Funcionario paraEntidade(FuncionarioDTO dto, Long empresaId) {
        return paraEntidade(dto, empresaId, null);
    }
}
