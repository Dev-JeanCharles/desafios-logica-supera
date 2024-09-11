package org.example.patterns;

import java.util.ArrayList;
import java.util.List;

public class SnailPattern {
    private final int[][] matriz;

    public SnailPattern(int[][] matriz) {
        this.matriz = matriz;
    }

    public List<Integer> criarPadraoCaracol() {
        List<Integer> resultado = new ArrayList<>();
        if (matriz.length == 0 || matriz[0].length == 0) {
            return resultado;
        }

        int cima = 0, baixo = matriz.length - 1;
        int esquerda = 0, direita = matriz[0].length - 1;

        while (cima <= baixo && esquerda <= direita) {
            // Direita
            for (int i = esquerda; i <= direita; i++) {
                resultado.add(matriz[cima][i]);
                imprimirMatrizPercorrida(resultado);
            }
            cima++;

            // Baixo
            for (int i = cima; i <= baixo; i++) {
                resultado.add(matriz[i][direita]);
                imprimirMatrizPercorrida(resultado);
            }
            direita--;

            if (cima <= baixo) {
                // Esquerda
                for (int i = direita; i >= esquerda; i--) {
                    resultado.add(matriz[baixo][i]);
                    imprimirMatrizPercorrida(resultado);
                }
                baixo--;
            }

            if (esquerda <= direita) {
                // Cima
                for (int i = baixo; i >= cima; i--) {
                    resultado.add(matriz[i][esquerda]);
                    imprimirMatrizPercorrida(resultado);
                }
                esquerda++;
            }
        }

        return resultado;
    }

    private void imprimirMatrizPercorrida(List<Integer> resultado) {
        System.out.println("\n📋 Matriz percorrida");

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