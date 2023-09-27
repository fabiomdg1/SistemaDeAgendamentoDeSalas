package models;

public class Usuario {
	
	private int id;
	private String nome;
	private String matricula;
	private String usuario;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getId() {
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getSenha(){
		return senha;
	}
	public void setSenha(String senha){
		this.senha = senha;
	}
	public String getUsuario(){
		return usuario;
	}
	public void setUsuario(String usuario){
		this.usuario = usuario;
	}
	
}
