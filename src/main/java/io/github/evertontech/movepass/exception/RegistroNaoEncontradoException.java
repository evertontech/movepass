package io.github.evertontech.movepass.exception;

public class RegistroNaoEncontradoException extends RuntimeException {

    public RegistroNaoEncontradoException() {
        super("O registro procurado não foi encontrado");
    }
}
