package com.soccperfil.Service;

import com.soccperfil.model.Perfil;
import com.soccperfil.model.Permissao;
import com.soccperfil.model.TipoPerfil;
import com.soccperfil.repository.PerfilRepository;
import com.soccperfil.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Set;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Perfil> listarTodos() {
        return perfilRepository.findAll();
    }

    public Optional<Perfil> buscarPorId(Integer id) {
        return perfilRepository.findById(id);
    }

    public Perfil criar(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public Perfil atualizar(Integer id, Perfil perfilAtualizado) {
        // Aqui você pode verificar se o perfil existe antes de atualizar, por exemplo:
        Optional<Perfil> perfilExistente = perfilRepository.findById(id);
        if (perfilExistente.isPresent()) {
            perfilAtualizado.setPerfilId(id);
            return perfilRepository.save(perfilAtualizado);
        } else {
            // Pode lançar exceção ou retornar null — depende do seu design
            throw new RuntimeException("Perfil não encontrado com id: " + id);
        }
    }

    public void deletar(Integer id) {
        perfilRepository.deleteById(id);
    }
    
    public List<String> listarTiposPerfil() {
        return Arrays.stream(TipoPerfil.values())
                .map(TipoPerfil::getDescricao)
                .collect(Collectors.toList());
    }

    public List<Permissao> listarTodasPermissoes() {
        return permissaoRepository.findAll();
    }

    public void atualizarPermissoes(Integer perfilId, List<Integer> permissaoIds) {
        Perfil perfil = perfilRepository.findById(perfilId)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));

        Set<Permissao> novasPermissoes = permissaoRepository.findAllById(permissaoIds)
                .stream().collect(Collectors.toSet());

        perfil.setPermissoes(novasPermissoes);
        perfilRepository.save(perfil);
    }
}
