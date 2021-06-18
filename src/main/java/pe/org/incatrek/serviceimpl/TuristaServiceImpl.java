package pe.org.incatrek.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.org.incatrek.model.Turista;
import pe.org.incatrek.repository.ITuristaRepository;
import pe.org.incatrek.service.ITuristaService;

@Service
public class TuristaServiceImpl implements ITuristaService {

	@Autowired
	private ITuristaRepository tR;
	
	@Override
	@Transactional
	public Integer insertar(Turista turista) {
		int rpta = tR.busquedaDNITurista(turista.getDniTurista());
		if(rpta == 0)
			tR.save(turista);
		return rpta;
	}

	@Override
	@Transactional
	public boolean modificar(Turista turista) {
		return true;
	}

	@Override
	@Transactional
	public void eliminar(int idTurista) {
		tR.deleteById(idTurista);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Turista> listar() {
		return tR.findAll();
	}

	
	@Transactional
	@Override
	public List<Turista> buscarPorNombre(String nombreTurista) {
		return tR.buscarPorNombre(nombreTurista);
	}
	
	@Transactional
	@Override
	public List<Turista> buscarPorDNI(String dniTurista) {
		return tR.buscarPorDNI(dniTurista);
	}

	@Override
	public Optional<Turista> listarId(int idTurista) {
		return tR.findById(idTurista);
	}
	
}
