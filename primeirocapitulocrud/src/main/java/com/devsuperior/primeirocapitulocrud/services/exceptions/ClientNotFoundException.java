package com.devsuperior.primeirocapitulocrud.services.exceptions;

public class ClientNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ClientNotFoundException(String msg) { // estamos repassando o argumento para o construtor da superclasse
        super(msg);
    }

}
