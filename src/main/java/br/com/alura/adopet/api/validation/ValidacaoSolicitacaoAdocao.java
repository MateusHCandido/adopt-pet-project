package br.com.alura.adopet.api.validation;

import br.com.alura.adopet.api.controller.dto.SolicitacaoAdocaoDto;

public interface ValidacaoSolicitacaoAdocao {

    void validar(SolicitacaoAdocaoDto dto);
}
