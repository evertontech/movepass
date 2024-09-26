package io.github.evertontech.movepass.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;

    private String nome;

    private Boolean ativo;

    @OneToMany
    @JoinColumn(name = "empresa_id")
    private List<Funcionario> funcionarios;
}
