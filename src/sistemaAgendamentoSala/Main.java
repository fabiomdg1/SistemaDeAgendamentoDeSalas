package sistemaAgendamentoSala;

import java.sql.Connection;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import dao.ClasseDao;
import models.Usuario;
import utilidades.ConexaoBD;


public class Main {
	
	static Connection connection;
	
    static ClasseDao dao = new ClasseDao(connection);

	public static Scanner scanner = new Scanner(System.in);
	public static Usuario usuario = new Usuario();

	public static void main(String[] args) {		
       
        int controle = -1;
		int opcao = 0;
		
		while(controle == -1){
		System.out.println("*********************************************************************");
		System.out.println("Sistema de Agendamento de Salas");
		System.out.println("Escolha uma opção: ");
		System.out.println("1 - Cadastrar usuários ");
		System.out.println("2 - Buscar todos os usuários ");
		System.out.println("3 - Buscar um único usuário ");
		System.out.println("4 - Editar dados de um usuário ");
		System.out.println("5 - Excluir um usuário");
		System.out.println("0 - Para sair");
		
		
			System.out.print("");
			opcao = scanner.nextInt();
			
			switch(opcao){
			case 1:
				cadastrarUsuario();
				break;
			case 2:
				obterTodosUsuarios();
				break;
			case 3:
				obterUmUsuario();
				break;
			case 4:
				atualizarUsuario();
				break;
			case 5:
				System.out.println("Digite o id do usuário: ");
				int id = scanner.nextInt();
				deletarUsuario(id);
				break;
			case 0:
					controle = 0;
					System.out.println("Obrigado!");					
				break;
			}
		}				
	}
	
	
	public static void cadastrarUsuario(){
		
		System.out.print("Digite o nome do usuário: ");		
		usuario.setNome(scanner.next());			
		
		System.out.print("Digite a matrícula do usuário: ");		
		usuario.setMatricula(scanner.next());	
		
		System.out.print("Digite um nome de usuário para login no sistema: ");		
		usuario.setUsuario(scanner.next());	
		
		System.out.print("Cadastre uma senha: ");		
		usuario.setSenha(scanner.next());	
		
		dao.adicionarUsuario(usuario);

	}
	
	public static void obterTodosUsuarios(){
		ConexaoBD.obterConexao();
		List<Usuario> usuarios = dao.obterTodosUsuarios();
        
        System.out.println("Lista de usuários");

        // Imprime os usuários
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Matrícula: " + usuario.getMatricula());
            System.out.println("===========================");
        }

        //ConexaoBD.fecharConexao(connection);
	}
	
	public static void obterUmUsuario(){
		ConexaoBD.obterConexao();
		int idUsuarioProcurado = 1;
	    System.out.print("Informe o ID do usuário: ");
		idUsuarioProcurado = scanner.nextInt();
		  
        Usuario usuario = dao.obterUsuarioPorId(idUsuarioProcurado);

        if (usuario != null) {
            System.out.println("Usuário encontrado:");
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Matrícula: " + usuario.getMatricula());
        } else {
            System.out.println("Usuário não encontrado.");
        }

        ConexaoBD.fecharConexao(connection);
	}
	
	public static void atualizarUsuario(){
		ConexaoBD.obterConexao();		
		int idUsuarioProcurado;
	    System.out.print("Informe o ID do usuário: ");
		idUsuarioProcurado = scanner.nextInt();
		
		Usuario usuario = dao.atualizarUsuario(idUsuarioProcurado);
		ConexaoBD.fecharConexao(connection);
	}
	
	public static void deletarUsuario(int id){
		System.out.println("Teste deletar usuário");
	}
}
