package com.example.biblioteca.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.biblioteca.database.DatabaseConnection;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.view.BibliotecaView;

public class BibliotecaController {
    private List<Livro> livros;
    private BibliotecaView view;
    private Connection connection;
    
    public BibliotecaController(BibliotecaView view) {
        this.view = view;
        this.livros = new ArrayList<>();
        this.connection = DatabaseConnection.getConnection();
    }

    public void cadastrarLivro(String titulo) {
        Livro novoLivro = new Livro(titulo, titulo);
        livros.add(novoLivro);
        salvarLivroNoBanco(titulo);
        view.mostrarMensagem("Livro cadastrado com sucesso: " + titulo);
    }

    private void salvarLivroNoBanco(String titulo) {
        String sql = "INSERT INTO livros (titulo) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, titulo);
            statement.executeUpdate();
            System.out.println("Livro cadastrado no banco de dados: " + titulo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            view.mostrarMensagem("Não há livros cadastrados na biblioteca.");
        } else {
            view.mostrarLivros(livros);
        }
    }

    public void emprestarLivro(String titulo) {
        Livro livro = encontrarLivro(titulo);
        if (livro != null && !livro.isEmprestado()) {
            livro.setEmprestado(true);
            view.mostrarMensagem("Livro emprestado: " + titulo);
        } else {
            view.mostrarMensagem("Livro não disponível para empréstimo: " + titulo);
        }
    }

    public void devolverLivro(String titulo) {
        Livro livro = encontrarLivro(titulo);
        if (livro != null && livro.isEmprestado()) {
            livro.setEmprestado(false);
            view.mostrarMensagem("Livro devolvido: " + titulo);
        } else {
            view.mostrarMensagem("Livro não encontrado ou não está emprestado: " + titulo);
        }
    }

    private Livro encontrarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }
}



