package io.github.italoBall77.SpringSecurity.api.dto;

import io.github.italoBall77.SpringSecurity.domain.entity.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class CadastroUsuarioDTO {

    private Usuario usuario;
    private List<String> permissoes;

}
