package br.com.zuporange.usuarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import br.com.zuporange.veiculo.Veiculo;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
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
	
	@OneToMany(mappedBy = "usuario")
	private List<Veiculo> veiculo = new ArrayList<>();
	
	//Usado pelo framework
	public Usuario() {};
	
	
	public Usuario(String nome,String cpf, String email, String dataNascimento) {
	
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

	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	
}
