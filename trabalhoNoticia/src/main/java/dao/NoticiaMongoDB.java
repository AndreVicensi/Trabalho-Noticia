package dao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;

import modelo.Noticia;

public class NoticiaMongoDB {

	MongoCollection<Noticia> noticias = ConexaoMongo.db().getCollection("noticia", Noticia.class);

	public void inserir(Noticia noticia) {

		noticias.insertOne(noticia);
	}

	public List<Noticia> listar() {
		List<Noticia> objetosNoticias = new ArrayList<>();
		for (Noticia noticia : noticias.find()) {
			objetosNoticias.add(noticia);
		}
		return objetosNoticias;

	}
}
