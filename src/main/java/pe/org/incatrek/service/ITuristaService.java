package pe.org.incatrek.service;

import java.util.List;
import java.util.Optional;

import pe.org.incatrek.model.Turista;

public interface ITuristaService {
	public Integer insertar(Turista turista);
	public boolean modificar(Turista turista);
	public void eliminar(int idTurista);
	List<Turista> buscarPorNombre(String nombreTurista);
	List<Turista> buscarPorDNI(String dniTurista);
	List<Turista> listar();
	public Optional<Turista> listarId(int idTurista);
}
