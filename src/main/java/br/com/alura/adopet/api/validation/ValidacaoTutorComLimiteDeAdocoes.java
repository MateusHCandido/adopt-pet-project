package br.com.alura.adopet.api.validation;

import br.com.alura.adopet.api.controller.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidacaoTutorComLimiteDeAdocoes implements ValidacaoSolicitacaoAdocao {


    @Autowired
    private AdocaoRepository adocaoRepository;


    public void validar(SolicitacaoAdocaoDto dto){
        Integer limiteAdocaoPets = adocaoRepository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO);

        if (limiteAdocaoPets == 5) {
            throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!");
        }

    }


}
