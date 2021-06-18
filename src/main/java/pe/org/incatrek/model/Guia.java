package pe.org.incatrek.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Guia")
public class Guia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGuia;
	
	@Column(name = "nombreGuia", nullable = false, length = 30)
	private String nombreGuia;
	
	@Column(name = "apellidoGuia", nullable = false, length = 40)
	private String apellidoGuia;

	@Column(name = "dniGuia", nullable = false, length = 8)
	private String dniGuia;
	
	@Column(name = "celularGuia", nullable = false, length = 9)
	private int celularGuia;
	
	@Column(name = "emailGuia", nullable = false, length = 30)
	private String emailGuia;

	public Guia() {
		super();
	}

	public Guia(int idGuia, String nombreGuia, String apellidoGuia, String dniGuia, int celularGuia, String emailGuia) {
		super();
		this.idGuia = idGuia;
		this.nombreGuia = nombreGuia;
		this.apellidoGuia = apellidoGuia;
		this.dniGuia = dniGuia;
		this.celularGuia = celularGuia;
		this.emailGuia = emailGuia;
	}

	public int getIdGuia() {
		return idGuia;
	}

	public void setIdGuia(int idGuia) {
		this.idGuia = idGuia;
	}

	public String getNombreGuia() {
		return nombreGuia;
	}

	public void setNombreGuia(String nombreGuia) {
		this.nombreGuia = nombreGuia;
	}

	public String getApellidoGuia() {
		return apellidoGuia;
	}

	public void setApellidoGuia(String apellidoGuia) {
		this.apellidoGuia = apellidoGuia;
	}

	public String getDniGuia() {
		return dniGuia;
	}

	public void setDniGuia(String dniGuia) {
		this.dniGuia = dniGuia;
	}

	public int getCelularGuia() {
		return celularGuia;
	}

	public void setCelularGuia(int celularGuia) {
		this.celularGuia = celularGuia;
	}

	public String getEmailGuia() {
		return emailGuia;
	}

	public void setEmailGuia(String emailGuia) {
		this.emailGuia = emailGuia;
	}

}

	