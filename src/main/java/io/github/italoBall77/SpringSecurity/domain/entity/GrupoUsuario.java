package io.github.italoBall77.SpringSecurity.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class GrupoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;

    public GrupoUsuario(Grupo grupo, Usuario usuario) {
        this.grupo = grupo;
        this.usuario = usuario;
    }
}
