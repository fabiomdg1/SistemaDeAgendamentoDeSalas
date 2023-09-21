package sistemaAgendamentoSalaTest;

import java.sql.Connection;

import utilidades.ConexaoBD;

public class ConexaoBDTest {

	public static void main(String[] args) {
		
		testeDeConexaoBD();
		
		
	}
	
	public static void testeDeConexaoBD(){		
		
		 try {
	            // Obtém uma conexão com o banco de dados
	            Connection conexao = ConexaoBD.obterConexao();

	            // Se chegou até aqui, a conexão foi bem-sucedida
	            System.out.println("Conexão com o banco de dados estabelecida com sucesso.");

	            // Fecha a conexão
	            ConexaoBD.fecharConexao(conexao);	            
	        } catch (Exception e) {
	            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
	        }
	}

}
