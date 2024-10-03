package io.github.evertontech.movepass.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Boolean ativo;
    private LocalDate dataContratacao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Funcionario() {
        this.setDataContratacao(LocalDate.now());
        this.setAtivo(true);
    }

    public void inativar() {
        this.setAtivo(false);
    }
}
