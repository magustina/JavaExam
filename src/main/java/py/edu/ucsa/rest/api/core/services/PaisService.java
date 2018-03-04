package py.edu.ucsa.rest.api.core.services;

import java.util.List;
import py.edu.ucsa.rest.api.core.model.Pais;

public interface PaisService {
	Pais getById (Integer pk);	/*devolucion, nombre, recibimiento*/
	void insertar (Pais pais);	/*void, cuando no devuelve nada*/
	List<Pais> listar();
	boolean isExisteCodigo (Pais pais);
	Pais getByCodigo(String codigo);	
}
