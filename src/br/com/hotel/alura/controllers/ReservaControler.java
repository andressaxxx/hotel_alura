package br.com.hotel.alura.controllers;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import br.com.hotel.alura.DAO.ReservaDAO;
import br.com.hotel.alura.factory.ConnectionFactory;
import br.com.hotel.alura.modelo.Reserva;

public class ReservaControler {

	private ReservaDAO reservaDAO;
	
	public ReservaControler() {
		Connection connection = new ConnectionFactory().makeConnection();
		this.reservaDAO = new ReservaDAO(connection);
	}

	public void salvarReserva(Reserva reserva) {
		this.reservaDAO.fazerReserva(reserva);
	}
	
	public List<Reserva> listarReservas() {
		return this.reservaDAO.listarReservas();
	}
	
	public List<Reserva> buscarReserva(String id) {
		return this.reservaDAO.buscarReservaPorId(id);
	}
	
	public void atualizarReserva(LocalDate dataDeEntrada, LocalDate dataDeSaida, String valor, String formaDePagamento, Integer id) {
		this.reservaDAO.atualizarReserva(dataDeEntrada, dataDeSaida, valor, formaDePagamento, id);
	}
	
	public void deletarReserva(Integer id) {
		this.reservaDAO.deletarPorId(id);
	}
	
}
