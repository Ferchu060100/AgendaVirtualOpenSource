package pe.libreria.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.libreria.entity.Editorial;
import pe.libreria.repository.EditorialRepository;


@Named
public class EditorialRepositoryImpl implements EditorialRepository, Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="MySqlDS")
	private EntityManager em;
	
	@Override
	@Transactional
	public boolean insertar(Editorial editorial) {
		boolean flag = false;
		try {
			em.persist(editorial);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public boolean eliminar(int id) {
		boolean flag = false;
		try {
			Editorial objEditorial = this.buscarEditorialPorID(id);
			em.remove(objEditorial);
			flag = true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}	
		return flag;
	}

	@Override
	@Transactional
	public boolean actualizar(Editorial editorial) {
		boolean flag = false;
		try {
			em.merge(editorial);
			flag = true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}	
		return flag;
	}

	@Override
	public Editorial buscarEditorialPorID(int id) {
		Editorial objEditorial = new Editorial();
		try {
			objEditorial = em.find(Editorial.class, id);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return objEditorial;
	}

	@Override
	public List<Editorial> listar() {
		List<Editorial> editoriales = new ArrayList<Editorial>();
		try {
			TypedQuery<Editorial> query = em.createQuery ("select a from Editorial a", Editorial.class);
			editoriales = query.getResultList();
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return editoriales;
	}

	@Override
	public List<Editorial> buscarEditorialPorNombre(String nombre) {
		List<Editorial> editoriales = new ArrayList<Editorial>();
		try {
			TypedQuery<Editorial> query = em.createQuery ("select a from Editorial a where a.nombre like :nombre", Editorial.class);
			query.setParameter("nombre", "%" + nombre + "%");
			editoriales = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return editoriales;
	}

}
