package py.edu.ucsa.rest.api.core.services;

import java.util.List;
import py.edu.ucsa.rest.api.core.model.Oficina;

public interface OficinaService {
	Oficina getById (Integer pk);
	void insertar (Oficina oficina);
	List<Oficina> listar ();
	boolean isExisteOficina (Oficina oficina);
	Oficina getByCodigo (String codigo);
}
