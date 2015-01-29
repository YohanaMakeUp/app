package es.fdi.iw.model;

import javax.persistence.*;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;


@NamedQueries({
    @NamedQuery(name="dameTexto",
        query="SELECT t FROM FragIndex t")   
})


@Entity
@Table(name = "FragIndex")
public class FragIndex {

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
