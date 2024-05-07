package com.example.biblioteca.Main;

import com.example.biblioteca.Controller.BibliotecaController;
import com.example.biblioteca.view.BibliotecaView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaView view = new BibliotecaView();
        BibliotecaController controller = new BibliotecaController(view);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            view.exibirMenu();
            String comando = scanner.nextLine();

            switch (comando) {
                case "1":
                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.nextLine();
                    controller.cadastrarLivro(titulo);
                    break;
                case "2":
                    controller.listarLivros();
                    break;
                case "3":
                    System.out.println("Digite o título do livro que deseja emprestar:");
                    String tituloEmprestimo = scanner.nextLine();
                    controller.emprestarLivro(tituloEmprestimo);
                    break;
                case "4":
                    System.out.println("Digite o título do livro que deseja devolver:");
                    String tituloDevolucao = scanner.nextLine();
                    controller.devolverLivro(tituloDevolucao);
                    break;
                case "5":
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Comando não reconhecido. Tente novamente.");
            }
        }
    }
}

