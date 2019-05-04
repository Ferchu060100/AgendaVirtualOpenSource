package pe.agendavirtual.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.agendavirtual.entity.Alumno;
import pe.agendavirtual.repository.AlumnoRepository;

public class AlumnoRepositoryImpl implements AlumnoRepository,Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="AgendaVirtualMySqlDS")
	private EntityManager em;

	@Override
	public Alumno buscarAlumnoPorID(int id) {
		Alumno objAlumno= new Alumno();
		try {
			objAlumno= em.find(Alumno.class,id);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return objAlumno;
	}

	@Override
	public List<Alumno> buscarAlumnoPorNombre(String titulo) {
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			TypedQuery<Alumno> query = em.createQuery("select  a from alumnos a where a.nombre like:nombre",Alumno.class);
			query.setParameter("nombre", "%"+titulo+"%");
			alumnos= query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return alumnos;
	}

	@Override
	public List<Alumno> listar() {
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			TypedQuery<Alumno> query = em.createQuery("select a from Alumno a ",Alumno.class);
			alumnos = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return alumnos;
	}
}
