package io.github.evertontech.movepass.model.repository;

import io.github.evertontech.movepass.model.entity.Academia;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AcademiaRepository extends CrudRepository<Academia, Long> {

    Iterable<Academia> findAllByAtivoTrue();

    Optional<Academia> findByIdAndAtivoTrue(Long id);
}
