package br.com.alura.adopet.api.exception;

public class CamposNaoPreenchidosException extends RuntimeException {
    public CamposNaoPreenchidosException(String message) {
        super(message);
    }
}
