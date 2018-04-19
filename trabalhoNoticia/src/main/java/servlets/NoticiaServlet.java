package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticiaMongoDB;
import modelo.Noticia;

/**
 * Servlet implementation class NoticiaServlet
 */
@WebServlet("/NoticiaServlet")
public class NoticiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	NoticiaMongoDB noticiaDB = new NoticiaMongoDB();

	public NoticiaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("noticias", noticiaDB.listar());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/noticia/listar.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titulo = request.getParameter("titulo");
		String texto = request.getParameter("texto");

		Noticia noticiaNova = new Noticia();
		noticiaNova.setTitulo(titulo);
		noticiaNova.setTexto(texto);

		// add no banco
		noticiaDB.inserir(noticiaNova);

		response.sendRedirect("noticia");
	}

}
