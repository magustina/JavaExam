package py.edu.ucsa.rest.api.core.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import py.edu.ucsa.rest.api.core.dao.AbstractDao;
import py.edu.ucsa.rest.api.core.dao.OficinaDao;
import py.edu.ucsa.rest.api.core.model.Oficina;


@Repository ("oficinaDao")
public class OficinaDaoImpl extends AbstractDao<Integer, Oficina> implements OficinaDao {

	@Override
	public Oficina getById(Integer pk) {
		return super.getById(pk);
	}

	@Override
	public void insertar(Oficina oficina) {
		super.persistir(oficina);

	}
	
	@Override
	public void actualizar (Oficina oficina) {
		super.actualizar(oficina);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Oficina> listar() {
		List<Oficina> lista = new ArrayList<Oficina>();
		EntityManager em = getEntityManager();
		Query query = em.createNamedQuery("Oficina.findAll");
		lista = query.getResultList();
		return lista;
	}

	@Override
	public Oficina getByCodigo(String cod) {
	try {
		EntityManager em = getEntityManager();
		Query query = em.createQuery("SELECT o FROM Oficina o WHERE o.codigo = :cod");
		query.setParameter("cod", cod);
		Oficina oficina = (Oficina) query.getSingleResult();
		return oficina;
	}catch(NoResultException e) {
		return null;
	}
	}

}
