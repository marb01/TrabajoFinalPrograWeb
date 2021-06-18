package pe.org.incatrek.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Turista")
public class Turista implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTurista;
	
	@Column(name="nombreTurista", nullable=false, length = 30)
	private String nombreTurista;
	
	@Column(name = "apellidoTurista", nullable = false, length = 30)
	private String apellidoTurista;
	
	@Column(name = "celularTurista", nullable = false, length = 9)
	private int celularTurista;

	@Column(name = "direccionTurista", nullable = false, length = 30)
	private String direccionTurista;

	@Column(name = "dniTurista", nullable = false, length = 8)
	private String dniTurista;

	@Column(name = "emailTurista", nullable = false, length = 30)
	private String emailTurista;
	
	public Turista() {
		super();
	}

	public Turista(int idTurista, String nombreTurista, String apellidoTurista, int celularTurista,
			String direccionTurista, String dniTurista, String emailTurista) {
		super();
		this.idTurista = idTurista;
		this.nombreTurista = nombreTurista;
		this.apellidoTurista = apellidoTurista;
		this.celularTurista = celularTurista;
		this.direccionTurista = direccionTurista;
		this.dniTurista = dniTurista;
		this.emailTurista = emailTurista;
	}

	public int getIdTurista() {
		return idTurista;
	}

	public void setIdTurista(int idTurista) {
		this.idTurista = idTurista;
	}

	public String getNombreTurista() {
		return nombreTurista;
	}

	public void setNombreTurista(String nombreTurista) {
		this.nombreTurista = nombreTurista;
	}

	public String getApellidoTurista() {
		return apellidoTurista;
	}

	public void setApellidoTurista(String apellidoTurista) {
		this.apellidoTurista = apellidoTurista;
	}

	public int getCelularTurista() {
		return celularTurista;
	}

	public void setCelularTurista(int celularTurista) {
		this.celularTurista = celularTurista;
	}

	public String getDireccionTurista() {
		return direccionTurista;
	}

	public void setDireccionTurista(String direccionTurista) {
		this.direccionTurista = direccionTurista;
	}

	public String getDniTurista() {
		return dniTurista;
	}

	public void setDniTurista(String dniTurista) {
		this.dniTurista = dniTurista;
	}

	public String getEmailTurista() {
		return emailTurista;
	}

	public void setEmailTurista(String emailTurista) {
		this.emailTurista = emailTurista;
	}

}

	