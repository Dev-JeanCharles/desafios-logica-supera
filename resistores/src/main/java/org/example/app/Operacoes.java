package org.example.app;

import org.example.tools.Conversor;
import org.example.tools.Impressoes;

import java.util.Scanner;

public class Operacoes {

    public static void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("##--Desafio Resistores – Código de Cores--##\n\n");
            System.out.print("|---------------------------------------|\n");
            System.out.print("| Opção 1 - Tabela de resistores        |\n");
            System.out.print("| Opção 2 - Iniciar Conversor           |\n");
            System.out.print("| Opção 3 - Voltar ao menu principal    |\n");
            System.out.print("|---------------------------------------|\n");

            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                exibirTabela(sc);
                break;
            case 2:
                Conversor.iniciarConversor();
                break;
            case 3:
                System.out.println("Voltando ao menu principal");
                return;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                break;
            }
        }
    }
    public static void exibirTabela(Scanner sc) {
        while (true) {
            System.out.println("Exibição da Tabela de resistores:");
            System.out.println("""
                    • 0: preto
                    • 1: marrom
                    • 2: vermelho
                    • 3: laranja
                    • 4: amarelo
                    • 5: verde
                    • 6: azul
                    • 7: violeta
                    • 8: cinza
                    • 9: branco""");
            System.out.print("Digite 0 para voltar ao menu de operações: ");

            int opcao = sc.nextInt();

            if (opcao == 0) {
                System.out.println(Impressoes.MENU_OPERACAO);
                break;
            }else {
                System.out.println(Impressoes.OPCAO_INVALIDA);
            }
        }
    }
}
