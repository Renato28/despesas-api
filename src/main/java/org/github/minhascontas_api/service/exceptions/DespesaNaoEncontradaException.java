package org.github.minhascontas_api.service.exceptions;

public class DespesaNaoEncontradaException extends RuntimeException {

    public DespesaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
