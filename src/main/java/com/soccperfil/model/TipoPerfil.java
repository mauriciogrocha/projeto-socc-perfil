package com.soccperfil.model;

public enum TipoPerfil {

    ADMINISTRADOR("Administrador"),
    CO_COORDENADOR("Co-Coordenador"),
    COORDENADOR_CURSO("Coordenador de Curso"),
    DOCENTE("Docente"),
    CURADOR_PEDAGOGICO("Curador Pedagógico (Facilitador)"),
    SECRETARIO("Secretário"),
    DISCENTE("Discente");

    private final String descricao;

    TipoPerfil(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoPerfil fromString(String text) {
        for (TipoPerfil tipo : TipoPerfil.values()) {
            if (tipo.descricao.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nenhum tipo de perfil encontrado para: " + text);
    }
}
