package dao;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;

import modelo.Comentario;

public class ComentarioMongoDB {

	MongoCollection<Comentario> comentarios = ConexaoMongo.db().getCollection("comentario", Comentario.class);

	public void inserir(Comentario comentario) {

		comentarios.insertOne(comentario);
	}

	public void editar(Comentario comentario) {
		comentarios.updateOne(eq(comentario.getId()),
				combine(set("titulo", comentario.getAutor()), set("texto", comentario.getTexto())));
	}

	public void deletar(Comentario comentario) {

		comentarios.deleteOne(eq(comentario.getId()));

	}

	public List<Comentario> listar() {
		List<Comentario> objetosComentarios = new ArrayList<>();
		for (Comentario comentario : comentarios.find()) {
			objetosComentarios.add(comentario);
		}
		return objetosComentarios;

	}
}
