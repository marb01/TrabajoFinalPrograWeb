package pe.org.incatrek.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.org.incatrek.model.Paquete;
import pe.org.incatrek.repository.IPaqueteRepository;
import pe.org.incatrek.service.IPaqueteService;

@Service
public class PaqueteServiceImpl implements IPaqueteService {

	@Autowired
	private IPaqueteRepository pR;
	
	@Override
	@Transactional
	public boolean insertar(Paquete paquete) {
		Paquete objPaquete = pR.save(paquete);
		if(objPaquete == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Paquete paquete) {
		return true;
	}

	@Override
	@Transactional
	public void eliminar(int idPaquete) {
		pR.deleteById(idPaquete);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Paquete> listar() {
		return pR.findAll();
	}
	
	@Transactional
	@Override
	public List<Paquete> buscarPorNombre(String nombrePaquete) {
		return pR.buscarPorNombre(nombrePaquete);
	}
	

	@Transactional
	@Override
	public Optional<Paquete> listarId(int idPaquete) {
		return pR.findById(idPaquete);
	}
	
}
