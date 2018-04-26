package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

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

		String opcao = request.getParameter("opcao");

		if (opcao.equals("carregar")) {
			String codigo = request.getParameter("codigo");
			ObjectId id = new ObjectId(codigo);
			request.setAttribute("noticia", noticiaDB.get(id));

			RequestDispatcher dispatcher = request.getRequestDispatcher("/noticia.jsp");
			dispatcher.forward(request, response);
		}

		if (opcao.equals("listar")) {
			request.setAttribute("noticias", noticiaDB.listar());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}

		 if (opcao.equals("excluir")) {
			 String codigo = request.getParameter("codigo");
				ObjectId id = new ObjectId(codigo);
				Noticia noticia = noticiaDB.get(id);
				noticiaDB.deletar(noticia);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
		 }
		 

		 if (opcao.equals("editar")) {
			 String codigo = request.getParameter("codigo");
				ObjectId id = new ObjectId(codigo);
				Noticia noticia = noticiaDB.get(id);
				request.setAttribute("noticia", noticia);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/adicionar.jsp");
				dispatcher.forward(request, response);
		 }

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

		System.out.println(noticiaDB.listar());

		response.sendRedirect("NoticiaServlet?opcao=listar");
	}

}
