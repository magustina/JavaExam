package py.edu.ucsa.rest.api.core.services;

import java.util.List;
import py.edu.ucsa.rest.api.core.model.Pais;

public interface PaisService {
	Pais getById (Integer pk);	/*devolucion, nombre, recibimiento*/
	void insertar (Pais pais);	/*void, cuando no devuelve nada*/
	void eliminar (Pais pais);
	void actualizar (Pais pais);
	List<Pais> listar();
	boolean isExisteCodigo (Pais pais);
	Pais getByCodigo(String codigo);	
}
