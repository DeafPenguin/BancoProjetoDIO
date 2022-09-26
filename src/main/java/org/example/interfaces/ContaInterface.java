package org.example.interfaces;

import org.example.Conta;

public interface ContaInterface {
    void sacar(double valor);

    void depositar(double valor);

    void transferir(Conta contaDestino, double valor);

    void imprimirExtrato();
}