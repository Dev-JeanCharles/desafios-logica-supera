package org.example.tools;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Conversor {
    private static final Map<Integer, String> COR_CODIGO = new HashMap<>() {{
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

    private static final String COR_TOLERANCIA = Cores.ANSI_DOURADO + "dourado" + Cores.ANSI_RESET;

    public static void iniciarConversor() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String entrada = null;
            while (entrada == null) {
                System.out.println(Impressoes.VALOR_COR);
                entrada = sc.nextLine();

                try {
                    String resultado = conversorParaCorCodigo(entrada);
                    System.out.println(Impressoes.CORRESPONDENTE + resultado);

                } catch (Exception e) {
                    System.out.println(Impressoes.ENTRADA_INVALIDA);
                    entrada = null;
                }
            }

            int opcao = -1;

            while (true) {
                try {
                    System.out.print("Digite 0 para voltar ao menu de operações ou 1 para continuar: ");

                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch (opcao) {
                        case 0:
                            System.out.println(Impressoes.MENU_OPERACAO);
                            return;
                        case 1:
                            System.out.println("Continuando as operações.");
                            break;
                        default:
                            System.out.println(Impressoes.OPCAO_INVALIDA);
                            continue;
                    }
                    break;

                } catch (Exception e) {
                    System.out.println(Impressoes.ENTRADA_INVALIDA);
                    sc.nextLine();
                }
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
                COR_CODIGO.get(digitoUm),
                COR_CODIGO.get(digitoDois),
                COR_CODIGO.get(multiplicador),
                COR_TOLERANCIA
        );
    }
}
