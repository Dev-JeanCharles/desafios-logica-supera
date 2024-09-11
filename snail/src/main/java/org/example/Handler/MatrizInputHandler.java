package org.example.Handler;

import java.util.Scanner;

public class MatrizInputHandler {
    private final Scanner scanner;

    public MatrizInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public int[][] obterMatriz() {
        System.out.println("=== Iniciando Padrão Caracol ===");
        System.out.println("Digite o número de linhas da matriz:");
        int linhas = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o número de colunas da matriz:");
        int colunas = scanner.nextInt();
        scanner.nextLine();

        if (linhas <= 0 || colunas <= 0) {
            System.out.println("❌ Tamanho da matriz inválido.");
            return null;
        }

        int[][] matriz = new int[linhas][colunas];
        System.out.println("Digite os elementos da matriz (linha por linha, separados por espaços):");

        for (int i = 0; i < linhas; i++) {
            System.out.println("Linha " + (i + 1) + ":");
            String[] linha = scanner.nextLine().trim().split("\\s+");

            if (linha.length != colunas) {
                System.out.printf("❌ Número incorreto de elementos na linha %d. Esperado: %d elementos.\n", i + 1, colunas);
                return null;
            }

            for (int c = 0; c < colunas; c++) {
                try {
                    matriz[i][c] = Integer.parseInt(linha[c]);
                } catch (NumberFormatException e) {
                    System.out.printf("❌ Entrada inválida na linha %d, coluna %d: '%s'. Digite apenas números inteiros.\n", i + 1, c + 1, linha[c]);
                    return null;
                }
            }
        }

        return matriz;
    }
}
