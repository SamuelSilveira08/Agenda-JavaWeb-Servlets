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

@WebServlet(urlPatterns = { "/agenda/editar" })
public class EditarContatoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -401932375412860919L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AgendaRepositorio<Contato> repositorio = new ContatoRepositorioJdbc();
		try {
			List<Contato> contatos = repositorio.selectAll();
			var contato = contatos.stream().filter(c1 -> c1.getTelefone().equals(req.getParameter("telefone")))
					.findFirst();
			if (contato.isPresent()) {
				req.setAttribute("contato", contato.get());
			} else {
				req.getSession().setAttribute("mensagemErro", "Este contato não existe");
				resp.sendRedirect(req.getServletContext().getContextPath() + "/agenda/listar");
			}
		} catch (SQLException e) {
			req.getSession().setAttribute("mensagemErro", e.getMessage());
		}
		RequestDispatcher dispatcher = req.getServletContext()
				.getRequestDispatcher("/WEB-INF/paginas/agenda/EditarContato.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AgendaRepositorio<Contato> repositorio = new ContatoRepositorioJdbc();
		Contato contato = new Contato();
		contato.setNome(req.getParameter("nomeContato"));
		contato.setIdade(Integer.parseInt(req.getParameter("idadeContato")));
		contato.setTelefone(req.getParameter("telefoneContato"));
		try {
			repositorio.save(contato);
		} catch (SQLException e) {
			req.getSession().setAttribute("mensagemErro", e.getMessage());
		}
		resp.sendRedirect(req.getServletContext().getContextPath() + "/agenda/listar");
	}

}
