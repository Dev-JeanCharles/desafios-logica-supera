package org.example.tools;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Conversor {
    private static final Map<Integer, String> COLOR_CODE = new HashMap<>() {{
        put(0, "preto");
        put(1, "marrom");
        put(2, "vermelho");
        put(3, "laranja");
        put(4, "amarelo");
        put(5, "verde");
        put(6, "azul");
        put(7, "violeta");
        put(8, "cinza");
        put(9, "branco");
    }};

    private static final String COR_TOLERANCIA = "dourado";

    public static void iniciarConversor() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println(Impressoes.VALOR_COR);
            String entrada = sc.nextLine();

            try {
                String resultado = conversorParaCorCodigo(entrada);
                System.out.println(Impressoes.CORRESPONDENTE + resultado);
            } catch (Exception e) {
                System.out.println(Impressoes.ENTRADA_INVALIDA);
            }

            System.out.print("Digite 0 para voltar ao menu de operações ou 1 para continuar: ");
            int opcao = sc.nextInt();

            if (opcao == 0) {
                System.out.println(Impressoes.MENU_OPERACAO);
                return;
            } else if (opcao == 1) {
                System.out.println("Continuando as operações.");
                iniciarConversor();
                return;
            } else {
                System.out.println(Impressoes.OPCAO_INVALIDA);
            }
        }
    }

    private static String conversorParaCorCodigo(String entrada) {
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
                COLOR_CODE.get(digitoUm),
                COLOR_CODE.get(digitoDois),
                COLOR_CODE.get(multiplicador),
                COR_TOLERANCIA
        );
    }
}
