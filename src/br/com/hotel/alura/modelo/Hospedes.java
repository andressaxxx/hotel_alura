package br.com.hotel.alura.modelo;

import java.sql.Date;

public class Hospedes {
	
	private Integer id;
	private String nome;
	private String sobreNome;
	private Date dataDeNascimento;
	private String nacionalidade;
	private String telefone;
	private Integer idReserva;
	
	public Hospedes(String nome, String sobreNome, Date dataDeNascimento, String nascionalidade, String telefone,
			Integer idReserva) {
		super();
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.dataDeNascimento = dataDeNascimento;
		this.nacionalidade = nascionalidade;
		this.telefone = telefone;
		this.idReserva = idReserva;
	}

	public Hospedes(Integer id, String nome, String sobreNome, Date dataDeNascimento, String nascionalidade,
			String telefone, Integer idReserva) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.dataDeNascimento = dataDeNascimento;
		this.nacionalidade = nascionalidade;
		this.telefone = telefone;
		this.idReserva = idReserva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}
	

	
	
	
}
