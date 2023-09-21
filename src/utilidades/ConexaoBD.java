package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static final String URL = "jdbc:mysql:agendasalas.mysql.dbaas.com.br";
    private static final String USUARIO = "agendasalas";
    private static final String SENHA = "";

    
    //Método de Conexão com banco de dados
    public static Connection obterConexao() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }

    //Método para fechar conexão com banco de dados
    public static void fecharConexao(Connection conexao) {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            // Tratar o erro de fechamento da conexão, se necessário
        }
    }
}
