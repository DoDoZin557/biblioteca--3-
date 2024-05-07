package com.example.biblioteca.view;

import java.util.List;
import com.example.biblioteca.model.Livro;

public class BibliotecaView {
    public void exibirMenu() {
        System.out.println("### Menu ###");
        System.out.println("1. Cadastrar Livro");
        System.out.println("2. Listar Livros");
        System.out.println("3. Emprestar Livro");
        System.out.println("4. Devolver Livro");
        System.out.println("5. Sair");
        System.out.println("Escolha uma opção: ");
    }

    public void exibirLivros(List<Livro> livros) {
        System.out.println("### Livros na Biblioteca ###");
        for (Livro livro : livros) {
            System.out.println(livro.getTitulo());
        }
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void mostrarLivros(List<Livro> livros) {
        System.out.println("Livros na biblioteca:");
        for (Livro livro : livros) {
            System.out.println(livro.getTitulo());
        }
    }
}


