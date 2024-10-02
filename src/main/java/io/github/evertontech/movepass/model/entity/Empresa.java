package io.github.evertontech.movepass.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<Funcionario> funcionarios;

    public Empresa() {
        this.setAtivo(true);
    }
}
