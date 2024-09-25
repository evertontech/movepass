package io.github.evertontech.movepass.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private LocalDate dataContratacao;
    private Boolean ativo;

    public Funcionario() {
        this.setDataContratacao(LocalDate.now());
        this.setAtivo(true);
    }

    public void inativar() {
        this.setAtivo(false);
    }
}
