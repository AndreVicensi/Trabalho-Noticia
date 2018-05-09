package modelo;

import java.util.ArrayList;

import org.bson.types.ObjectId;

public class Noticia {

	private ObjectId id;
	private String titulo;
	private String texto;
	private ArrayList<Comentario> comentarios;

	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public void addComentario(Comentario comentario) {
		if(comentarios == null) {
			comentarios = new ArrayList<>();
		}
		this.comentarios.add(comentario);
	}

}
