package pe.org.incatrek.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.org.incatrek.model.Declaracion;

import pe.org.incatrek.repository.IDeclaracionRepository;
import pe.org.incatrek.service.IDeclaracionService;

@Service
public class DeclaracionServiceImpl implements IDeclaracionService {

	@Autowired
	private IDeclaracionRepository dR;
	
	@Override
	@Transactional
	public boolean insertar(Declaracion declaracion) {
		Declaracion objDeclaracion= dR.save(declaracion);
		if	(objDeclaracion !=null)
			return true;
		else
			return false;
	}
	

	@Override
	@Transactional
	public boolean modificar(Declaracion declaracion) {
		return true;
	}

	@Override
	@Transactional
	public void eliminar(int idDeclaracion) {
		dR.deleteById(idDeclaracion);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Declaracion> listar() {
		return dR.findAll();
	}

	
	@Transactional
	@Override
	public List<Declaracion> buscarPorId(int idDeclaracion) {
		return dR.buscarPorId(idDeclaracion);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Declaracion> listarId(int idDeclaracion) {
		return dR.findById(idDeclaracion);
	}

	
	@Override
	@Transactional
	public List<Declaracion> buscarTurista(int idTurista) {
		return dR.buscarTurista(idTurista);
	}

	
}
