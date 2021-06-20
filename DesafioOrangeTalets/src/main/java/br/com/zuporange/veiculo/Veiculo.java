package br.com.zuporange.veiculo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import br.com.zuporange.usuarios.Usuario;

@Entity
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String tipo;
	
	@NotBlank
	private String marca;
	
	@NotBlank
	private String modelo;
	
	@NotBlank
	private String ano;
	
	private String valor;
	
	private String diaRodizio;
	
	private Boolean rodizio = false;
	
	@ManyToOne
	private Usuario usuario;
	

	public Veiculo(String tipo,String marca, String modelo,String ano,
			String valor,String diaRodizio, Usuario usuario) {

		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
		this.diaRodizio = diaRodizio;
		this.usuario = usuario;
		
	}
	
	public void setDiaRodizio(String diaRodizio) {
		this.diaRodizio = diaRodizio;
	}

	
	public Veiculo() {
	}
	
	public String getTipo() {
		return tipo;
	}

	public String getValor() {
		return valor;
	}

	public String getDiaRodizio() {
		return diaRodizio;
	}

	public Long getId() {
		return id;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public Boolean getRodizio() {
		return rodizio;
	}

	public void setRodizio(Boolean rodizio) {
		this.rodizio = rodizio;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano
				+ ", valor=" + valor + ", diaRodizio=" + diaRodizio + ", rodizio=" + rodizio + ", usuario=" + usuario
				+ "]";
	}
	
	

}
