package com.soccperfil.permissao;

import java.util.Set;

import com.soccperfil.perfil.Perfil;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "permissao")
@SequenceGenerator(name = "seq_permissao", sequenceName = "seq_permissao", allocationSize = 1)
public class Permissao {
    
    @Id
    @GeneratedValue(generator = "seq_permissao")
    private Integer permissaoId;
    
    private String dscricao;
    
    @ManyToMany(mappedBy = "permissoes")
    private Set<Perfil> perfis;
    
    public Permissao() {
    }
    
    public Permissao(final String dscricao) {
        this.dscricao = dscricao;
    }
    
    public Integer getPermissaoId() {
        return this.permissaoId;
    }
    
    public void setPermissaoId(final Integer permissaoId) {
        this.permissaoId = permissaoId;
    }
    
    public String getDscricao() {
        return this.dscricao;
    }
    
    public void setDscricao(final String dscricao) {
        this.dscricao = dscricao;
    }
    
    public Set<Perfil> getPerfis() {
        return this.perfis;
    }
    
    public void setPerfis(final Set<Perfil> perfis) {
        this.perfis = perfis;
    }
    
}
