package usuario;

public class CreateUsuario {
	
	private String nome;
	private String matricula;
	private String email;
	private String telefone;
	
	public CreateUsuario(String nome, String matricula, String email, String telefone){
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
		this.telefone = telefone;
	}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public void CriarUsuario(String nome, String matricula, String email, String telefone){
		
	}

}