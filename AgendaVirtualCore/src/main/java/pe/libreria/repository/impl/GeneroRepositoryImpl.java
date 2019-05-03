package pe.libreria.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.libreria.entity.Genero;
import pe.libreria.repository.GeneroRepository;


@Named
public class GeneroRepositoryImpl implements GeneroRepository, Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="MySqlDS")
	private EntityManager em;
	
	@Override
	@Transactional
	public boolean insertar(Genero genero) {
		boolean flag = false;
		try {
			em.persist(genero);
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
			Genero objGenero = this.buscarGeneroPorID(id);
			em.remove(objGenero);
			flag = true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}	
		return flag;
	}

	@Override
	@Transactional
	public boolean actualizar(Genero genero) {
		boolean flag = false;
		try {
			em.merge(genero);
			flag = true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}	
		return flag;
	}

	@Override
	public Genero buscarGeneroPorID(int id) {
		Genero objGenero = new Genero();
		try {
			objGenero = em.find(Genero.class, id);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return objGenero;
	}

	@Override
	public List<Genero> listar() {
		List<Genero> generos = new ArrayList<Genero>();
		try {
			TypedQuery<Genero> query = em.createQuery ("select a from Genero a", Genero.class);
			generos = query.getResultList();
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return generos;
	}

	@Override
	public List<Genero> buscarGeneroPorNombre(String nombre) {
		List<Genero> generos = new ArrayList<Genero>();
		try {
			TypedQuery<Genero> query = em.createQuery ("select a from Genero a where a.nombre like :nombre", Genero.class);
			query.setParameter("nombre", "%" + nombre + "%");
			generos = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return generos;
	}

}
