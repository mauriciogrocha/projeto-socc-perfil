package com.soccperfil.model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static TipoPerfil fromString(String text) {
        if (text == null || text.trim().isEmpty()) {
            return null; // Permite valor vazio
        }
        for (TipoPerfil tipo : TipoPerfil.values()) {
            if (tipo.descricao.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nenhum tipo de perfil encontrado para: " + text);
    }

}
