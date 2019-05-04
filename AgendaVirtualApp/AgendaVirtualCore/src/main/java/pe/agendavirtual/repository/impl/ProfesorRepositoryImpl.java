package pe.agendavirtual.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.agendavirtual.entity.Profesor;
import pe.agendavirtual.repository.ProfesorRepository;

@Named
public class ProfesorRepositoryImpl implements ProfesorRepository,Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="MySqlDS")
	private EntityManager em;
	
	@Override
	public Profesor buscarProfesorPorID(int id) {
		Profesor objProfesor= new Profesor();
		try {
			objProfesor= em.find(Profesor.class,id);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return objProfesor;
	}

	@Override
	public List<Profesor> buscarProfesorPorNombre(String titulo) {
		List<Profesor> profesores = new ArrayList<Profesor>();
		try {
			TypedQuery<Profesor> query = em.createQuery("select  a from profesores a where a.nombre like:nombre",Profesor.class);
			query.setParameter("nombre", "%"+titulo+"%");
			profesores= query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return profesores;
	}

	@Override
	public List<Profesor> listar() {
		List<Profesor> profesores = new ArrayList<Profesor>();
		try {
			TypedQuery<Profesor> query = em.createQuery("select a from profesores a ",Profesor.class);
			profesores = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return profesores;
	}

}
