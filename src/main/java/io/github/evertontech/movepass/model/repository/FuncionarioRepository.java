package io.github.evertontech.movepass.model.repository;

import io.github.evertontech.movepass.model.entity.Academia;
import io.github.evertontech.movepass.model.entity.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

}
