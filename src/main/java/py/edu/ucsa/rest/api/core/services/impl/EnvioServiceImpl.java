package py.edu.ucsa.rest.api.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.rest.api.core.dao.EnvioDao;
import py.edu.ucsa.rest.api.core.model.Envio;
import py.edu.ucsa.rest.api.core.services.EnvioService;

@Service("envioService")
@Transactional
public class EnvioServiceImpl implements EnvioService {

	@Autowired
	private EnvioDao dao;
	
	@Override
	public Envio getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<Envio> listarTodos() {
		return dao.listar();
	}

	@Override
	public void guardarEnvio(Envio envio) {
		if(envio.getId() == null) {
			dao.insertar(envio);
		}else {
			dao.actualizar(envio);
		}

	}

	@Override
	public boolean isExisteEnvio(Envio envio) {
		return dao.getByUnique(envio.getFecha_envio(), envio.getNro_rastreo()) != null;
	}

}
