package org.example;

import lombok.Getter;
import org.example.exceptions.ValorDeSaqueMaiorQueSaldoException;
import org.example.interfaces.ContaInterface;

public abstract class Conta implements ContaInterface {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    @Getter
    protected int agencia;
    @Getter
    protected int numConta;
    @Getter
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = AGENCIA_PADRAO;
        this.numConta = SEQUENCIAL++;
    }

    @Override
    public void sacar(String valorDigitado) throws ValorDeSaqueMaiorQueSaldoException, NumberFormatException {
        try {
            double valor = Double.parseDouble(valorDigitado);
            if (saldo < valor) {
                throw new ValorDeSaqueMaiorQueSaldoException();
            } else {
                saldo -= valor;
            }
        } catch (ValorDeSaqueMaiorQueSaldoException e) {
        } catch (NumberFormatException e) {
            System.out.println("\nERRO: Valor invalido. Favor refazer operacao.\n");
        }
    }

    @Override
    public void depositar(String valorDigitado) {
        try {
            double valor = Double.parseDouble(valorDigitado);
            saldo += valor;
        } catch (ValorDeSaqueMaiorQueSaldoException e) {
        } catch (NumberFormatException e) {
            System.out.println("\nERRO: Valor inválido. Favor refazer operação.\n");
        }
    }

    @Override
    public void transferir(Conta contaDestino, String valorDigitado) {
        this.sacar(valorDigitado);
        contaDestino.depositar(valorDigitado);
    }

    protected void imprimirDadosDaConta() {
        System.out.println(String.format("Titular: %s", this.cliente.getNomeCliente()));
        System.out.println(String.format("Data de Nascimento: %s", this.cliente.getDataNasc()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero da Conta: %d", this.numConta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println("===============================");
    }
}
