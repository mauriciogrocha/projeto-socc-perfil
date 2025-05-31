package com.soccperfil.controller;

import com.soccperfil.Service.PerfilService;
import com.soccperfil.model.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/perfis")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<Perfil> listar() {
        return perfilService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Perfil> buscarPorId(@PathVariable Integer id) {
        return perfilService.buscarPorId(id);
    }

    @PostMapping
    public Perfil criar(@RequestBody Perfil perfil) {
        return perfilService.criar(perfil);
    }

    @PutMapping("/{id}")
    public Perfil atualizar(@PathVariable Integer id, @RequestBody Perfil perfilAtualizado) {
        return perfilService.atualizar(id, perfilAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        perfilService.deletar(id);
    }
}
