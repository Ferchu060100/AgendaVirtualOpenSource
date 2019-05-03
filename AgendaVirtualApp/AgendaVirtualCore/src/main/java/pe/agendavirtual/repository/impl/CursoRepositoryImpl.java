package pe.agendavirtual.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.agendavirtual.entity.Curso;
import pe.agendavirtual.repository.CursoRepository;

public class CursoRepositoryImpl implements CursoRepository,Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="MySqlDS")
	private EntityManager em;

	@Override
	public Curso buscarCursoPorID(int id) {
		Curso objCurso= new Curso();
		try {
			objCurso= em.find(Curso.class,id);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return objCurso;
	}

	@Override
	public List<Curso> buscarCursoPorNombre(String titulo) {
		List<Curso> cursos = new ArrayList<Curso>();
		try {
			TypedQuery<Curso> query = em.createQuery("select  a from cursos a where a.nombre like:nombre",Curso.class);
			query.setParameter("nombre", "%"+titulo+"%");
			cursos= query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return cursos;
	}

	@Override
	public List<Curso> listar() {
		List<Curso> cursos = new ArrayList<Curso>();
		try {
			TypedQuery<Curso> query = em.createQuery("select a from cursos a ",Curso.class);
			cursos = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}	
		return cursos;
	}
}
