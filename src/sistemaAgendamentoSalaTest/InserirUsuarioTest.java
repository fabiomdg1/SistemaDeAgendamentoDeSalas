package sistemaAgendamentoSalaTest;

import java.sql.Connection;

import dao.ClasseDao;
import models.Usuario;
import utilidades.ConexaoBD;

public class InserirUsuarioTest {

	public static void main(String[] args) {

		        Connection connection = ConexaoBD.obterConexao();

		        ClasseDao dao = new ClasseDao(connection);

		        Usuario usuario = new Usuario();
		        
		        usuario.setNome("John Doe");
		        usuario.setMatricula("12345");

		        dao.adicionarUsuario(usuario);

		        ConexaoBD.fecharConexao(connection);
	}

}
