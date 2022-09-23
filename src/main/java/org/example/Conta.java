package org.example;

import lombok.Getter;

public abstract class Conta implements ContaInterface {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    @Getter protected int agencia;
    @Getter protected int numConta;
    @Getter protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = AGENCIA_PADRAO;
        this.numConta = SEQUENCIAL++;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirDadosDaConta(){
        System.out.println(String.format("Titular: %s", this.cliente.getNomeCliente()));
        System.out.println(String.format("Data de Nascimento: %s", this.cliente.getDataNasc()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero da Conta: %d", this.numConta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println("===============================");
    }
}
