package py.edu.ucsa.rest.api.core.services;

import java.util.List;

import py.edu.ucsa.rest.api.core.model.TipoEnvio;

public interface TipoEnvioServices {
	TipoEnvio getById (Integer pk);	/*devolucion, nombre, recibimiento*/
	void insertar (TipoEnvio tipoEnvio);	/*void, cuando no devuelve nada*/
	void eliminar (TipoEnvio tipoEnvio);
	void actualizar (TipoEnvio tipoEnvio);
	List<TipoEnvio> listar();
	TipoEnvio getByCodigo(String codigo);
	boolean isExisteCodigo (TipoEnvio tipoEnvio);
}
