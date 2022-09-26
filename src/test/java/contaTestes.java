import org.example.Cliente;
import org.example.Conta;
import org.example.ContaCorrente;
import org.example.exceptions.ValorDeSaqueMaiorQueSaldoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class contaTestes {

    Cliente clienteVictor = new Cliente("Victor Murilo Balbino Machado", "30/06/1993");
    Conta contaVictor = new ContaCorrente(clienteVictor);

    @Test
    @DisplayName("Verifica o metodo deposito")
    public void verificaMetodoDeposito(){
        // GIVEN
        assertEquals(contaVictor.getSaldo(), 0); // Saldo inicial zerado
        // WHEN
        contaVictor.depositar(200); // Depositando R$200,00
        // THEN
        assertEquals(contaVictor.getSaldo(), 200); // Saldo pos-deposito de R$200,00
    }

    @Test
    @DisplayName("Verifica o metodo saque")
    public void verificaMetodoSaque(){
        // GIVEN
        contaVictor.depositar(200);
        assertEquals(contaVictor.getSaldo(), 200); // Depositando R$200,00 e mantendo saldo
        // WHEN
        contaVictor.sacar(200); // Sacando os R$200,00
        // THEN
        assertEquals(contaVictor.getSaldo(), 0); // Saldo final zerado
    }
}
