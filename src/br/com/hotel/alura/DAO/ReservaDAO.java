package br.com.hotel.alura.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import br.com.hotel.alura.modelo.Reserva;

public class ReservaDAO {
	
	private Connection connection;
	
	public ReservaDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public void fazerReserva(Reserva reserva) {
		
		try {
		
			String jpql = "INSERT INTO tbl_reservas "
							+ "(data_entrada, data_saida, valor , forma_de_pagamento)" 
							+ "VALUES (?,?,?,?)";
			
			try (PreparedStatement pstm = connection.prepareStatement(jpql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
				
				pstm.setObject(1, reserva.getDataDeEntrada());
				pstm.setObject(2, reserva.getDataDeSaida());
				pstm.setString(3, reserva.getValor());
				pstm.setString(4, reserva.getFormaDePagamento());
				pstm.executeUpdate();
				
				try(ResultSet rst = pstm.getGeneratedKeys()){
					while(rst.next()) {
						reserva.setId(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	public List<Reserva> listarReservas() {
		
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		String jpql = "SELECT id, "
						+ "data_entrada, "
						+ "data_saida, "
						+ "valor, "
						+ "forma_de_pagamento "
				   + "FROM tbl_reservas";
		
		try (PreparedStatement pstm = connection.prepareStatement(jpql)){
			pstm.execute();
			transformarEmLista(reservas,pstm);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
			
		return reservas;
		
	}
	
	public List<Reserva> buscarReservaPorId(String id) {
		
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		String jpql = "SELECT id, "
						+ "data_entrada, "
						+ "data_saida, valor, "
						+ "forma_de_pagamento "
					+ "FROM tbl_reservas "
					+ "WHERE id = ?;";
		
		try(PreparedStatement pstm = connection.prepareStatement(jpql)){
			pstm.setString(1, id);
			pstm.execute();
			transformarEmLista(reservas,pstm);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
		return reservas;
	} 

	public void atualizarReserva(LocalDate dataDeEntrada, LocalDate dataDeSaida, String valor, String formaDePagamento, Integer id) {
		
		try(PreparedStatement pstm = 
				connection.prepareStatement(
											"UPDATE reservas "
											  + "SET data_entrada=?, "
										  		+ "data_saida=?, "
									  			+ "valor=?, "
									  			+ "forma_pagamento=?  "
									  			+ "WHERE id=?;"
									  		)) {
			pstm.setObject(1, java.sql.Date.valueOf(dataDeEntrada));
			pstm.setObject(2, java.sql.Date.valueOf(dataDeSaida));
			pstm.setString(3, valor);
			pstm.setString(4, formaDePagamento);
			pstm.setInt(5, id);
			pstm.execute();
			
		} catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public void deletarPorId(Integer id) {
		try {
			Statement stm = connection.createStatement();  	
			stm.execute("SET FOREIGN_KEY_CHECKS=0");
			PreparedStatement pstm = connection.prepareStatement("DELETE FROM reservas WHERE id = ?");
			pstm.setInt(1, id);
			pstm.execute();
			stm.execute("SET FOREIGN_KEY_CHECKS=1");
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private void transformarEmLista(List<Reserva> reservas, PreparedStatement pstm) throws SQLException {
		
		try(ResultSet rst = pstm.getResultSet()){
			while(rst.next()) {
				Reserva produto = new Reserva(rst.getInt(1),rst.getDate(2),rst.getDate(3),rst.getString(4), rst.getString(5));
				reservas.add(produto);
			}
		}
}

}


