package dao;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;

import modelo.Noticia;

public class NoticiaMongoDB {

	MongoCollection<Noticia> noticias = ConexaoMongo.db().getCollection("noticia", Noticia.class);

	public void inserir(Noticia noticia) {

		noticias.insertOne(noticia);

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
}
