package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente victor = new Cliente("Victor Murilo Balbino Machado", "30/06/1993");
        Conta cc = new ContaCorrente(victor);

        while(true){
            telaSelecao(cc);
        }
    }

    public static void telaSelecao(Conta conta){
        System.out.println("===============================");
        System.out.println("Olá! O que deseja fazer?");
        System.out.println("1 - Imprimir extrato");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Transferir");
        System.out.println("5 - Sair");
        System.out.println("===============================");
        int selecao = Integer.parseInt(new Scanner(System.in).nextLine());
        switch (selecao){
            case 1:
                conta.imprimirExtrato();
                break;
            case 2:
                System.out.println("Digite o valor do saque:");
                String valorSaque = new Scanner(System.in).nextLine();
                conta.sacar(valorSaque);
                break;
            case 3:
                System.out.println("Digite o valor do deposito:");
                String valorDeposito = new Scanner(System.in).nextLine();
                conta.depositar(valorDeposito);
                break;
            case 4: // TODO: Habilitar seleção de conta destino para o usuário
                Cliente victor = new Cliente("Victor Murilo Balbino Machado", "30/06/1993");
                Conta cp = new ContaPoupanca(victor);
                System.out.println("Digite o valor da transferência:");
                String valorTransferencia = new Scanner(System.in).nextLine();
                conta.transferir(cp, valorTransferencia);
                break;
            case 5:
                System.out.println("Agradecemos pela sua preferencia, volte sempre.");
                break;
            default:
                System.out.println("O número escolhido é inválido!");
        }
    }
}