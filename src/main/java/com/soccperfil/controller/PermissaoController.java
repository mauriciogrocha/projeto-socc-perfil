package com.soccperfil.controller;

import com.soccperfil.model.Permissao;
import com.soccperfil.repository.PermissaoRepository;

import com.soccperfil.model.Perfil;
import com.soccperfil.repository.PerfilRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/permissoes")
public class PermissaoController {

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @GetMapping
    public List<Permissao> listar() {
        return permissaoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Permissao permissao) {
        permissaoRepository.save(permissao);
        return ResponseEntity.ok("Permissao criada com sucesso!");
    }

}
