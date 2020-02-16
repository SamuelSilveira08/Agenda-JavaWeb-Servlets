package br.com.agenda.servlets.agenda;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.entidades.Contato;
import br.com.agenda.repositorios.impl.ContatoRepositorioJdbc;
import br.com.agenda.repositorios.interfaces.AgendaRepositorio;

@WebServlet(urlPatterns = {"/agenda/incluir"})
public class InserirContatoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7441861031095315805L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/paginas/agenda/InserirContato.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Contato contato = new Contato();
		contato.setNome(req.getParameter("nomeContato"));
		contato.setIdade(Integer.parseInt(req.getParameter("idadeContato")));
		contato.setTelefone(req.getParameter("telefoneContato"));
		AgendaRepositorio<Contato> repositorio = new ContatoRepositorioJdbc();
		try {
			repositorio.save(contato);
		} catch (SQLException e) {
			req.getSession().setAttribute("mensagemErro", e.getMessage());
		}
		resp.sendRedirect(req.getServletContext().getContextPath() + "/agenda/listar");
	}
	

}
