package py.edu.ucsa.rest.api.core.dao;

import java.util.List;
import py.edu.ucsa.rest.api.core.model.TipoEnvio;

public interface TipoEnvioDao {
	TipoEnvio getById (Integer pk);	/*devolucion, nombre, recibimiento*/
	void insertar (TipoEnvio tipoEnvioDao);	/*void, cuando no devuelve nada*/
	void eliminar (TipoEnvio tipoEnvioDao);
	void actualizar (TipoEnvio tipoEnvioDao);
	List<TipoEnvio> listar();
	TipoEnvio getByCodigo(String codigo);
}
