package com.soccperfil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soccperfil.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
