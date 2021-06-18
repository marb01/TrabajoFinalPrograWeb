package pe.org.incatrek.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Reserva")
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserva;
	
	@Column(name = "nombreReserva", nullable = false, length = 30)
	private String nombreReserva;
	
	@Column(name = "numParticipantes", length = 2)
	private int numParticipantes;

	@Temporal(TemporalType.DATE)
	@Column(name="fechaReserva", length = 50, nullable=false)
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date fechaReserva;
	
	@ManyToOne
	@JoinColumn(name="idTurista", nullable=false)
	private Turista turista;

	@ManyToOne
	@JoinColumn(name="idPaquete", nullable=false)
	private Paquete paquete;
	
	@ManyToOne
	@JoinColumn(name="idGuia", nullable=false)
	private Guia guia;
	
	public Reserva() {
		super();
	}

	public Reserva(int idReserva, String nombreReserva, int numParticipantes, Date fechaReserva, Turista turista,
			Paquete paquete, Guia guia) {
		super();
		this.idReserva = idReserva;
		this.nombreReserva = nombreReserva;
		this.numParticipantes = numParticipantes;
		this.fechaReserva = fechaReserva;
		this.turista = turista;
		this.paquete = paquete;
		this.guia = guia;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getNombreReserva() {
		return nombreReserva;
	}

	public void setNombreReserva(String nombreReserva) {
		this.nombreReserva = nombreReserva;
	}

	public int getNumParticipantes() {
		return numParticipantes;
	}

	public void setNumParticipantes(int numParticipantes) {
		this.numParticipantes = numParticipantes;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Turista getTurista() {
		return turista;
	}

	public void setTurista(Turista turista) {
		this.turista = turista;
	}

	public Paquete getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public Guia getGuia() {
		return guia;
	}

	public void setGuia(Guia guia) {
		this.guia = guia;
	}
}
