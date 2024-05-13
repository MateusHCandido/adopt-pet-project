package br.com.alura.adopet.api.controller.dto;

import jakarta.validation.constraints.NotNull;

public record AprovacaoAdocaoDto(@NotNull Long idAdocao) {
}
