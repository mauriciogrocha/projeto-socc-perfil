package com.soccperfil.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
public class Usuario {
    
    @Id
    @GeneratedValue(generator = "seq_usuario")
    private Integer usuarioId;
    
    private String login;
    
    private String nome;
    
    private String senha;
    
    @ManyToMany(mappedBy = "usuarios")
    private Set<Perfil> perfis;
    
    public Usuario(
            String login,
            String nome,
            String senha) {
        
        this.login = login;
        this.nome = nome;
        this.senha = senha;
    }
    
    public Usuario() {}
    
    public Integer getUsuarioId() {
        return this.usuarioId;
    }
    
    public void setUsuarioId(final Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(final String login) {
        this.login = login;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(final String senha) {
        this.senha = senha;
    }
    
    public Set<Perfil> getPerfis() {
        return this.perfis;
    }
    
    public void setPerfis(final Set<Perfil> perfis) {
        this.perfis = perfis;
    }
    
}
