package es.fdi.iw.model;

import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Fecha
 *
 */

@NamedQueries({
	@NamedQuery(name="fechasQueSolapan",
			query="SELECT f FROM Fecha f WHERE "
					+ "("
					+ "f.fechaIni >= :fechaInicialCita and "
					+ "f.fechaFin <= :fechaInicialCita"
					+ ") or ("
					+ "f.fechaIni >= :fechaFinalCita and "
					+ "f.fechaFin <= :fechaFinalCita"
					+ ") or ("
					+ "f.fechaIni >= :fechaInicialCita and "
					+ "f.fechaIni <= :fechaFinalCita"
					+ ")"),
					
					@NamedQuery(name="dameFechas",
					query="SELECT f FROM Fecha f")
})

@Entity
public class Fecha {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Version
	private int version;

	private Date fechaIni, fechaFin;

	@ManyToOne (fetch=FetchType.EAGER)
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Fecha(Date fechaIni, Date fechaFin, User user) {

		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.user = user;

	}

	public Fecha() {}


}
