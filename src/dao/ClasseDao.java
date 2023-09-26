package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
	    
	    public void verificaLogin(){
	    	System.out.println("Verificando login");
	    }

	    public void adicionarUsuario(Usuario usuario) {
	    	    try {

	    	        String sql = "INSERT INTO usuario (nome, matricula) VALUES (?, ?)";
	    	        
	    	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    	        
	    	        preparedStatement.setString(1, usuario.getNome());
	    	        preparedStatement.setString(2, usuario.getMatricula());
	    	        
	    	        int rowsAffected = preparedStatement.executeUpdate();
	    	        
	    	        if (rowsAffected > 0) {
	    	            System.out.println("Usuário cadastrado com sucesso.");
	    	        } else {
	    	            System.out.println("Falha ao adicionar o usuário.");
	    	        }
	    	        	    	        
	    	        preparedStatement.close();
	    	    } catch (SQLException e) {
	    	        e.printStackTrace();
	    	        System.out.println("Erro ao inserir usuário");
	    	        
	    	    }
	    }
	    
	    public List<Usuario> obterTodosUsuarios() {
	        List<Usuario> usuarios = new ArrayList<>();
	        try {
	            String sql = "SELECT * FROM usuario";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String nome = resultSet.getString("nome");
	                String matricula = resultSet.getString("matricula");

	                Usuario usuario = new Usuario();
	                usuario.setId(id);
	                usuario.setNome(nome);
	                usuario.setMatricula(matricula);

	                usuarios.add(usuario);
	            }

	            resultSet.close();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Erro ao buscar todos os usuários");
	        }
	        return usuarios;
	    }
	    

	    public Usuario obterUsuarioPorId(int id) {
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
	    	 } catch (SQLException e) {
	    		 e.printStackTrace();	    	    
	    	}
	    	return usuario;
	    }

	    
	    public Usuario atualizarUsuario(int id) {
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
	    	 } catch (SQLException e) {
	    		 e.printStackTrace();	    	    
	    	}
	    	return usuario;
	    }
	    
	    
	    public void deletarUsuario(int id) {

	    }    
}
	
