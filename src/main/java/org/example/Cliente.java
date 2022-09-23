package org.example;

import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {

    @Getter @Setter
    private String nomeCliente;
    @Getter @Setter
    private String dataNascNaoConvertida;
    @Getter @Setter
    private Date dataNasc;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public Cliente(String nomeCliente, String dataNascNaoConvertida) {
        this.nomeCliente = nomeCliente;
        try {
            this.dataNasc = formatter.parse(dataNascNaoConvertida);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
