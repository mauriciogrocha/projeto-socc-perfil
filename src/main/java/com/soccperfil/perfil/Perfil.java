package com.soccperfil.perfil;

import java.util.Set;

import com.soccperfil.permissao.Permissao;
import com.soccperfil.usuario.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfil")
@SequenceGenerator(name = "seq_perfil", sequenceName = "seq_perfil", allocationSize = 1)
public class Perfil {
    
    @Id
    @GeneratedValue(generator = "seq_perfil")
    private Integer perfilId;
    
    private String nome;
    
    private String descricao;
    
    private boolean protegido;
    
    @ManyToMany
    @JoinTable(
            name = "perfil_permissao",
            joinColumns = @JoinColumn(name = "perfil_id"),
            inverseJoinColumns = @JoinColumn(name = "permissao_id"))
    private Set<Permissao> permissoes;
    
    @ManyToMany
    @JoinTable(
            name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "perfil_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private Set<Usuario> usuarios;
    
    public Perfil() {
    }
    
    public Perfil(
            final String nome,
            final String descricao,
            final boolean protegido) {
        
        this.nome = nome;
        this.descricao = descricao;
        this.protegido = protegido;
    }
    
    public Integer getPerfilId() {
        return this.perfilId;
    }
    
    public void setPerfilId(final Integer perfilId) {
        this.perfilId = perfilId;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }
    
    public boolean isProtegido() {
        return this.protegido;
    }
    
    public void setProtegido(final boolean protegido) {
        this.protegido = protegido;
    }
    
    public Set<Permissao> getPermissoes() {
        return this.permissoes;
    }
    
    public void setPermissoes(final Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
    
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(final Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
