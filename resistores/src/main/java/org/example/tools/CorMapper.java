package org.example.tools;

import java.util.HashMap;
import java.util.Map;

public class CorMapper {
    private final Map<Integer, String> corCodigo;
    private final String corTolerancia;

    public CorMapper() {
        corCodigo = new HashMap<>() {{
            put(0, Cores.ANSI_PRETO + "preto" + Cores.ANSI_RESET);
            put(1, Cores.ANSI_MARROM + "marrom" + Cores.ANSI_RESET);
            put(2, Cores.ANSI_VERMELHO + "vermelho" + Cores.ANSI_RESET);
            put(3, Cores.ANSI_LARANJA + "laranja" + Cores.ANSI_RESET);
            put(4, Cores.ANSI_AMARELO + "amarelo" + Cores.ANSI_RESET);
            put(5, Cores.ANSI_VERDE + "verde" + Cores.ANSI_RESET);
            put(6, Cores.ANSI_AZUL + "azul" + Cores.ANSI_RESET);
            put(7, Cores.ANSI_VIOLETA + "violeta" + Cores.ANSI_RESET);
            put(8, Cores.ANSI_CINZA + "cinza" + Cores.ANSI_RESET);
            put(9, Cores.ANSI_BRANCO + "branco" + Cores.ANSI_RESET);
        }};
        this.corTolerancia = Cores.ANSI_DOURADO + "dourado" + Cores.ANSI_RESET;
    }

    public String getCorCodigo(int code) {
        return corCodigo.get(code);
    }

    public String getCorTolerancia() {
        return corTolerancia;
    }
}
