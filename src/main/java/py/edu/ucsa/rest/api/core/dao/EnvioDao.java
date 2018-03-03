package py.edu.ucsa.rest.api.core.dao;

import java.util.Date;
import java.util.List;

import py.edu.ucsa.rest.api.core.model.Envio;

public interface EnvioDao {
	Envio getById(Integer id);
	void insertar(Envio envio);
	void actualizar(Envio envio);
	void eliminar(Envio envio);
	List<Envio> listar();
	Envio getByUnique(Date fecha, String rastreo);
}
