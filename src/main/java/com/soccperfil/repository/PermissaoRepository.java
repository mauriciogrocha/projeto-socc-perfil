package com.soccperfil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soccperfil.model.Permissao;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Integer> {
}
