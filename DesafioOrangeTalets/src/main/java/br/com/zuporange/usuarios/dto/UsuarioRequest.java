package br.com.zuporange.usuarios.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import br.com.zuporange.usuarios.Usuario;

public class UsuarioRequest {
	
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@CPF
	private String cpf;
	
	@NotBlank
	@Email
	private String email;
	
	private String dataNascimento;
	
	
	public UsuarioRequest() {
	}
	
	public UsuarioRequest(String nome, String cpf, String email, String dataNascimento) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		
	}



	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
	
	public String getEmail() {
		return email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public Usuario converter() {
		
		return new Usuario(nome, cpf, email, dataNascimento);
	}

}
