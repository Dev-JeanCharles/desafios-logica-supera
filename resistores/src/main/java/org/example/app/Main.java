package org.example.app;

import java.util.Scanner;

import org.example.tools.Impressoes;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("|-------------------------------|\n");
            System.out.print("| Opção 1 - Iniciar o programa  |\n");
            System.out.print("| Opção 2 - Sair                |\n");
            System.out.print("|-------------------------------|\n");

            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Operacoes.menu();
                    break;
                case 2:
                    System.out.print("\nAté logo!");
                    sc.close();
                    return;
                default:
                    System.out.println(Impressoes.OPCAO_INVALIDA);
                    break;
            }
        }
    }
}
