package panela.com.agenda.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

public class PacienteDTO {
		
	@NotBlank(message = "nome obrigatorio")
	String nome;
	@NotBlank(message = "sobrenome obrigatorio")
	String sobrenome;
	@Email(message = "email invalido")
	String email;
	@CPF(message = "cpf invalido")
	String cpf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public PacienteDTO(String nome, String sobrenome, String email, String cpf) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.cpf = cpf;
	}
	public PacienteDTO() {
		
	}
	
	
	
	
}
