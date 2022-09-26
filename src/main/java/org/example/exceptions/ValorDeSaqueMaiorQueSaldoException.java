package org.example.exceptions;

public class ValorDeSaqueMaiorQueSaldoException extends IndexOutOfBoundsException {

    public ValorDeSaqueMaiorQueSaldoException() {
        super("ERRO: Saldo insuficiente! Verifique o seu extrato.");
        System.out.println("\nERRO: Saldo insuficiente! Verifique o seu extrato.\n");
    }
}