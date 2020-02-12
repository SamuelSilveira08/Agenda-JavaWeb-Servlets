package br.com.agenda.repositorios.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface AgendaRepositorio<T>{
	
	List<T> selectAll() throws SQLException;
	void save(T entity) throws SQLException;
	void delete(T entity) throws SQLException;
	void update(T entity) throws SQLException;
	
}
