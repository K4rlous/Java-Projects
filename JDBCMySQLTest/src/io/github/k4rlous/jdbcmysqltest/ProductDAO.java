package io.github.k4rlous.jdbcmysqltest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDAO {
    private final Connection CONEXAO_DB;

    // Construtor que inicializa a conexão com o banco de dados
    public ProductDAO(Connection conexao) {
        this.CONEXAO_DB = conexao;
    }

    // Método para inserir um novo produto no banco de dados
    public void inserir(Product produto) {
        // Usamos um '?' para cada argumento, poderíamos inserir os valores diretamente, mas assim fica mais flexível!
        String sql = "INSERT INTO produtos (nome_produto, quantidade, preco, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = CONEXAO_DB.prepareStatement(sql)) {
            stmt.setString(1,
                    produto.getNome()); // Como usamos um objeto 'Produto' aqui inserimos no espaço 1, o nome do
            // produto!
            stmt.setInt(2, produto.getQuantidade()); // Aqui definimos a quantidade, que está na posição 2!
            stmt.setDouble(3, produto.getPreco()); // Definimos o preço
            stmt.setString(4, produto.getStatus()); // E finalmente o status!
            stmt.executeUpdate(); // Para executar a 'Query'!
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir produto: " + ex.getMessage());
        }
    }

    // Método para excluir TODOS os produtos do banco de dados
    public void excluirTodos() {
        String sql = "DELETE FROM produtos";
        try (PreparedStatement stmt = CONEXAO_DB.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir todos os produtos: " + ex.getMessage());
        }
    }

    // Método para consultar um produto pelo seu ID
    public Product consultarPorId(int id) {
        String sql = "SELECT * FROM produtos WHERE id_produto = ?";
        try (PreparedStatement stmt = CONEXAO_DB.prepareStatement(sql)) {
            stmt.setInt(1, id); // Definindo o parâmetro do ID antes de executar a consulta
            try (ResultSet rs = stmt.executeQuery()) { // Try aninhado
                if (rs.next()) { // Se houver resultado, ele retorna verdadeiro e entra nesse IF
                    Product produto = new Product(); // Aqui 'criamos' o objeto com os dados do Banco de dados!
                    produto.setId(rs.getInt("id_produto")); // 'rs' é Result Set, todos os dados dos getters vem do
                    // banco de dados!
                    produto.setNome(rs.getString("nome_produto")); // Não precisamos pôr os campos na ordem certa!
                    produto.setQuantidade(rs.getInt("quantidade"));
                    produto.setStatus(rs.getString("status"));
                    produto.setPreco(rs.getDouble("preco"));
                    return produto; // Após 'montar' o produto com os dados obtidos, retornamos ele!
                }
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao consultar produto por ID: " + ex.getMessage());
        }
        return null; // Se não houver resultado, retorna nulo
    }


    // Método para atualizar as informações de um produto no banco de dados
    public void atualizar(Product produto) {
        String sql = "UPDATE produtos SET nome_produto = ?, quantidade = ?, preco = ?, status = ? WHERE id_produto = ?";
        try (PreparedStatement stmt = CONEXAO_DB.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getPreco());
            stmt.setString(4, produto.getStatus());
            stmt.setInt(5, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar produto: " + ex.getMessage());
        }
    }

    // Método para excluir um produto pelo ID
    public void excluir(int id) {
        String sql = "DELETE FROM produtos WHERE id_produto = ?";
        try (PreparedStatement stmt = CONEXAO_DB.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir produto: " + ex.getMessage());
        }
    }

    // Método para listar todos os produtos do banco de dados
    public List<Product> listarTodos() {
        List<Product> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (PreparedStatement stmt = CONEXAO_DB.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) { // Enquanto houver produtos dentro do Result Set...
                Product produto = new Product();
                produto.setId(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome_produto"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setStatus(rs.getString("status"));
                produtos.add(produto); // Adicionamos o produto com suas características a lista
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao listar produtos: " + ex.getMessage());
        }
        return produtos;
    }
}
