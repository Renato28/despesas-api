package org.github.minhascontas_api.repository;

import org.github.minhascontas_api.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
