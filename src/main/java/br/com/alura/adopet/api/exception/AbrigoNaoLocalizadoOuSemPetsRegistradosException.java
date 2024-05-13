package br.com.alura.adopet.api.exception;

public class AbrigoNaoLocalizadoOuSemPetsRegistradosException extends RuntimeException {
    public AbrigoNaoLocalizadoOuSemPetsRegistradosException(String message) {
        super(message);
    }
}
