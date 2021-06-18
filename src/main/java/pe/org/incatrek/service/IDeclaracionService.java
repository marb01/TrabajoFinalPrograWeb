package pe.org.incatrek.service;

import java.util.List;
import java.util.Optional;

import pe.org.incatrek.model.Declaracion;

public interface IDeclaracionService {
	public boolean insertar(Declaracion declaracion);
	public boolean modificar(Declaracion declaracion);
	public void eliminar(int idDeclaracion);
	List<Declaracion> listar();
	List<Declaracion> buscarPorId(int idDeclaracion);
	public Optional<Declaracion> listarId(int idDeclaracion);
	public List<Declaracion> buscarTurista(int idTurista);
}
