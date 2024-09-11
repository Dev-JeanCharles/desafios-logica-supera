package org.example.app;

import org.example.tools.Snail;

import java.util.Scanner;

public class Operacoes {

    public static void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("##--Desafio Snail--##\n\n");
            System.out.print("|---------------------------------------|\n");
            System.out.print("| Opção 1 - Iniciar Snail               |\n");
            System.out.print("| Opção 2 - Voltar ao menu principal    |\n");
            System.out.print("|---------------------------------------|\n");

            System.out.println("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    Snail.iniciarPrograma(sc);
                    break;
                case 2:
                    System.out.println("Voltando ao menu principal.");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        }
    }
}
