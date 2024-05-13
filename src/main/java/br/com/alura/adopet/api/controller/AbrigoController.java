package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.controller.dto.AbrigoDto;
import br.com.alura.adopet.api.controller.dto.CadastrarAbrigoDto;
import br.com.alura.adopet.api.controller.dto.PetDto;
import br.com.alura.adopet.api.exception.DadosCadastradosException;
import br.com.alura.adopet.api.service.AbrigoService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoService abrigoService;


    @GetMapping
    public ResponseEntity<List<AbrigoDto>> listar() {
        return ResponseEntity.ok(abrigoService.listarAbrigos());
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CadastrarAbrigoDto abrigo) {
        try{
            ResponseEntity.status(HttpStatus.CREATED);
        }catch (DadosCadastradosException e){
            ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{idOuNome}/pets")
    public ResponseEntity<List<PetDto>> listarPets(@PathVariable String idOuNomeDto) {
        try {
            return ResponseEntity.ok(abrigoService.listarPets(idOuNomeDto));
        } catch (ValidationException abne) {
            return (ResponseEntity<List<PetDto>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/{idOuNome}/pets")
    @Transactional
    public ResponseEntity cadastrarPet(@PathVariable String idOuNome, @RequestBody @Valid PetDto pet) {
        try {
            abrigoService.cadastrarPet(idOuNome, pet);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (ValidationException enfe) {
            return ResponseEntity.badRequest().build();
        }
    }

}
