package sistemaAgendamentoSalaTest;

import java.sql.Connection;

import dao.ClasseDao;
import models.Usuario;
import utilidades.ConexaoBD;

public class ObterUmUsuarioTest {

	public static void main(String[] args) {
		  Connection connection = ConexaoBD.obterConexao();
	      ClasseDao dao = new ClasseDao(connection);
	      
	      int idUsuarioProcurado = 1;
	      
	        Usuario usuario = dao.obterUsuarioPorId(idUsuarioProcurado);

	        if (usuario != null) {
	            System.out.println("Usuário encontrado.");
	            System.out.println("ID: " + usuario.getId());
	            System.out.println("Nome: " + usuario.getNome());
	            System.out.println("Matrícula: " + usuario.getMatricula());
	        } else {
	            System.out.println("Usuário não encontrado.");
	        }

	        ConexaoBD.fecharConexao(connection);
    }   
}

