package io.github.evertontech.movepass.model.repository;

import io.github.evertontech.movepass.model.entity.Funcionario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

    Optional<Funcionario> findByIdAndAtivoTrue(Long id);

    Iterable<Funcionario> findAllByAtivoTrue();
}
