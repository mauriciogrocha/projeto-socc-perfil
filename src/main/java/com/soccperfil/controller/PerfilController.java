package com.soccperfil.controller;

import com.soccperfil.DTO.PerfilDTO;
import com.soccperfil.Service.PerfilService;
import com.soccperfil.model.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/perfis")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<PerfilDTO> listar() {

          return perfilService.listarTodos().stream()
                .map(PerfilDTO::new)
                .collect(Collectors.toList());
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
    
    @GetMapping("/tipos")
    public List<String> listarTiposPerfil() {
        return perfilService.listarTiposPerfil();
    }
}
