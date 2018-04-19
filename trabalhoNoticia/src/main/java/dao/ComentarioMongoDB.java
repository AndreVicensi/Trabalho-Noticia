package dao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;

import modelo.Comentario;

public class ComentarioMongoDB {

	MongoCollection<Comentario> comentarios = ConexaoMongo.db().getCollection("comentario", Comentario.class);

	public void inserir(Comentario comentario) {

		comentarios.insertOne(comentario);
	}

	public List<Comentario> listar() {
		List<Comentario> objetosComentarios = new ArrayList<>();
		for (Comentario comentario : comentarios.find()) {
			objetosComentarios.add(comentario);
		}
		return objetosComentarios;

	}
}
