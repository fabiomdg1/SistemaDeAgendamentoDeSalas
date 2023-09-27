package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import models.Usuario;
import utilidades.ConexaoBD;


public class ClasseDao{


	    private Connection connection;

	    public ClasseDao(){
	    	
	    }
	    
	    public ClasseDao(Connection connection){
	    	this.connection = connection;
	    }  
	    
	    public void cadastrarTeste(){
	    	System.out.println("Teste de Cadastro");
	    }
	    
	    public void verificaLogin(String usuarioDigitado, String senha){
	    	System.out.println("Login");
	    	connection = ConexaoBD.obterConexao();
	    	String senhaBanco = "";
	    
	    	try {
	    		String sql = "select senha from usuario where usuario = ?";		    	
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, usuarioDigitado);
				ResultSet resultSet = preparedStatement.executeQuery();			
				
				if(resultSet.next()){
					senhaBanco = resultSet.getString("senha");
					System.out.println("Senha Digitada: " + senha);
					System.out.println("Senha Banco: " + senhaBanco);
					if(senhaBanco.equals(senha.toString())){
						JOptionPane.showMessageDialog(null, "Login efetuado com sucesso");	
						System.out.println("Ok");
					}else{
						System.out.println("Erro");
						JOptionPane.showMessageDialog(null, "Usuário ou Senha Incorretos !");
					}
				}else{
					System.out.println("Teste login");	
				}						
				
			} catch (SQLException e) {				
				e.printStackTrace();
			}
	    }

	    public void adicionarUsuario(Usuario usuario) {
	    	connection = ConexaoBD.obterConexao();
	    	    try {

	    	        String sql = "INSERT INTO usuario (nome, matricula,usuario, senha) VALUES (?, ?, ?, ?)";
	    	        System.out.println(sql);
	    	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    	        
	    	        preparedStatement.setString(1, usuario.getNome());
	    	        preparedStatement.setString(2, usuario.getMatricula());
	    	        preparedStatement.setString(3, usuario.getUsuario());
	    	        preparedStatement.setString(4, usuario.getSenha());
	    	        
	    	        int rowsAffected = preparedStatement.executeUpdate();
	    	        
	    	        if (rowsAffected > 0) {
	    	            System.out.println("Usuário cadastrado com sucesso.");
	    	        } else {
	    	            System.out.println("Falha ao adicionar o usuário.");
	    	        }
	    	        	    	        
	    	        preparedStatement.close();
	    	        ConexaoBD.fecharConexao(connection);
	    	    } catch (SQLException e) {
	    	        e.printStackTrace();
	    	        System.out.println("Erro ao inserir usuário");	    	        
	    	    }
	    	    
	    }
	    
	    public List<Usuario> obterTodosUsuarios() {
	    	connection = ConexaoBD.obterConexao();    	
	        List<Usuario> usuarios = new ArrayList<>();
	        try {
	            
	        	String sql = "SELECT * FROM usuario";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String nome = resultSet.getString("nome");
	                String matricula = resultSet.getString("matricula");
	                String nomeDeUsuario = resultSet.getString("usuario");
	                String senha = resultSet.getString("senha");

	                Usuario usuario = new Usuario();
	                usuario.setId(id);
	                usuario.setNome(nome);
	                usuario.setMatricula(matricula);
	                usuario.setUsuario(nomeDeUsuario);
	                usuario.setSenha(senha);

	                usuarios.add(usuario);
	            }

	            resultSet.close();
	            preparedStatement.close();
	            ConexaoBD.fecharConexao(connection);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Erro ao buscar todos os usuários");
	        }
	        return usuarios;
	    }
	    

	    public Usuario obterUsuarioPorId(int id) {
	    	connection = ConexaoBD.obterConexao();
	    	ResultSet resultSet = null;
	    	Usuario usuario = null;


	    	try {
	    	String sql = "SELECT * FROM usuario WHERE id = ?";
	    	
	    	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    	
	    	
	    	
	    	    preparedStatement.setInt(1, id);
	    	    
	    	    resultSet = preparedStatement.executeQuery();
	    	    if (resultSet.next()) {
	    	    	usuario = new Usuario();
	    	        usuario.setId(resultSet.getInt("id"));
	    	        usuario.setNome(resultSet.getString("nome"));
	    	        usuario.setMatricula(resultSet.getString("matricula"));
	    	     }
	    	    ConexaoBD.fecharConexao(connection);
	    	 } catch (SQLException e) {
	    		 e.printStackTrace();	    	    
	    	}
	    	return usuario;
	    }

	    
	    public Usuario atualizarUsuario(int id) {
	    	connection = ConexaoBD.obterConexao();
	    	ResultSet resultSet = null;
	    	Usuario usuario = null;


	    	try {
	    	String sql = "SELECT * FROM usuario WHERE id = ?";
	    	
	    	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    	
	    	
	    	
	    	    preparedStatement.setInt(1, id);
	    	    
	    	    resultSet = preparedStatement.executeQuery();
	    	    if (resultSet.next()) {
	    	    	usuario = new Usuario();
	    	        usuario.setId(resultSet.getInt("id"));
	    	        usuario.setNome(resultSet.getString("nome"));
	    	        usuario.setMatricula(resultSet.getString("matricula"));
	    	     }
	    	    ConexaoBD.fecharConexao(connection);
	    	 } catch (SQLException e) {
	    		 e.printStackTrace();	    	    
	    	}
	    	return usuario;
	    }
	    
	    
	    public void deletarUsuario(int id) {
	    	connection = ConexaoBD.obterConexao();
	    	
	    	ConexaoBD.fecharConexao(connection);

	    }    
}
	
