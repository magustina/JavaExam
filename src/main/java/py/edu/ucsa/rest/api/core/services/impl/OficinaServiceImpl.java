package py.edu.ucsa.rest.api.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.rest.api.core.dao.OficinaDao;
import py.edu.ucsa.rest.api.core.model.Oficina;
import py.edu.ucsa.rest.api.core.services.OficinaService;

@Service("oficinaService")
@Transactional
public class OficinaServiceImpl implements OficinaService {
	
	@Autowired
	private OficinaDao oficinaDao;
	@Override
	public Oficina getById(Integer pk) {
		return oficinaDao.getById(pk);
	}

	@Override
	public void insertar(Oficina oficina) {
		oficinaDao.insertar(oficina);

	}

	@Override
	public void eliminar(Oficina oficina) {
		oficinaDao.eliminar(oficina);

	}

	@Override
	public void actualizar(Oficina oficina) {
		oficinaDao.actualizar(oficina);

	}

	@Override
	public List<Oficina> listar() {
		return oficinaDao.listar();
	}

	@Override
	public boolean isExisteOficina(Oficina oficina) {
		return oficinaDao.getByCodigo(oficina.getCodigo())!=null;
	}

	@Override
	public Oficina getByCodigo(String codigo) {
		return oficinaDao.getByCodigo(codigo);
	}

}
