package io.github.evertontech.movepass.model.repository;

import io.github.evertontech.movepass.model.entity.Empresa;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

    Optional<Empresa> findByIdAndAtivoTrue(Long id);

    Iterable<Empresa> findAllByAtivoTrue();
}
