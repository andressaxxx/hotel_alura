package br.com.hotel.alura.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.hotel.alura.modelo.Hospedes;

public class HospedesDAO {

	private Connection connection;
	
	public HospedesDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Hospedes hospedes) {
		
		try {
			String jpql = "INSERT INTO tbl_hospedes "
					+ "(nome, sobrenome, data_nascimento, nacionalidade, telefone, id_reserva) "
					+ "VALUES(?,?,?,?,?,?);";
			
			try(PreparedStatement pstm = connection.prepareStatement(jpql, Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, hospedes.getNome());
				pstm.setString(2, hospedes.getSobreNome());
				pstm.setObject(3, hospedes.getDataDeNascimento());
				pstm.setString(4, hospedes.getNacionalidade());
				pstm.setString(5, hospedes.getTelefone());
				pstm.setInt(6, hospedes.getIdReserva());
				pstm.execute();
				try(ResultSet rst = pstm.getGeneratedKeys()){
					while (rst.next()) {
						hospedes.setId(rst.getInt(1));
					}
				}
			}
		} catch(SQLException e) {
			throw new RuntimeException();
		}
		
	}

	public List<Hospedes> listarHospedes() {
		
		List<Hospedes> hospedes = new ArrayList<Hospedes>();
		try {
			String jpql =  "SELECT id, "
							+ "nome, "
							+ "sobrenome, "
							+ "data_nascimento, "
							+ "nacionalidade,"
							+ "telefone, "
							+ "id_reserva "
						+ "FROM tbl_hospedes;";
			try(PreparedStatement pstm = connection.prepareStatement(jpql)){
				pstm.execute();
				converterParaLista(hospedes,pstm);
			}
			
			return hospedes;
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public List<Hospedes> buscarPorId(String id) {
		
		List<Hospedes> hospedes = new ArrayList<Hospedes>();
		try {
			String jpql = "SELECT id, "
							+ "nome, "
							+ "sobrenome, "
							+ "data_nascimento, "
							+ "nacionalidade,"
							+ "telefone, "
							+ "id_reserva "
						+ "FROM tbl_hospedes "
						+ "WHERE id=?;";
			try(PreparedStatement pstm = connection.prepareStatement(jpql)){
				pstm.setString(1, id);
				pstm.execute();
				converterParaLista(hospedes,pstm);
			}
			
			return hospedes;
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public List<Hospedes> buscarPorNome(String nome) {
		
		List<Hospedes> hospedes = new ArrayList<Hospedes>();
		try {
			String jpql = "SELECT id, "
					+ "nome, "
					+ "sobrenome, "
					+ "data_nascimento, "
					+ "nacionalidade,"
					+ "telefone, "
					+ "id_reserva "
					+ "FROM tbl_hospedes "
					+ "WHERE nome=?;";
			try(PreparedStatement pstm = connection.prepareStatement(jpql)){
				pstm.setString(1, nome);
				pstm.execute();
				converterParaLista(hospedes,pstm);
			}
			
			return hospedes;
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public void atualizarCadastro (String nome, String sobreNome, Date dataDeNascimento, String nacionalidade, String telefone, Integer idReserva, Integer id) {
		
		try(PreparedStatement pstm = 
				connection.prepareStatement("UPDATE tbl_hospedes "
												+ "SET "
													+ "nome=?, "
													+ "sobrenome=?, "
													+ "data_nascimento=?, "
													+ "nacionalidade=?," 
													+ "telefone=?, "
													+ "id_reserva=? "
												+ "WHERE id=?;")){
			pstm.setString(1, nome);
			pstm.setString(2, sobreNome);
			pstm.setObject(3, dataDeNascimento);
			pstm.setString(4, nacionalidade);
			pstm.setString(5, telefone);
			pstm.setInt(6, idReserva);
			pstm.setInt(7, id);
			pstm.execute();
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
	}
	
	public void deletarPorId(Integer id) {
		try {
			Statement stm = connection.createStatement();  	
			stm.execute("SET FOREIGN_KEY_CHECKS=0");
			PreparedStatement pstm = connection.prepareStatement("DELETE FROM tbl_hospedes WHERE id = ?");
			pstm.setInt(1, id);
			pstm.execute();
			stm.execute("SET FOREIGN_KEY_CHECKS=1");
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private void converterParaLista(List<Hospedes> hospedes, PreparedStatement pstm) throws SQLException {
			try(ResultSet rst = pstm.executeQuery()){
				while(rst.next()) {
					Hospedes produto = new Hospedes(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDate(4), rst.getString(5),rst.getString(6),rst.getInt(7));
					hospedes.add(produto);
				}
			}
		}	
	
	
}
