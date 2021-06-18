package pe.org.incatrek.service;

import java.util.List;
import java.util.Optional;

import pe.org.incatrek.model.Proveedor;

public interface IProveedorService {
	public Integer insertar(Proveedor proveedor);
	public boolean modificar(Proveedor proveedor);
	public void eliminar(int idProveedor);
	List<Proveedor> listar();
	List<Proveedor> buscarPorNombre(String nombreProveedor);
	List<Proveedor> buscarPorRUC(String rucProveedor);
	public Optional<Proveedor> listarId(int idProveedor);
}
