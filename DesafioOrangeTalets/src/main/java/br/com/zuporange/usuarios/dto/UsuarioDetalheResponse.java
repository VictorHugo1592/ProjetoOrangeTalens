package br.com.zuporange.usuarios.dto;

import java.util.List;
import java.util.Optional;

import br.com.zuporange.veiculo.Veiculo;
import br.com.zuporange.veiculo.dto.VeiculoResponse;

public class UsuarioDetalheResponse {

	private String nome;
	
	private String cpf;

	private String email;
	
	private String dataNascimento;
	
	private Optional<Veiculo> veiculo;
	
	

	public UsuarioDetalheResponse(Optional<Veiculo> retornaListaVeiculos) {
		
		this.veiculo = retornaListaVeiculos;
		
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

	public Optional<Veiculo> getVeiculo() {
		return veiculo;
	}
	
	
	
}
