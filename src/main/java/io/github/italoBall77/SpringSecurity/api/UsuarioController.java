package io.github.italoBall77.SpringSecurity.api;


import io.github.italoBall77.SpringSecurity.api.dto.CadastroUsuarioDTO;
import io.github.italoBall77.SpringSecurity.domain.entity.Usuario;
import io.github.italoBall77.SpringSecurity.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Usuario> salvar(@RequestBody CadastroUsuarioDTO cadastroUsuarioDTO){
        Usuario usuarioSalvo = usuarioService.salvar(cadastroUsuarioDTO.getUsuario(),cadastroUsuarioDTO.getPermissoes());

        return ResponseEntity.ok(usuarioSalvo);

    }


}
