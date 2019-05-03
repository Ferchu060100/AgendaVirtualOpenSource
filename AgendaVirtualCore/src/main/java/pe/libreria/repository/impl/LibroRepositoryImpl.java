package pe.libreria.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.libreria.entity.Libro;
import pe.libreria.repository.LibroRepository;


@Named
public class LibroRepositoryImpl implements LibroRepository, Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="MySqlDS")
	private EntityManager em;
	
	@Override
	@Transactional
	public boolean insertar(Libro libro) {
		boolean flag = false;
		try {
			em.persist(libro);
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
			Libro objLibro = this.buscarLibroPorID(id);
			em.remove(objLibro);
			flag = true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}	
		return flag;
	}

	@Override
	@Transactional
	public boolean actualizar(Libro libro) {
		boolean flag = false;
		try {
			em.merge(libro);
			flag = true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}	
		return flag;
	}

	@Override
	public Libro buscarLibroPorID(int id) {
		Libro objLibro = new Libro();
		try {
			objLibro = em.find(Libro.class, id);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return objLibro;
	}

	@Override
	public List<Libro> listar() {
		List<Libro> libros = new ArrayList<Libro>();
		try {
			TypedQuery<Libro> query = em.createQuery ("select a from Libro a", Libro.class);
			libros = query.getResultList();
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return libros;
	}

	@Override
	public List<Libro> buscarLibroPorTitulo(String titulo) {
		List<Libro> libros = new ArrayList<Libro>();
		try {
			TypedQuery<Libro> query = em.createQuery ("select a from Libro a where a.titulo like :titulo", Libro.class);
			query.setParameter("titulo", "%" + titulo + "%");
			libros = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return libros;
	}

}
