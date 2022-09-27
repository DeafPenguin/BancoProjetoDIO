import org.example.Cliente;
import org.example.Conta;
import org.example.ContaCorrente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaTestes {

    Cliente clienteVictor = new Cliente("Victor Murilo Balbino Machado", "30/06/1993");
    Conta contaVictor = new ContaCorrente(clienteVictor);

    @Test
    @DisplayName("Metodo deposito deve ter sucesso")
    public void testeMetodoDeposito() {
        // GIVEN
        assertEquals(contaVictor.getSaldo(), 0); // Saldo inicial zerado
        // WHEN
        contaVictor.depositar("200"); // Depositando R$200,00
        // THEN
        assertEquals(contaVictor.getSaldo(), 200); // Saldo pos-deposito de R$200,00
    }

    @Test
    @DisplayName("Metodo saque deve ter sucesso")
    public void testeMetodoSaque() {
        // GIVEN
        contaVictor.depositar("300");
        assertEquals(contaVictor.getSaldo(), 300); // Depositando R$300,00 e mantendo saldo
        // WHEN
        contaVictor.sacar("200"); // Sacando os R$200,00
        // THEN
        assertEquals(contaVictor.getSaldo(), 100); // Saldo final zerado
    }

    @Test
    @DisplayName("Metodo saque deve falhar ao sacar com saldo menor")
    public void testeMetodoSaqueComSaldoMenor() {
        // GIVEN
        assertEquals(contaVictor.getSaldo(), 0); // Saldo inicial zerado
        // WHEN
        contaVictor.sacar("200"); // Sacando os R$200,00
        // THEN
        assertEquals(contaVictor.getSaldo(), 0); // Saldo final zerado
    }

    @Test
    @DisplayName("Metodo saque deve falhar ao sacar com não-numeros")
    public void testeMetodoSaqueNaoNumerico() {
        // GIVEN
        assertEquals(contaVictor.getSaldo(), 0); // Saldo inicial zerado
        // WHEN
        contaVictor.sacar("a"); // Sacando os R$200,00
        // THEN
        assertEquals(contaVictor.getSaldo(), 0); // Saldo final zerado
    }
}
