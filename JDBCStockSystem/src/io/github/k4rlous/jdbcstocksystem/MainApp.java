package io.github.k4rlous.jdbcstocksystem;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        try (Connection conexao = ConnectionDB.conectar()){
            ProductDAO produtoDAO = new ProductDAO(conexao);

            /*
            // Listar todos os produtos (deve estar vazio neste ponto)
            mostrarProdutos(produtoDAO);

            // Exemplo de inserção de produtos
            Product novoProduto1 = new Product("Notebook", 10, 1999.99, "Em estoque");
            Product novoProduto2 = new Product("Smartphone", 20, 1499.99, "Estoque baixo");
            Product novoProduto3 = new Product("Tablet", 15, 799.99, "Estoque baixo");

            produtoDAO.inserir(novoProduto1);
            produtoDAO.inserir(novoProduto2);
            produtoDAO.inserir(novoProduto3);
            */


            // Lista todos os produtos após a inserção
            mostrarProdutos(produtoDAO);

            // Exclui os produtos conforme o ID
            // produtoDAO.excluir(3);

            // Excluindo todos os produtos
            produtoDAO.excluirTodos();

            mostrarProdutos(produtoDAO);

            produtoDAO.inserir(new Product("Teclado", 20, 59.99, "Estoque baixo"));

            mostrarProdutos(produtoDAO);


            /*
            // Exemplo de consulta por ID e renomeação (consultando o produto com ID '1')
            Product produtoConsultado = produtoDAO.consultarPorId(1);
            if (produtoConsultado != null){ // Se o produto for diferente de nulo...
                produtoConsultado.setNome("Laptop"); // Mudamos o nome dele
                System.out.println("Novo nome do produto: " + produtoConsultado.getNome());
                produtoDAO.atualizar(produtoConsultado); // Atualizamos no banco de dados
                System.out.println("A base de dados ficou assim: ");
                mostrarProdutos(produtoDAO);

            } else {
                System.err.println("Produto não encontrado.");
            }
            */
        } catch (Exception ex) {
            System.err.println("Erro geral: "  + ex.getMessage());
        }
    }

    // Método para listar os produtos
    private static void mostrarProdutos(ProductDAO produtoDAO){
        List<Product> todosProdutos = produtoDAO.listarTodos();
        if (todosProdutos.isEmpty()){
            System.out.println("Nenhum produto encontrado");
        }  else {
            System.out.println("Lista de Produtos: ");
            for (Product produto : todosProdutos){
                System.out.println(produto.getId() + ": " + produto.getNome() + " - " + produto.getPreco());
            }
        }
    }
}
