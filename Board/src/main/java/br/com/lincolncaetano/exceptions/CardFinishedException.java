package br.com.lincolncaetano.exceptions;


public class CardFinishedException extends RuntimeException{

    public CardFinishedException(final String message) {
        super(message);
    }
}
