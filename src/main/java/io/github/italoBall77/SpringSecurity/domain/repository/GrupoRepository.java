package io.github.italoBall77.SpringSecurity.domain.repository;

import io.github.italoBall77.SpringSecurity.domain.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface GrupoRepository extends JpaRepository<Grupo, String> {

    Optional<Grupo> findByNome(String nome);
}
