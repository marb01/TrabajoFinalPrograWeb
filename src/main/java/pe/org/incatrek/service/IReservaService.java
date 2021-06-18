package pe.org.incatrek.service;

import java.util.List;
import java.util.Optional;

import pe.org.incatrek.model.Reserva;

public interface IReservaService {
	public boolean insertar(Reserva reserva);
	public boolean modificar(Reserva reserva);
	public void eliminar(int idReserva);
	public Optional<Reserva> buscarId(int idReserva);
	public Optional<Reserva> listarId(int idReserva);
	public List<Reserva> listar();
	public List<Reserva> buscarNombreReserva(String nombreReserva);
	public List<Reserva> buscarTurista(String nombreTurista);
	public List<Reserva> buscarPaquete(String nombrePaquete);
}
