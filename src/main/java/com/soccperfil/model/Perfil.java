package com.soccperfil.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;

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

    @Enumerated(EnumType.STRING) // salva o nome do enum como texto no banco
    private TipoPerfil tipo;
    
    public Perfil() {
    }

    public Perfil(String nome, String descricao, boolean protegido, TipoPerfil tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.protegido = protegido;
        this.tipo = tipo;
    }

    public Perfil(String nome, String descricao, boolean protegido, String tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.protegido = protegido;
        this.tipo = TipoPerfil.fromString(tipo);
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

    public TipoPerfil getTipo() {
        return tipo;
    }

    @JsonSetter("tipo")
    public void setTipo(String tipo) {
        this.tipo = TipoPerfil.fromString(tipo);
    }
    
}
