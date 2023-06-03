package br.com.projetointegrador.grupoIII.api.service.exception;

public class EstoqueBaixoException extends RuntimeException{

    public EstoqueBaixoException(String mensagem) {
        super(mensagem);
    }
}
