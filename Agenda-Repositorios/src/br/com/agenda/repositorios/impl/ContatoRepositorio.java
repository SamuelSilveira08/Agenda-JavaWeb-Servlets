package br.com.agenda.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import br.com.agenda.entidades.Contato;
import br.com.agenda.repositorios.interfaces.AgendaRepositorio;

public class ContatoRepositorio implements AgendaRepositorio<Contato> {

	private static List<Contato> contatos = new ArrayList<Contato>();

	@Override
	public List<Contato> selectAll() {
		return contatos;
	}

	@Override
	public void save(Contato entity) {
		contatos.add(entity);
	}

	@Override
	public void delete(Contato entity) {
		contatos.remove(entity);
	}

	@Override
	public void update(Contato entity) {
		var original = contatos.stream().filter(contato -> contato.getNome().equals(entity.getNome())).findFirst();
		if (original.isPresent()) {
			original.get().setIdade(entity.getIdade());
			original.get().setTelefone(entity.getTelefone());
		}
	}

}
