package py.edu.ucsa.rest.api.core.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.rest.api.core.dao.TipoEnvioDao;
import py.edu.ucsa.rest.api.core.model.TipoEnvio;
import py.edu.ucsa.rest.api.core.services.TipoEnvioServices;

@Service("envioService")
@Transactional
public class TipoEnvioServiceImpl implements TipoEnvioServices {
	
	private TipoEnvioDao envio;
	@Override
	public TipoEnvio getById(Integer pk) {
		return envio.getById(pk);
	}

	@Override
	public void insertar(TipoEnvio tipoEnvio) {
		envio.insertar(tipoEnvio);
	}

	@Override
	public void eliminar(TipoEnvio tipoEnvio) {
		envio.eliminar(tipoEnvio);
	}

	@Override
	public void actualizar(TipoEnvio tipoEnvio) {
		envio.actualizar(tipoEnvio);
	}

	@Override
	public List<TipoEnvio> listar() {
		return envio.listar();
	}

	@Override
	public TipoEnvio getByCodigo(String codigo) {
		
		return envio.getByCodigo(codigo);
	}

	@Override
	public boolean isExisteCodigo(TipoEnvio tipoEnvio) {
		return envio.getByCodigo(tipoEnvio.getCodigo())!=null;
	}

}
