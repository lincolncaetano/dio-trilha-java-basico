package br.com.lincolncaetano.exceptions;

public class CardBlockedException extends RuntimeException{

    public CardBlockedException(final String message) {
        super(message);
    }
}