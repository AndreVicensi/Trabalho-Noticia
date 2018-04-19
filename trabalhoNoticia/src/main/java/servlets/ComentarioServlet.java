package servlets;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.client.MongoCollection;

import dao.ConexaoMongo;
import modelo.Comentario;

/**
 * Servlet implementation class ComentarioServlet
 */
@WebServlet("/ComentarioServlet")
public class ComentarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ComentarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MongoCollection<Comentario> comentarios = ConexaoMongo.db().getCollection("comentario", Comentario.class);
		// passa o find do mongo para uma lista
		List<Comentario> objetosComentarios = new ArrayList<>();
		for (Comentario comentario : comentarios.find()) {
			objetosComentarios.add(comentario);
		}
		request.setAttribute("comentarios", objetosComentarios);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/noticia/listar.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MongoCollection<Comentario> comentarios = ConexaoMongo.db().getCollection("comentario", Comentario.class);

		String autor = request.getParameter("titulo");
		String texto = request.getParameter("texto");

		Comentario comentarioNovo = new Comentario();
		comentarioNovo.setAutor(autor);
		comentarioNovo.setTexto(texto);

		
		// add no banco
		comentarios.insertOne(comentarioNovo);

		// fazer update
		comentarios.updateOne(eq("name", "Ada Byron"), combine(set("age", 23), set("name", "Ada Lovelace")));

		response.sendRedirect("noticia");
	}

}
