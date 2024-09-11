package org.example.Handlers;

import org.example.tools.Conversor;
import org.example.tools.Impressoes;

import java.util.Scanner;

public class EntradaUsuarioHandler {
    private final Scanner scanner;
    private final Conversor conversor;

    public EntradaUsuarioHandler(Scanner scanner, Conversor conversor) {
        this.scanner = scanner;
        this.conversor = conversor;
    }

    public String validarEntrada() {

        while (true) {
            System.out.println(Impressoes.VALOR_COR);
            String entrada = scanner.nextLine();

            try {
                conversor.conversorParaCorCodigo(entrada);
                return entrada;

            } catch (Exception e) {
                System.out.println(Impressoes.ENTRADA_INVALIDA);
            }
        }
    }

    public int escolher(String mensagem) {

        while (true) {
            System.out.println(mensagem);

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();
                return opcao;

            } catch (Exception e) {
                System.out.println(Impressoes.ENTRADA_INVALIDA);
                scanner.nextLine();
            }
        }
    }
}