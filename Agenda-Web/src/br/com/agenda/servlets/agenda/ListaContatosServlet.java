package br.com.agenda.servlets.agenda;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.entidades.Contato;
import br.com.agenda.repositorios.impl.ContatoRepositorioJdbc;
import br.com.agenda.repositorios.interfaces.AgendaRepositorio;

@WebServlet(urlPatterns = {"/agenda/listar"})
public class ListaContatosServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7261759251496522181L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AgendaRepositorio<Contato> repositorio = new ContatoRepositorioJdbc();
		try {
			List<Contato> contatos = repositorio.selectAll();
			req.setAttribute("contatos", contatos);
		} catch (SQLException e) {
			req.setAttribute("mensagemErro", e.getMessage());
		}
		Object mensagemErro = req.getSession().getAttribute("mensagemErro");
		if(mensagemErro != null) {
			req.setAttribute("mensagemErro", mensagemErro.toString());
			req.getSession().removeAttribute("mensagemErro");
		}
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/paginas/agenda/ListaContatos.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}
