package br.com.agenda.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnviarMensagemServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3359430941954914807L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title> Escreva seu nome </title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<form action=\"Agenda-Web/receberMensagem\">");
		out.println("			<input type=\"text\" name=\"nomeUsario\" placeholder=\"Digite seu nome\">");
		out.println("			<button type\"submit\"></button>");
		out.println("		</form>");
		out.println("	</body>");
		out.println("</html>");
	}

}
