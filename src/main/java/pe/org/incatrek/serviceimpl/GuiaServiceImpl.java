package pe.org.incatrek.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.org.incatrek.model.Guia;
import pe.org.incatrek.repository.IGuiaRepository;
import pe.org.incatrek.service.IGuiaService;

@Service
public class GuiaServiceImpl implements IGuiaService {

	@Autowired
	private IGuiaRepository gR;
	
	@Override
	@Transactional
	public Integer insertar(Guia guia) {
		int rpta = gR.busquedaDNIGuia(guia.getDniGuia());
		if(rpta == 0)
			gR.save(guia);
		return rpta;
	}


	@Override
	@Transactional
	public boolean modificar(Guia guia) {
		return true;
	}

	@Override
	@Transactional
	public void eliminar(int idGuia) {
		gR.deleteById(idGuia);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Guia> listar() {
		return gR.findAll();
	}

	
	@Transactional
	@Override
	public List<Guia> buscarPorNombre(String nombreGuia) {
		return gR.buscarPorNombre(nombreGuia);
	}
	
	@Transactional
	@Override
	public List<Guia> buscarPorDNI(String dniGuia) {
		return gR.buscarPorDNI(dniGuia);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Guia> listarId(int idGuia) {
		return gR.findById(idGuia);
	}
	
	
}
