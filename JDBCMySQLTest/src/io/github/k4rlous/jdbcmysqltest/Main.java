package io.github.k4rlous.jdbcmysqltest;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = ConnectionDB.conectar()) {
            ProductDAO produtoDAO = new ProductDAO(conn);
            System.out.println("Conectado com sucesso!");
            produtoDAO.excluirTodos();
            Product produto1 = new Product("Mouse", 70, 49.99, "Estoque Alto");
            Product produto2 = new Product("Monitor", 11, 299.99, "Estoque Baixo");
            Product produto3 = new Product("Headphones", 43, 69.99, "Estoque Alto");

            produtoDAO.inserir(produto1);
            produtoDAO.inserir(produto2);
            produtoDAO.inserir(produto3);




            mostrarProdutos(produtoDAO);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao conectar!");
        }
    }

    // Método para listar os produtos
    private static void mostrarProdutos(ProductDAO produtoDAO) {
        List<Product> todosProdutos = produtoDAO.listarTodos();
        if (todosProdutos.isEmpty()) {
            System.out.println("Nenhum produto encontrado");
        } else {
            System.out.println("Lista de Produtos: ");
            for (Product produto : todosProdutos) {
                System.out.println("PRODUTO: " + produto.getNome() + " | PREÇO: " + produto.getPreco() + " | " +
                        "QUANTIDADE: " + produto.getQuantidade() + " | STATUS: " + produto.getStatus());
            }
        }
    }
}
