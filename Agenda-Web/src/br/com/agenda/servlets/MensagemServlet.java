package br.com.agenda.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MensagemServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 623992705662983981L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title> Escreva seu nome </title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<form action=\"/Agenda-Web/receberMensagem\">");
		out.println("			<input type=\"text\" name=\"nomeUsuario\" placeholder=\"Digite seu nome\">");
		out.println("			<br><br>");
		out.println("			<button type\"submit\">Enviar</button>");
		out.println("		</form>");
		out.println("	</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomeUsuario = req.getParameter("nomeUsuario");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Olá! </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<script> alert('Olá, " + nomeUsuario + "!'); </script>");
		out.println("</body>");
		out.println("</html>");
	}
	
	

}
