package br.com.alura.adopet.api.controller.dto;

import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.TipoPet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetDto(Long id, TipoPet tipo
                    , @NotBlank String nome
                    , @NotBlank String raca
                    , @NotNull Integer idade
                    , @NotBlank String cor
                    , @NotNull Float peso){

    public PetDto(Pet pet) {
        this(pet.getId(), pet.getTipo(), pet.getNome(), pet.getRaca(), pet.getIdade(), pet.getCor(), pet.getPeso());
    }


}
