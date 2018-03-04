package py.edu.ucsa.rest.api.core.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import py.edu.ucsa.rest.api.core.dao.AbstractDao;
import py.edu.ucsa.rest.api.core.dao.EnvioDao;
import py.edu.ucsa.rest.api.core.model.Envio;


@Repository("envioDao")
public class EnvioDaoImpl extends AbstractDao<Integer, Envio> implements EnvioDao {

	@Override
	public Envio getById(Integer id) {
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
				.createNamedQuery("Envio.findAll")
				.getResultList();
		return envio;
	}

	@Override
	public Envio getByUnique(Date fecha, String rastreo) {
		try {
			return (Envio) getEntityManager()
					.createNamedQuery("Envio.findUnique")
					.setParameter("fecha_envio", fecha)
					.setParameter("nro_rastreo", rastreo)
					.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

}
