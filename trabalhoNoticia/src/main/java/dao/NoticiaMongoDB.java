package dao;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;

import modelo.Comentario;
import modelo.Noticia;

public class NoticiaMongoDB {

	MongoCollection<Noticia> noticias = ConexaoMongo.db().getCollection("noticia", Noticia.class);

	public void inserir(Noticia noticia) {

		// ArrayList<Comentario> comentarios = new ArrayList<>();
		// noticia.setComentarios(comentarios);
		noticias.insertOne(noticia);

	}

	public void inserirComentario(Noticia noticia, Comentario comentario) {
		noticia.addComentario(comentario);
		noticias.updateOne(eq(noticia.getId()), combine(set("comentarios", noticia.getComentarios())));
	}

	public void deletar(Noticia noticia, Comentario comentario) {

		// noticia.getComentario().remove(comentario);

		noticias.deleteOne(eq(comentario.getId()));

	}

	public void editar(Noticia noticia) {
		noticias.updateOne(eq(noticia.getId()),
				combine(set("titulo", noticia.getTitulo()), set("texto", noticia.getTexto())));
	}

	public void deletar(Noticia noticia) {

		noticias.deleteOne(eq(noticia.getId()));

	}

	public List<Noticia> listar() {
		List<Noticia> objetosNoticias = new ArrayList<>();
		for (Noticia noticia : noticias.find()) {
			objetosNoticias.add(noticia);
		}
		return objetosNoticias;
	}

	// public List<Comentario> listarComentarios(Noticia noticia) {
	// return noticia.getComentarios();
	// }

	public Noticia get(ObjectId id) {
		Noticia noticia = new Noticia();
		Noticia resultado = noticias.find(eq("_id", id)).first();
		noticia.setId(resultado.getId());
		noticia.setTexto(resultado.getTexto());
		noticia.setTitulo(resultado.getTitulo());
		noticia.setComentarios(resultado.getComentarios());
		return noticia;
	}
}
