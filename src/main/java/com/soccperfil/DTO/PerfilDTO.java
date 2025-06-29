package com.soccperfil.DTO;

import com.soccperfil.model.Perfil;

public class PerfilDTO {
    private Integer perfilId;
    private String nome;
    private String descricao;
    private boolean protegido;
    
    private String tipo;

    public PerfilDTO(Perfil perfil) {
        this.perfilId = perfil.getPerfilId();
        this.nome = perfil.getNome();
        this.descricao = perfil.getDescricao();
        this.protegido = perfil.isProtegido();
        this.tipo = perfil.getTipo() != null ? perfil.getTipo().getDescricao() : null;
    }

    public Integer getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Integer perfilId) {
        this.perfilId = perfilId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isProtegido() {
        return protegido;
    }

    public void setProtegido(boolean protegido) {
        this.protegido = protegido;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
