package org.example.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snail {

    public static void iniciarSnail(Scanner sc) {
        System.out.println("=== Iniciando Padrão Caracol ===");
        System.out.println("Digite o número de linhas da matriz:");
        int linhas = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o número de colunas da matriz:");
        int colunas = sc.nextInt();
        sc.nextLine();

        if (linhas <= 0 || colunas <= 0) {
            System.out.println("❌ Tamanho da matriz inválido.");
            return;
        }

        int[][] matriz = new int[linhas][colunas];
        System.out.println("Digite os elementos da matriz (linha por linha, separados por espaços):");

        for (int i = 0; i < linhas; i++) {
            System.out.println("Linha " + (i + 1) + ":");
            String[] linha = sc.nextLine().trim().split("\\s+");

            if (linha.length != colunas) {
                System.out.printf("❌ Número incorreto de elementos na linha %d. Esperado: %d elementos.\n", i + 1, colunas);
                return;
            }

            for (int c = 0; c < colunas; c++) {
                try {
                    matriz[i][c] = Integer.parseInt(linha[c]);
                } catch (NumberFormatException e) {
                    System.out.printf("❌ Entrada inválida na linha %d, coluna %d: '%s'. Digite apenas números inteiros.\n", i + 1, c + 1, linha[c]);
                    return;
                }
            }
        }
        List<Integer> resultado = snail(matriz);
        System.out.println("\n✅ Resultado do padrão caracol:");
        System.out.println(resultado);
    }

    public static List<Integer> snail(int[][] matriz) {
        List<Integer> resultado = new ArrayList<>();
        if (matriz.length == 0 || matriz[0].length == 0) {
            return resultado;
        }

        int cima = 0;
        int baixo = matriz.length - 1;
        int esquerda = 0;
        int direita = matriz[0].length - 1;

        while (cima <= baixo && esquerda <= direita) {

            for (int i = esquerda; i <= direita; i++) {
                resultado.add(matriz[cima][i]);
                imprimirMatriz(matriz, resultado, "▶ Direita");
            }
            cima++;

            for (int i = cima; i <= baixo; i++) {
                resultado.add(matriz[i][direita]);
                imprimirMatriz(matriz, resultado, "⬇ Baixo");
            }
            direita--;

            if (cima <= baixo) {
                for (int i = direita; i >= esquerda; i--) {
                    resultado.add(matriz[baixo][i]);
                    imprimirMatriz(matriz, resultado, "◀ Esquerda");
                }
                baixo--;
            }

            if (esquerda <= direita) {
                for (int i = baixo; i >= cima; i--) {
                    resultado.add(matriz[i][esquerda]);
                    imprimirMatriz(matriz, resultado, "⬆ Cima");
                }
                esquerda++;
            }
        }
        return resultado;
    }

    private static void imprimirMatriz(int[][] matriz, List<Integer> resultado, String direcao) {
        System.out.println("\n📋 Matriz Atual - Direção: " + direcao);

        int maxValor = 0;
        for (int[] linha : matriz) {
            for (int valor : linha) {
                if (valor > maxValor) {
                    maxValor = valor;
                }
            }
        }
        int largura = Integer.toString(maxValor).length() + 1; // Ajustar a largura para incluir colchetes e espaços

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int valor = matriz[i][j];

                String formato = resultado.contains(valor) ? String.format("[%"+(largura-2)+"d]", valor) : String.format("%"+largura+"d", valor);
                System.out.print(formato);
            }
            System.out.println();
        }
        System.out.println("Elementos do padrão caracol atualmente: " + resultado);
    }
}

