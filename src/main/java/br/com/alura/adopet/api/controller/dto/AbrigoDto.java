package br.com.alura.adopet.api.controller.dto;

import br.com.alura.adopet.api.model.Abrigo;

public record AbrigoDto(String nome, String telefone, String email) {

    public AbrigoDto(Abrigo abrigo){
        this(abrigo.getNome(), abrigo.getTelefone(), abrigo.getEmail());
    }
}
