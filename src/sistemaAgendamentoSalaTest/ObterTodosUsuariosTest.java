package sistemaAgendamentoSalaTest;

import java.sql.Connection;
import java.util.List;
import dao.ClasseDao;
import models.Usuario;
import utilidades.ConexaoBD;

public class ObterTodosUsuariosTest {

	public static void main(String[] args) {
		
        Connection connection = ConexaoBD.obterConexao();
        ClasseDao dao = new ClasseDao(connection);

        // Chama o método para obter todos os usuários
        List<Usuario> usuarios = dao.obterTodosUsuarios();
        
        System.out.println("Lista de usuários");

        // Imprime os usuários
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Matrícula: " + usuario.getMatricula());
            System.out.println("===========================");
        }

        // Fecha a conexão com o banco de dados
        ConexaoBD.fecharConexao(connection);

	}

}
