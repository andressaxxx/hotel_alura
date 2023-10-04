package br.com.hotel.alura.controllers;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import br.com.hotel.alura.DAO.HospedesDAO;
import br.com.hotel.alura.factory.ConnectionFactory;
import br.com.hotel.alura.modelo.Hospedes;

public class HospedesController {

	private HospedesDAO hospedesDAO;
	
	public HospedesController() {
		Connection connection = new ConnectionFactory().makeConnection();
		this.hospedesDAO = new HospedesDAO(connection);
	}
	
	public void salvarHospede(Hospedes hospedes) {
		this.hospedesDAO.salvar(hospedes);
	}
	
	public List<Hospedes> listarHospedes() {
		return this.hospedesDAO.listarHospedes();
	}
	
	public List<Hospedes> buscarHospedePorId(String id) {
		return this.hospedesDAO.buscarPorId(id);
	}
	
	public List<Hospedes> buscarHospedePorNome(String nome) {
		return this.hospedesDAO.buscarPorNome(nome);
	}
	
	public void atualizarCadastro(String nome, String sobreNome, Date dataDeNascimento, String nacionalidade,String telefone, Integer idReserva, Integer id) {
		this.hospedesDAO.atualizarCadastro(nome, sobreNome, dataDeNascimento, nacionalidade, telefone, idReserva, id);
	}
	
	public void DeletarHospede(Integer id) {
		this.hospedesDAO.deletarPorId(id);
	}
	
	
}
