package dao;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

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
	
	public Comentario get(ObjectId id) {
		Comentario comentario = new Comentario();
		Comentario first = comentarios.find(eq("id", id)).first();
		comentario.setId(first.getId());
		comentario.setAutor(first.getAutor());
		comentario.setTexto(first.getTexto());
		return comentario;
	}
}
