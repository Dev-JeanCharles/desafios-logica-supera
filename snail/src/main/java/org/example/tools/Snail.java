package org.example.tools;

import org.example.Handler.MatrizInputHandler;
import org.example.patterns.SnailPattern;

import java.util.List;
import java.util.Scanner;

public class Snail {

    public static void iniciarPrograma(Scanner sc) {
        MatrizInputHandler inputHandler = new MatrizInputHandler(sc);
        int[][] matriz = inputHandler.obterMatriz();

        if (matriz == null) {
            return;
        }

        SnailPattern snailPattern = new SnailPattern(matriz);
        List<Integer> resultado = snailPattern.criarPadraoCaracol();

        MatrizPrinter resultPrinter = new MatrizPrinter();
        resultPrinter.imprimirMatriz(matriz, resultado);
    }
}
