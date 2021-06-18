package pe.org.incatrek.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.org.incatrek.model.Reserva;
import pe.org.incatrek.repository.IReservaRepository;
import pe.org.incatrek.service.IReservaService;

@Service
public class ReservaServiceImpl implements IReservaService {

	@Autowired
	private IReservaRepository rR;

	@Override
	@Transactional
	public boolean insertar(Reserva reserva) {
		Reserva objReserva= rR.save(reserva);
		if	(objReserva !=null)
			return true;
		else
			return false;
	}

	@Override
	@Transactional
	public boolean modificar(Reserva reserva) {
		return true;
	}

	@Override
	@Transactional
	public void eliminar(int idReserva) {
		rR.deleteById(idReserva);
	}

	@Override
		public Optional<Reserva> buscarId(int idReserva) {
		return rR.findById(idReserva);
	}

	@Override
	public Optional<Reserva> listarId(int idReserva) {
		return rR.findById(idReserva);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reserva> listar(){
		return rR.findAll();
	}
	
	@Override
	@Transactional
	public List<Reserva> buscarNombreReserva(String nombreReserva) {
		return rR.buscarNombreReserva(nombreReserva);
	}
	
	@Override
	@Transactional
	public List<Reserva> buscarTurista(String nombreTurista) {
		return rR.buscarTurista(nombreTurista);
	}
	
	@Override
	@Transactional
	public List<Reserva> buscarPaquete(String nombrePaquete) {
		return rR.buscarPaquete(nombrePaquete);
	}
	
}