package py.edu.ucsa.rest.api.core.dao;

import java.util.List;
import py.edu.ucsa.rest.api.core.model.Oficina;

public interface OficinaDao {
	Oficina getById (Integer pk);	/*devolucion, nombre, recibimiento*/
	void insertar (Oficina oficina);	/*void, cuando no devuelve nada*/
	void actualizar (Oficina oficina);
	List<Oficina> listar();
	Oficina getByCodigo(String codigo);
}
