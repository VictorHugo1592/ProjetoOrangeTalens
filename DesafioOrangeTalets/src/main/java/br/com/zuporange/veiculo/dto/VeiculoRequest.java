package br.com.zuporange.veiculo.dto;

import java.util.Optional;

import br.com.zuporange.usuarios.Usuario;
import br.com.zuporange.usuarios.UsuarioRepository;
import br.com.zuporange.veiculo.Veiculo;

public class VeiculoRequest {

	private Long id;
	
	private String tipo;
	
	private String marca;
	
	private String modelo;

	private String ano;

	private String valor;
	
	private String diaRodizio;
	
	private String emailUsuario;
	
	public VeiculoRequest() {}


	public VeiculoRequest(String tipo,String marca,  String modelo, String ano,
			String valor, String diaRodizio, String emailUsuario) {
		
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
		this.diaRodizio = diaRodizio;
		this.emailUsuario = emailUsuario;
	}


	public Long getId() {
		return id;
	}
	
	public String getTipo() {
		return tipo;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getAno() {
		return ano;
	}

	public String getValor() {
		return valor;
	}


	public String getDiaRodizio() {
		return diaRodizio;
	}
	
	public String getEmailUsuario() {
		return emailUsuario;
	}

	public Veiculo converter(UsuarioRepository usuarioRepository) {
		
		Optional<Usuario> procurarUsuario = usuarioRepository.findByEmail(emailUsuario);
		
		return new Veiculo(tipo, marca,  modelo, ano,
				 valor, diaRodizio, procurarUsuario.get());
		
	}
	
	
	
}
