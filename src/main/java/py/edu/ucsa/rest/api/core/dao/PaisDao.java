package py.edu.ucsa.rest.api.core.dao;

import java.util.List;
import py.edu.ucsa.rest.api.core.model.Pais;

public interface PaisDao {
	Pais getById (Integer pk);	/*devolucion, nombre, recibimiento*/
	void insertar (Pais paisDao);	/*void, cuando no devuelve nada*/
	void eliminar (Pais paisDao);
	void actualizar (Pais paisDao);
	List<Pais> listar();
	Pais getByCodigo(String codigo);
}
