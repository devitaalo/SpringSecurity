package io.github.italoBall77.SpringSecurity.domain.repository;

import io.github.italoBall77.SpringSecurity.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
