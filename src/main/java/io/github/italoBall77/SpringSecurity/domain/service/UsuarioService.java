package io.github.italoBall77.SpringSecurity.domain.service;

import io.github.italoBall77.SpringSecurity.domain.entity.Grupo;
import io.github.italoBall77.SpringSecurity.domain.entity.GrupoUsuario;
import io.github.italoBall77.SpringSecurity.domain.entity.Usuario;
import io.github.italoBall77.SpringSecurity.domain.repository.GrupoRepository;
import io.github.italoBall77.SpringSecurity.domain.repository.UsuarioGrupoRepository;
import io.github.italoBall77.SpringSecurity.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioGrupoRepository usuarioGrupoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario salvar(Usuario usuario, List<String> grupos){
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        usuarioRepository.save(usuario);

       List<GrupoUsuario> listaUsuarioGrupo =  grupos.stream().map( nomeGrupo -> {
                    Optional<Grupo> possivelGrupo = grupoRepository.findByNome(nomeGrupo);
                    if(possivelGrupo.isPresent()){
                        Grupo grupo = possivelGrupo.get();
                        return new GrupoUsuario(grupo,usuario);
                    }
                    return null;
                }).filter(grupo -> grupo != null).collect(Collectors.toList());

        usuarioGrupoRepository.saveAll(listaUsuarioGrupo);

        return usuario;
    }


}
