package org.example.app;

import org.example.Handlers.EntradaUsuarioHandler;
import org.example.tools.Conversor;
import org.example.tools.CorMapper;
import org.example.tools.Cores;
import org.example.tools.Impressoes;

import java.util.Scanner;

public class Operacoes {

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        CorMapper corMapper = new CorMapper();
        Conversor conversor = new Conversor(corMapper);
        EntradaUsuarioHandler entradaUsuarioHandler = new EntradaUsuarioHandler(sc, conversor);

        while (true) {
            System.out.print("##--Desafio Resistores – Código de Cores--##\n\n");
            System.out.print("|---------------------------------------|\n");
            System.out.print("| Opção 1 - Tabela de resistores        |\n");
            System.out.print("| Opção 2 - Iniciar Conversor           |\n");
            System.out.print("| Opção 3 - Voltar ao menu principal    |\n");
            System.out.print("|---------------------------------------|\n");

            System.out.print("Escolha uma opção: ");

            int opcao = entradaUsuarioHandler.escolher("");

            switch (opcao) {
                case 1:
                    exibirTabela(entradaUsuarioHandler);
                    break;
                case 2:
                    iniciarConversor(conversor, entradaUsuarioHandler);
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

    public static void iniciarConversor(Conversor conversor, EntradaUsuarioHandler entradaUsuario) {

        while (true) {
            String entrada = entradaUsuario.validarEntrada();

            try {
                String resultado = conversor.conversorParaCorCodigo(entrada);
                System.out.println(Impressoes.CORRESPONDENTE + resultado);

            } catch (Exception e) {
                System.out.println(Impressoes.ENTRADA_INVALIDA);
                continue;
            }

            int opcao = entradaUsuario.escolher("Digite 0 para voltar ao menu de operações ou 1 para continuar:");

            if (opcao == 0) {
                System.out.println(Impressoes.MENU_OPERACAO);
                return;

            } else if (opcao != 1) {
                System.out.println(Impressoes.OPCAO_INVALIDA);
            }
        }
    }

    public static void exibirTabela(EntradaUsuarioHandler entradaUsuario) {

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

            int opcao = entradaUsuario.escolher("Digite 0 para voltar ao menu de operações: ");

            if (opcao == 0) {
                System.out.println(Impressoes.MENU_OPERACAO);
                return;

            } else {
                System.out.println(Impressoes.OPCAO_INVALIDA);
            }
        }
    }
}
