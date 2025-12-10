package io.github.k4rlous.jdbcstocksystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    // Se o arquivo não existir, isso irá criá-lo!
    private static final String URL_JDBC_PADRAO = "jdbc:sqlite:meu_banco_de_dados.db";

    // Método conectar padrão
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL_JDBC_PADRAO);
        } catch (SQLException e) {
            // o 'err' é similar ao 'out', porém dá destaque em vermelho a mensagem em servidores e terminais aptos,
            // dando mais clareza!
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }

    // Método para conectar com url, usuário e senha
    public static Connection conectarGenerico(String url, String usuario, String senha) {
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }
}
