package org.github.minhascontas_api.repository;

import org.github.minhascontas_api.domain.Categoria;
import org.github.minhascontas_api.domain.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    Optional<Despesa> findByCategoria(Categoria categoria);
}
