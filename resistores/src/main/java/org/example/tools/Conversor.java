package org.example.tools;

public class Conversor {
    private final CorMapper cor;

    public Conversor(CorMapper cor) {
        this.cor = cor;
    }

    public String conversorParaCorCodigo(String entrada) {
        entrada = entrada.toLowerCase().replace(" ohms", "");

        double valor;
        int multiplicador;

        if (entrada.contains("k")) {
            valor = Double.parseDouble(entrada.replace("k", "")) * 1000;
            multiplicador = (int) Math.log10(valor) -1;

        } else if (entrada.contains("m")) {
            valor = Double.parseDouble(entrada.replace("m", "")) * 1_000_000;
            multiplicador = (int) Math.log10(valor) -1;

        }else {
            valor = Double.parseDouble(entrada);
            multiplicador = (int) Math.log10(valor);
        }

        int digitoUm = (int) (valor / Math.pow(10, multiplicador)) / 10;
        int digitoDois = (int) (valor / Math.pow(10, multiplicador)) % 10;

        return String.format("%s %s %s %s",
                cor.getCorCodigo(digitoUm),
                cor.getCorCodigo(digitoDois),
                cor.getCorCodigo(multiplicador),
                cor.getCorTolerancia()
        );
    }
}
