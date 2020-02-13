package br.com.agenda.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8910149643828151646L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Hello World from Servlet </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p style='font-weight: bold;'> Hello World, I came from Servlet </p>");
		out.println("</body>");
		out.println("</html>");
	}
	
}
