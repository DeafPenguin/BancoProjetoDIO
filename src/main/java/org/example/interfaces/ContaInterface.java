package org.example.interfaces;

import org.example.Conta;

public interface ContaInterface {
    void sacar(String valor);

    void depositar(String valor);

    void transferir(Conta contaDestino, String valor);

    void imprimirExtrato();
}