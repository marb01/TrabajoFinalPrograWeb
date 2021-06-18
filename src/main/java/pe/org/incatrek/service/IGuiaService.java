package pe.org.incatrek.service;

import java.util.List;
import java.util.Optional;

import pe.org.incatrek.model.Guia;

public interface IGuiaService {
	public Integer insertar(Guia guia);
	public boolean modificar(Guia guia);
	public void eliminar(int idGuia);
	List<Guia> buscarPorNombre(String nombreGuia);
	List<Guia> buscarPorDNI(String dniGuia);
	List<Guia> listar();
	public Optional<Guia> listarId(int idGuia);
}
