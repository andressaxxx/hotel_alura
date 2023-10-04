package br.com.hotel.alura.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;
	
	public ConnectionFactory() {
		
		ComboPooledDataSource pool = new ComboPooledDataSource();
		
		pool.setJdbcUrl("jdbc:mysql://localhost/db_alura_hotel?useTimezone=true&serverTimezone=UTC");
		pool.setUser("root");
		pool.setPassword("root");
		
		this.dataSource = pool;
	}
	
	public Connection makeConnection() {
		
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("Erro ao criar a conexao!");
			throw new RuntimeException(e);
		}
		
	}

	
}
