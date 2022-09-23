import org.example.Cliente;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

public class clienteTestes {
    @Test
    public void testaConstrutorCliente() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Cliente victor = new Cliente("Victor Murilo Balbino Machado", "30/06/1993");

        assertEquals(victor.getNomeCliente(), "Victor Murilo Balbino Machado");
        assertEquals(victor.getDataNasc(), formatter.parse("30/06/1993"));
    }
}
