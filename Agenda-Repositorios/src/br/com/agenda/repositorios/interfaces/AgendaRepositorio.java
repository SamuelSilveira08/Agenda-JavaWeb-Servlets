package br.com.agenda.repositorios.interfaces;

import java.util.List;

public interface AgendaRepositorio<T>{
	
	List<T> selectAll();
	void save(T entity);
	void delete(T entity);
	void update(T entity);
	
}
