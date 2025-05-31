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

    //URI final - permissoes/{permissaoId}/perfis/{perfilId}
    @PutMapping("/{permissaoId}/perfis/{perfilId}")
    public ResponseEntity<String> atribuir(@PathVariable Integer permissaoId, @PathVariable Integer perfilId) {
        Optional<Permissao> permissaoOpt = permissaoRepository.findById(permissaoId);
        Optional<Perfil> perfilOpt = perfilRepository.findById(perfilId);

        if (permissaoOpt.isEmpty() || perfilOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Perfil perfil = perfilOpt.get();
        perfil.getPermissoes().add(permissaoOpt.get());
        perfilRepository.save(perfil);

        return ResponseEntity.ok("Permissão atribuida com sucesso!");
    }

    @DeleteMapping("/{permissaoId}/perfis/{perfilId}")
    public ResponseEntity<String> deletar(@PathVariable Integer permissaoId, @PathVariable Integer perfilId) {
        Optional<Permissao> permissaoOpt = permissaoRepository.findById(permissaoId);
        Optional<Perfil> perfilOpt = perfilRepository.findById(perfilId);

        if (permissaoOpt.isEmpty() || perfilOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Perfil perfil = perfilOpt.get();
        perfil.getPermissoes().remove(permissaoOpt.get());
        perfilRepository.save(perfil);

        return ResponseEntity.ok("Permissão removida com sucesso!");
    }
}
