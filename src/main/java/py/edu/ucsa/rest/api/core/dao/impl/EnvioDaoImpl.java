package py.edu.ucsa.rest.api.core.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import py.edu.ucsa.rest.api.core.dao.AbstractDao;
import py.edu.ucsa.rest.api.core.dao.EnvioDao;
import py.edu.ucsa.rest.api.core.model.Envio;
import py.edu.ucsa.rest.api.core.model.Oficina;
import py.edu.ucsa.rest.api.core.model.Pais;
import py.edu.ucsa.rest.api.core.model.TipoEnvio;


public class EnvioDaoImpl extends AbstractDao<Integer, Envio> implements EnvioDao {

	@Override
	public Envio getById(Integer id) {
		// TODO Auto-generated method stub
		return super.getById(id);
	}

	@Override
	public Envio getByPais(Pais idPais) {		
		try {
			return (Envio) getEntityManager()
					.createNamedQuery("SELECT p FROM Envio p WHERE p.pais = :idPais ")
					.setParameter("idPais", idPais)
					.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

	@Override
	public Envio getByOficina(Oficina idOficina) {
		try {
			return (Envio) getEntityManager()
					.createNamedQuery("SELECT o FROM Envio o WHERE o.oficina = :idOficina ")
					.setParameter("idOficina", idOficina)
					.getSingleResult();
		}catch(NoResultException e) {
			return null;
	}
	}

	@Override
	public Envio getByTipoEnvio(TipoEnvio idTipoEnvio) {
		try {
			return (Envio) getEntityManager()
					.createNamedQuery("SELECT te FROM Envio te WHERE te.tipoEnvio = :idTipoEnvio ")
					.setParameter("idTipoEnvio", idTipoEnvio)
					.getSingleResult();
		}catch(NoResultException e) {
			return null;
	}
	}

	@Override
	public void insertar(Envio envio) {
		super.persistir(envio);

	}

	@Override
	public void actualizar(Envio envio) {
		super.actualizar(envio);

	}

	@Override
	public void eliminar(Envio envio) {
		super.eliminar(envio);

	}

	@Override
	public List<Envio> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Envio getByUnique(Pais id_origen, Pais id_destino, Oficina id_oficina_destino, TipoEnvio tipo_envio) {
		// TODO Auto-generated method stub
		return null;
	}

}
