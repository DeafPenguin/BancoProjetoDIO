package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Banco {
    @Getter @Setter private String nomeBanco;
    private List<Conta> contas;
}
