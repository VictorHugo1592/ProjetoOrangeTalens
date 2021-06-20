package br.com.zuporange.usuarios.dto;

import br.com.zuporange.usuarios.Usuario;

public class UsuarioResponse {

	

	private String nome;
	
	private String cpf;

	private String email;
	
	private String dataNascimento;
	
	
	
	public UsuarioResponse() {
	}
	
	public UsuarioResponse(Usuario usuario) {
		
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.email = usuario.getEmail();
		this.dataNascimento = usuario.getDataNascimento();

	}


	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public Usuario converter() {
		
		return new Usuario(nome, cpf, email, dataNascimento);
	}
	
}
