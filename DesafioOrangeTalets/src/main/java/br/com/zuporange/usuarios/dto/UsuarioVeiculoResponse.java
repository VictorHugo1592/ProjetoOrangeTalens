package br.com.zuporange.usuarios.dto;

import java.util.List;

import br.com.zuporange.veiculo.Veiculo;

public class UsuarioVeiculoResponse {

	
	private String nome;
	
	private String cpf;

	private String email;
	
	private String dataNascimento;
	
	private String veiculo;

	
	
	
	public UsuarioVeiculoResponse(Veiculo veiculo) {

		this.nome = veiculo.getUsuario().getNome();
		this.cpf = veiculo.getUsuario().getCpf();
		this.email = veiculo.getUsuario().getEmail();
		this.dataNascimento = veiculo.getUsuario().getDataNascimento();
		this.veiculo = veiculo.getModelo();
		
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

	public String getVeiculo() {
		return veiculo;
	}

	@Override
	public String toString() {
		return "UsuarioVeiculoResponse [nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", dataNascimento="
				+ dataNascimento + ", veiculo=" + veiculo + "]";
	}
	
	
	
}
