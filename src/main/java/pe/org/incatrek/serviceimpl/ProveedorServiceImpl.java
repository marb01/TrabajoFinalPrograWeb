package pe.org.incatrek.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.org.incatrek.model.Proveedor;
import pe.org.incatrek.repository.IProveedorRepository;
import pe.org.incatrek.service.IProveedorService;

@Service
public class ProveedorServiceImpl implements IProveedorService {

	@Autowired
	private IProveedorRepository pR;
	
	@Override
	@Transactional
	public Integer insertar(Proveedor proveedor) {
		int rpta = pR.busquedaRUCProveedor(proveedor.getRucProveedor());
		if(rpta == 0)
			pR.save(proveedor);
		return rpta;
	}

	@Override
	@Transactional
	public boolean modificar(Proveedor proveedor) {
		return true;
	}

	@Override
	@Transactional
	public void eliminar(int idProveedor) {
		pR.deleteById(idProveedor);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Proveedor> listar() {
		return pR.findAll();
	}

	
	@Transactional
	@Override
	public List<Proveedor> buscarPorNombre(String nombreProveedor) {
		return pR.buscarPorNombre(nombreProveedor);
	}
	
	@Transactional
	@Override
	public List<Proveedor> buscarPorRUC(String rucProveedor) {
		return pR.buscarPorRUC(rucProveedor);
	}

	@Override
	public Optional<Proveedor> listarId(int idProveedor) {
		return pR.findById(idProveedor);
	}
	
}
