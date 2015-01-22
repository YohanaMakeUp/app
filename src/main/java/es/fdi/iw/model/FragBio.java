package es.fdi.iw.model;

import javax.persistence.*;

@Entity
public class FragBio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String titulo;
	private String texto;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	@Column(length = 2048)
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
