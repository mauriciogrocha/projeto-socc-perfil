package com.soccperfil.perfil;

public enum TipoPerfil {

    ADMINISTRADOR("Administrador"),
    CO_COORDENADOR("Co-Coordenador"),
    COORDENADOR_CURSO("Coordenador de Curso"),
    DOCENTE("Docente"),
    CURADOR_PEDAGOGICO("Curador Pedagógico (Facilitador)"),
    SECRETARIO("Secretário"),
    DISCENTE("Discente");

    private final String nomeAmigavel;

    TipoPerfil(String nomeAmigavel) {
        this.nomeAmigavel = nomeAmigavel;
    }

    public String getNomeAmigavel() {
        return nomeAmigavel;
    }

    public static TipoPerfil fromString(String text) {
        for (TipoPerfil tipo : TipoPerfil.values()) {
            if (tipo.nomeAmigavel.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nenhum tipo de perfil encontrado para: " + text);
    }
}
