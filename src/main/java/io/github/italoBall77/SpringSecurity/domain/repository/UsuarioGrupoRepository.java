package io.github.italoBall77.SpringSecurity.domain.repository;

import io.github.italoBall77.SpringSecurity.domain.entity.GrupoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioGrupoRepository extends JpaRepository<GrupoUsuario, String> {
}
