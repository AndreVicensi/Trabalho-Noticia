package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComentarioMongoDB;
import modelo.Comentario;

/**
 * Servlet implementation class ComentarioServlet
 */
@WebServlet("/ComentarioServlet")
public class ComentarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ComentarioMongoDB comentarioDB = new ComentarioMongoDB();

	public ComentarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("comentarios", comentarioDB.listar());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/noticia/listar.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String autor = request.getParameter("titulo");
		String texto = request.getParameter("texto");

		Comentario comentarioNovo = new Comentario();
		comentarioNovo.setAutor(autor);
		comentarioNovo.setTexto(texto);

		// add no banco
		comentarioDB.inserir(comentarioNovo);

		response.sendRedirect("noticia");
	}

}
