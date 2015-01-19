package es.fdi.iw.model;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */

@Entity

public class Admin implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Version
	private int version;
	
	private String tituloIndex;
	private String descripcionIndex;
	private String tituloBio;
	private String descripcionBio;
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}   
	
	public Admin(String tituloIndex, String descripcionIndex, String tituloBio, String descripcionBio){
		this.tituloIndex = tituloIndex;
		this.tituloBio = tituloBio;
		this.descripcionBio = descripcionBio;
		this.descripcionIndex = descripcionIndex;
		
	}
	
	
	public String getTituloIndex() {
		return this.tituloIndex;
	}

	public void setTituloIndex(String tituloIndex) {
		this.tituloIndex = tituloIndex;
	}   
	public String getDescripcionIndex() {
		return this.descripcionIndex;
	}

	public void setDescripcionIndex(String descripcionIndex) {
		this.descripcionIndex = descripcionIndex;
	}   
	public String getTituloBio() {
		return this.tituloBio;
	}

	public void setTituloBio(String tituloBio) {
		this.tituloBio = tituloBio;
	}   
	public String getDescripcionBio() {
		return this.descripcionBio;
	}

	public void setDescripcionBio(String descripcionBio) {
		this.descripcionBio = descripcionBio;
	}
   
}
