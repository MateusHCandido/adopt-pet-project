package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.controller.dto.AbrigoDto;
import br.com.alura.adopet.api.controller.dto.BuscarPetNoAbrigoPorIdOuNomeDto;
import br.com.alura.adopet.api.controller.dto.CadastrarAbrigoDto;
import br.com.alura.adopet.api.controller.dto.PetDto;
import br.com.alura.adopet.api.exception.*;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository abrigoRepository;

    @Autowired
    private PetRepository petRepository;

    public List<AbrigoDto> listarAbrigos(){
        return abrigoRepository
                .findAll()
                .stream()
                .map(AbrigoDto::new)
                .toList();
    }

    public void cadastrarAbrigo(CadastrarAbrigoDto dto){
        boolean abrigoJaCadastrado = abrigoRepository
                .existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email());
        if (abrigoJaCadastrado) {
            throw new DadosCadastradosException("Dados já cadastrados para outro abrigo!");
        }

        abrigoRepository.save(new Abrigo(dto));
    }

    public List<PetDto> listarPets(String idOuNome){
        Abrigo abrigo = carregarAbrigo(idOuNome);

        return petRepository
                .findByAbrigo(abrigo)
                .stream()
                .map(PetDto::new)
                .toList();
    }

    public Abrigo carregarAbrigo(String idOuNomeAbrigo){
        Optional<Abrigo> abrigoOptional;

        try{
            Long abrigoId = Long.parseLong(idOuNomeAbrigo);
            abrigoOptional = abrigoRepository.findById(abrigoId);
        }catch (NumberFormatException e){
            abrigoOptional = Optional.ofNullable(abrigoRepository.findByNome(idOuNomeAbrigo));
        }

        return abrigoOptional.orElseThrow(() -> new ValidacaoException("Abrigo não encontrado"));
    }

    public void cadastrarPet(String idOuNomeAbrigo, PetDto petDto){
        Abrigo abrigo = carregarAbrigo(idOuNomeAbrigo);
        petRepository.save(new Pet(petDto, abrigo));
    }
}
