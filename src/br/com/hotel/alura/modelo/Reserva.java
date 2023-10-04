package br.com.hotel.alura.modelo;

import java.sql.Date;

public class Reserva {
	
	private Integer id;
	private Date dataDeEntrada;
	private Date dataDeSaida;
	private String valor;
	private String formaDePagamento;
	
	public Reserva(Date dataDeEntrada, Date dataDeSaida, String valor, String formaDePagamento) {
		this.dataDeEntrada = dataDeEntrada;
		this.dataDeSaida = dataDeSaida;
		this.valor = valor;
		this.formaDePagamento = formaDePagamento;
	}

	public Reserva(Integer id, Date dataDeEntrada, Date dataDeSaida, String valor, String formaDePagamento) {
		this.id = id;
		this.dataDeEntrada = dataDeEntrada;
		this.dataDeSaida = dataDeSaida;
		this.valor = valor;
		this.formaDePagamento = formaDePagamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataDeEntrada() {
		return dataDeEntrada;
	}

	public void setDataDeEntrada(Date dataDeEntrada) {
		this.dataDeEntrada = dataDeEntrada;
	}

	public Date getDataDeSaida() {
		return dataDeSaida;
	}

	public void setDataDeSaida(Date dataDeSaida) {
		this.dataDeSaida = dataDeSaida;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	
	
	

}
