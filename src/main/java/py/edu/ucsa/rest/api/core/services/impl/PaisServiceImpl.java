package py.edu.ucsa.rest.api.core.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.edu.ucsa.rest.api.core.dao.PaisDao;
import py.edu.ucsa.rest.api.core.model.Pais;
import py.edu.ucsa.rest.api.core.services.PaisService;

@Service("paisService")
@Transactional
public class PaisServiceImpl implements PaisService {
	
	@Autowired
	private PaisDao paisDao;
	@Override
	public Pais getById(Integer pk) {
		return paisDao.getById(pk);
	}

	@Override
	public void insertar(Pais pais) {
		paisDao.insertar(pais);
	}

	@Override
	public void eliminar(Pais pais) {
		paisDao.eliminar(pais);
	}

	@Override
	public void actualizar(Pais pais) {
		paisDao.actualizar(pais);
	}

	@Override
	public List<Pais> listar() {
		return paisDao.listar();
	}

	@Override
	public boolean isExisteCodigo(Pais pais) {
		return paisDao.getByCodigo(pais.getCodigo())!=null;
	}

	@Override
	public Pais getByCodigo(String codigo) {
		return paisDao.getByCodigo(codigo);
	}

}
