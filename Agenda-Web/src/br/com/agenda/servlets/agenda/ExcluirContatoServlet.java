package br.com.agenda.servlets.agenda;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.entidades.Contato;
import br.com.agenda.repositorios.impl.ContatoRepositorioJdbc;
import br.com.agenda.repositorios.interfaces.AgendaRepositorio;

@WebServlet(urlPatterns = {"/agenda/excluir"})
public class ExcluirContatoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -947348166326747670L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AgendaRepositorio<Contato> repositorio = new ContatoRepositorioJdbc();
		int id = Integer.parseInt(req.getParameter("id"));
		Contato contato = new Contato();
		contato.setId(id);
		try {
			repositorio.delete(contato);
		} catch (SQLException e) {
			req.getSession().setAttribute("mensagemErro", e.getMessage());
		}
		resp.sendRedirect(req.getServletContext().getContextPath() + "/agenda/listar");
	}
	
}
