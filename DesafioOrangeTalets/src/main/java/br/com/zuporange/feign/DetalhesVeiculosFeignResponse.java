package br.com.zuporange.feign;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetalhesVeiculosFeignResponse {

    @JsonProperty("Valor")
    private String valor;

    @JsonProperty("Marca")
    private String marca;

    @JsonProperty("Modelo")
    private String modelo;

    @JsonProperty("AnoModelo")
    private String anoModelo;

    @JsonProperty("Combustivel")
    private String combustivel;

    @JsonProperty("CodigoFipe")
    private String codigoFipe;

    @JsonProperty("MesReferencia")
    private String mesReferencia;

    @JsonProperty("TipoVeiculo")
    private String tipoVeiculo;

    @JsonProperty("SiglaCombustivel")
    private String siglaCombustivel;

	public String getValor() {
		return valor;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getAnoModelo() {
		return anoModelo;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public String getCodigoFipe() {
		return codigoFipe;
	}

	public String getMesReferencia() {
		return mesReferencia;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public String getSiglaCombustivel() {
		return siglaCombustivel;
	}

	@Override
	public String toString() {
		return "DetalhesVeiculosFeignResponse [valor=" + valor + ", marca=" + marca + ", modelo=" + modelo
				+ ", anoModelo=" + anoModelo + ", combustivel=" + combustivel + ", codigoFipe=" + codigoFipe
				+ ", mesReferencia=" + mesReferencia + ", tipoVeiculo=" + tipoVeiculo + ", siglaCombustivel="
				+ siglaCombustivel + "]";
	}
	
	
    
}
