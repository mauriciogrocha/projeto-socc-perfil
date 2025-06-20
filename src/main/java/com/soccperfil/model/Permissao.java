package com.soccperfil.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import com.soccperfil.model.Perfil;



@Entity
@Table(name = "permissao")
@SequenceGenerator(name = "seq_permissao", sequenceName = "seq_permissao", allocationSize = 1)
public class Permissao {
    
    @Id
    @GeneratedValue(generator = "seq_permissao")
    private Integer permissaoId;
    
    private String descricao;
    
    @ManyToMany(mappedBy = "permissoes")
    @JsonIgnore
    private Set<Perfil> perfis;
    
    public Permissao() {
    }
    
    public Permissao(final String dscricao) {
        this.descricao = dscricao;
    }
    
    public Integer getPermissaoId() {
        return this.permissaoId;
    }
    
    public void setPermissaoId(final Integer permissaoId) {
        this.permissaoId = permissaoId;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(final String dscricao) {
        this.descricao = dscricao;
    }
    
    public Set<Perfil> getPerfis() {
        return this.perfis;
    }
    
    public void setPerfis(final Set<Perfil> perfis) {
        this.perfis = perfis;
    }
    
}
