package io.github.italoBall77.SpringSecurity.api;

import io.github.italoBall77.SpringSecurity.domain.entity.Grupo;
import io.github.italoBall77.SpringSecurity.domain.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoRepository grupoRepository;

    @PostMapping
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Grupo> salvar(@RequestBody Grupo grupo){
        grupoRepository.save(grupo);
        return ResponseEntity.ok(grupo);
    }


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Grupo>> listar(){
        return ResponseEntity.ok(grupoRepository.findAll());
    }


}
