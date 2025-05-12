package com.soccperfil.controllers;

import com.soccperfil.model.Perfil;
import com.soccperfil.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/perfis")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;

    @GetMapping
    public List<Perfil> listar() {
        return perfilRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Perfil> buscarPorId(@PathVariable Integer id) {
        return perfilRepository.findById(id);
    }

    @PostMapping
    public Perfil criar(@RequestBody Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @PutMapping("/{id}")
    public Perfil atualizar(@PathVariable Integer id, @RequestBody Perfil perfilAtualizado) {
        perfilAtualizado.setPerfilId(id);
        return perfilRepository.save(perfilAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        perfilRepository.deleteById(id);
    }
}
