package es.fdi.iw.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	
	@Version
	private int version;
	
	private String role;
	
	private String alias;
	
	private String password;
		
	private String email;
	
	private String nombre;
	

	
	@OneToMany(mappedBy = "user",fetch=FetchType.LAZY)
	private List<Fecha> fechas;
	
	public User() {}
	
	public User(String role, String alias, String password, String nombre, String email) {
		this.role = role;
		this.alias = alias;
		this.password = password;
		this.email = email;
		this.nombre = nombre;
		
	}
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Fecha> getFechas() {
		return fechas;
	}

	public void setFechas(List<Fecha> fechas) {
		this.fechas = fechas;
	}

	public String getRole() {
		return role;
	}
	
	public String getNombreUsuario() {
		return alias;
	}

	public String getPassword() {
		return password;
	}

	public String toString() {
		return id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.alias = nombreUsuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
