package org.example.tools;

import java.util.List;

public class MatrizPrinter {

    public void imprimirMatriz(int[][] matriz, List<Integer> resultado) {
        System.out.println("\n📋 Matriz Atual");

        int maxValor = encontrarMaxValor(matriz);
        int largura = Integer.toString(maxValor).length() + 1;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int valor = matriz[i][j];
                String formato = resultado.contains(valor) ? String.format("[%" + (largura - 1) + "d]", valor) : String.format("%" + largura + "d", valor);
                System.out.print(formato);
            }
            System.out.println();
        }
        System.out.println("Elementos do padrão caracol atualmente: " + resultado);
    }

    private int encontrarMaxValor(int[][] matriz) {
        int maxValor = 0;
        for (int[] linha : matriz) {
            for (int valor : linha) {
                if (valor > maxValor) {
                    maxValor = valor;
                }
            }
        }
        return maxValor;
    }
}
