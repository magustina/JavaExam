package py.edu.ucsa.rest.api.core.dao;

import java.util.List;
import py.edu.ucsa.rest.api.core.model.TipoEnvio;

public interface TipoEnvioDao {
	TipoEnvio getById (Integer pk);	/*devolucion, nombre, recibimiento*/
	void insertar (TipoEnvio tipoEnvio);	/*void, cuando no devuelve nada*/
	void actualizar (TipoEnvio tipoEnvio);
	List<TipoEnvio> listar();
	TipoEnvio getByCodigo(String codigo);
}
