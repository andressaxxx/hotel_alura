package br.com.hotel.alura.factory;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteDeConexao {

	public static void main(String[] args) {
		
		ConnectionFactory factory = new ConnectionFactory();
		
		System.out.println("Inicio!");
		Connection connection = factory.makeConnection();
		System.out.println("Conexao realizada com sucesso!");
		
		try {
			connection.close();
			System.out.println("Conexao fechada com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao fechar a conexao!");
			throw new RuntimeException();
		} finally {
			System.out.println("Fim!"); 
		}
		
	}
	
}
