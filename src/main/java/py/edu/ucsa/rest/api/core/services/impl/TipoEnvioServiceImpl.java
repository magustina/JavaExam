package py.edu.ucsa.rest.api.core.services.impl;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.rest.api.core.dao.TipoEnvioDao;
import py.edu.ucsa.rest.api.core.model.TipoEnvio;
import py.edu.ucsa.rest.api.core.services.TipoEnvioServices;

@Service("tipoEnvioService")
@Transactional
public class TipoEnvioServiceImpl implements TipoEnvioServices {
	private ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private TipoEnvioDao envio;
	
	
	@Override
	public TipoEnvio getById(Integer pk) {
		return envio.getById(pk);
	}

	@Override
	public void insertar(TipoEnvio tipoEnvio) {
		if(tipoEnvio.getId() == null) {
			envio.insertar(tipoEnvio);
		}else {
			envio.actualizar(tipoEnvio);
		}
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
		try {
			System.out.println("Llego al service esto:"+ mapper.writeValueAsString(tipoEnvio));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(envio == null) {
			System.out.println("Es nulo kape");
		}
		return envio.getByCodigo(tipoEnvio.getCodigo())!=null;
	}

}
