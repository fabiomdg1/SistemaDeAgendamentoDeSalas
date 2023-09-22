package models;

public class Supervisor {
	
	private int id;
	private String nome;
	private String matricula;
	
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

}
