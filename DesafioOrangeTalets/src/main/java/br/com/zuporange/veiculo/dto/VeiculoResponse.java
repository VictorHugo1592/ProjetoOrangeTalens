package br.com.zuporange.veiculo.dto;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import br.com.zuporange.usuarios.Usuario;
import br.com.zuporange.veiculo.Veiculo;

public class VeiculoResponse {

private Long id;
	
	private String tipo;
	
	private String marca;
	
	private String modelo;

	private String ano;
	
	private String valor;
	
	private String diaRodizio;

	private Boolean rodizio;
	

	public VeiculoResponse(Veiculo veiculo) {

		this.tipo = veiculo.getTipo();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.ano = veiculo.getAno();
		this.valor = veiculo.getValor();
		this.diaRodizio = veiculo.getDiaRodizio();
		this.rodizio = veiculo.getRodizio();
		
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

	public Boolean getRodizio() {
		return rodizio;
	}
	
	
	
}
