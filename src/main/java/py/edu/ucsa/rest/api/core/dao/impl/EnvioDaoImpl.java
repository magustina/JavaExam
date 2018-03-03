package py.edu.ucsa.rest.api.core.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import py.edu.ucsa.rest.api.core.dao.AbstractDao;
import py.edu.ucsa.rest.api.core.dao.EnvioDao;
import py.edu.ucsa.rest.api.core.model.Envio;



public class EnvioDaoImpl extends AbstractDao<Integer, Envio> implements EnvioDao {

	@Override
	public Envio getById(Integer id) {
		// TODO Auto-generated method stub
		return super.getById(id);
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
		@SuppressWarnings("unchecked")
		List<Envio> envio = getEntityManager()
				.createNamedQuery("TiposEnvios.findAll")
				.getResultList();
		return envio;
	}

	@Override
	public Envio getByUnique(Date fecha, String rastreo) {
		try {
			return (Envio) getEntityManager()
					.createQuery("SELECT t FROM Envio t WHERE t.fecha_envio = :fecha and t.nro_rastreo = :rastreo")
					.setParameter("fecha", fecha)
					.setParameter("rastreo", rastreo)
					.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

}
