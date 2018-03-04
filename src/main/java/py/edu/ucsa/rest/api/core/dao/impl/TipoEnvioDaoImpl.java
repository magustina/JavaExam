package py.edu.ucsa.rest.api.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import py.edu.ucsa.rest.api.core.dao.AbstractDao;
import py.edu.ucsa.rest.api.core.dao.TipoEnvioDao;
import py.edu.ucsa.rest.api.core.model.TipoEnvio;

@Repository("tipoEnvioDao")
public class TipoEnvioDaoImpl extends AbstractDao<Integer, TipoEnvio> implements TipoEnvioDao {

	@Override
	public TipoEnvio getById(Integer pk) {
		return super.getById(pk);
	}

	@Override
	public void insertar(TipoEnvio tipoEnvio) {
		super.persistir(tipoEnvio);

	}

	@Override
	public void actualizar(TipoEnvio tipoEnvio) {
		super.actualizar(tipoEnvio);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoEnvio> listar() {
		List<TipoEnvio> lista = new ArrayList<TipoEnvio>();
		EntityManager em = getEntityManager();
		Query query = em.createNamedQuery("TiposEnvios.findAll");
		lista = query.getResultList();
		return lista;
	}

	@Override
	public TipoEnvio getByCodigo(String codigo) {
		try {
			EntityManager em = getEntityManager();
			Query query = em.createQuery("SELECT t FROM TipoEnvio t WHERE t.codigo = :cod");
			query.setParameter("cod", codigo);
			TipoEnvio tipoEnvio = (TipoEnvio) query.getSingleResult();
			return tipoEnvio;
		}catch(NoResultException e){
			return null;
		}
		
	}

}
