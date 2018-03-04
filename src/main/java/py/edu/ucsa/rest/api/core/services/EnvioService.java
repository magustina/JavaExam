package py.edu.ucsa.rest.api.core.services;

import java.util.List;

import py.edu.ucsa.rest.api.core.model.Envio;

public interface EnvioService {
	Envio getById(Integer id);
	List<Envio> listarTodos();
	void guardarEnvio(Envio envio);
	boolean isExisteEnvio(Envio envio);
}
