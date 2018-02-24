package py.edu.ucsa.rest.api.core.dao;

import java.util.List;

import py.edu.ucsa.rest.api.core.model.Envio;
import py.edu.ucsa.rest.api.core.model.Oficina;
import py.edu.ucsa.rest.api.core.model.Pais;
import py.edu.ucsa.rest.api.core.model.TipoEnvio;

public interface EnvioDao {
	Envio getById(Integer id);
	Envio getByPais(Pais idPais);
	Envio getByOficina(Oficina oficina);
	Envio getByTipoEnvio(TipoEnvio tipoEnvio);
	void insertar(Envio envio);
	void actualizar(Envio envio);
	void eliminar(Envio envio);
	List<Envio> listar();
	Envio getByUnique(Pais id_origen, Pais id_destino, Oficina id_oficina_destino, TipoEnvio tipo_envio);
}
