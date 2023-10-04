package br.com.hotel.alura.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.hotel.alura.factory.ConnectionFactory;

public class Usuario {
	
	private String nome;
	private String senha;
	
	public Usuario(String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static boolean validarUsuario(String nome, String senha) {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rst = null;
		try {
			connection = factory.makeConnection();
			pstm = connection.prepareStatement("SELECT * "
											+ "FROM usuarios "
											+ "WHERE nome=? "
												+ "AND senha=?;");
			pstm.setString(1, nome);
			pstm.setString(2, senha);
			rst = pstm.executeQuery();
			return rst.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(rst != null);
					rst.close();
				if (pstm != null);
					pstm.close();
				if (connection != null);
					connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	

}
