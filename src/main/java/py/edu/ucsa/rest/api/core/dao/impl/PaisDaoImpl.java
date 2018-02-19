package py.edu.ucsa.rest.api.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import py.edu.ucsa.rest.api.core.dao.AbstractDao;
import py.edu.ucsa.rest.api.core.dao.PaisDao;
import py.edu.ucsa.rest.api.core.model.Pais;

@Repository("paisDao") /*el spring sabe con esto que es una clase que se conectara a la base*/
public class PaisDaoImpl extends AbstractDao<Integer, Pais> implements PaisDao {

	@Override
	public Pais getById(Integer pk) {
		return super.getById(pk);
	}

	@Override
	public void insertar(Pais paisDao) {
		super.persistir(paisDao);

	}

	@Override
	public void eliminar(Pais paisDao) {
		super.eliminar(paisDao);

	}

	@Override
	public void actualizar(Pais paisDao) {
		super.actualizar(paisDao);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> listar() {
		List<Pais> lista = new ArrayList<Pais>();
		EntityManager em = getEntityManager();
		Query query = em.createQuery("SELECT l FROM Pais l");
		lista = query.getResultList();
		return lista;
	}

	@Override
	public Pais getByCodigo(String cod) {
		EntityManager em = getEntityManager();
		Query query = em.createQuery("SELECT p FROM Pais p WHERE p.codigo = :cod");
		query.setParameter("cod", cod);
		Pais pais = (Pais) query.getSingleResult();
		return pais;
	}
}
