package pe.org.incatrek.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Declaracion")
public class Declaracion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDeclaracion;
	
	@Column(name = "juramento")
	private String juramento;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date fechaDeclaracion;
	
	@OneToOne
	@JoinColumn(name="idTurista", nullable=false)
	private Turista turista;

	public Declaracion() {
		super();
	}

	public Declaracion(int idDeclaracion, String juramento, Date fechaDeclaracion, Turista turista) {
		super();
		this.idDeclaracion = idDeclaracion;
		this.juramento = juramento;
		this.fechaDeclaracion = fechaDeclaracion;
		this.turista = turista;
	}

	public int getIdDeclaracion() {
		return idDeclaracion;
	}

	public void setIdDeclaracion(int idDeclaracion) {
		this.idDeclaracion = idDeclaracion;
	}

	public String getJuramento() {
		return juramento;
	}

	public void setJuramento(String juramento) {
		this.juramento = juramento;
	}

	public Date getFechaDeclaracion() {
		return fechaDeclaracion;
	}

	public void setFechaDeclaracion(Date fechaDeclaracion) {
		this.fechaDeclaracion = fechaDeclaracion;
	}

	public Turista getTurista() {
		return turista;
	}

	public void setTurista(Turista turista) {
		this.turista = turista;
	}

	
}

	