package org.example.app;

import org.example.tools.Conversor;
import org.example.tools.Cores;
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
            System.out.printf("""
                            %s• 0: %s preto %s
                            %s• 1: %s marrom %s
                            %s• 2: %s vermelho %s
                            %s• 3: %s laranja %s
                            %s• 4: %s amarelo %s
                            %s• 5: %s verde %s
                            %s• 6: %s azul %s
                            %s• 7: %s violeta %s
                            %s• 8: %s cinza %s
                            %s• 9: %s branco %s%n""",
                    Cores.ANSI_PRETO, Cores.ANSI_PRETO, Cores.ANSI_RESET,
                    Cores.ANSI_MARROM, Cores.ANSI_MARROM, Cores.ANSI_RESET,
                    Cores.ANSI_VERMELHO, Cores.ANSI_VERMELHO, Cores.ANSI_RESET,
                    Cores.ANSI_LARANJA, Cores.ANSI_LARANJA, Cores.ANSI_RESET,
                    Cores.ANSI_AMARELO, Cores.ANSI_AMARELO, Cores.ANSI_RESET,
                    Cores.ANSI_VERDE, Cores.ANSI_VERDE, Cores.ANSI_RESET,
                    Cores.ANSI_AZUL, Cores.ANSI_AZUL, Cores.ANSI_RESET,
                    Cores.ANSI_VIOLETA, Cores.ANSI_VIOLETA, Cores.ANSI_RESET,
                    Cores.ANSI_CINZA, Cores.ANSI_CINZA, Cores.ANSI_RESET,
                    Cores.ANSI_BRANCO, Cores.ANSI_BRANCO, Cores.ANSI_RESET
            );
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
