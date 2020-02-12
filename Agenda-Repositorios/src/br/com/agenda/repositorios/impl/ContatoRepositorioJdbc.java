package br.com.agenda.repositorios.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.entidades.Contato;
import br.com.agenda.repositorios.factories.ConnectionFactory;
import br.com.agenda.repositorios.interfaces.AgendaRepositorio;

public class ContatoRepositorioJdbc implements AgendaRepositorio<Contato> {

	@Override
	public List<Contato> selectAll() throws SQLException {
		List<Contato> contatos = new ArrayList<Contato>();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM contato;");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Contato contato = new Contato();
			contato.setNome(rs.getString("nome"));
			contato.setIdade(rs.getInt("idade"));
			contato.setTelefone(rs.getString("telefone"));
			contatos.add(contato);
		}
		return contatos;
	}

	@Override
	public void save(Contato entity) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = con.prepareStatement("INSERT INTO contato VALUES (?, ?, ?);");
		stmt.setString(1, entity.getNome());
		stmt.setInt(2, entity.getIdade());
		stmt.setString(3, entity.getTelefone());
		stmt.execute();
	}

	@Override
	public void delete(Contato entity) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = con.prepareStatement("DELETE FROM contato WHERE nome LIKE ?;");
		stmt.setString(1, entity.getNome());
		stmt.execute();
	}

	@Override
	public void update(Contato entity) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = con.prepareStatement("UPDATE contato SET idade = ?, telefone = ? WHERE nome LIKE ?;");
		stmt.setInt(1, entity.getIdade());
		stmt.setString(2, entity.getTelefone());
		stmt.setString(3, entity.getNome());
		stmt.executeUpdate();
	}

}
