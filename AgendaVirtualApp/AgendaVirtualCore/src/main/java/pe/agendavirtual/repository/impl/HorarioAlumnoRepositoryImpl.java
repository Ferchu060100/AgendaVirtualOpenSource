package pe.agendavirtual.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.agendavirtual.entity.HorarioAlumno;
import pe.agendavirtual.repository.HorarioAlumnoRepository;

public class HorarioAlumnoRepositoryImpl implements HorarioAlumnoRepository,Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="MySqlDS")
	private EntityManager em;

	@Override
	public HorarioAlumno buscarHorarioAlumnoPorID(int id) {
		HorarioAlumno HorarioAlumnos= new HorarioAlumno();
		try {
			HorarioAlumnos= em.find(HorarioAlumno.class,id);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return HorarioAlumnos;
	}

	@Override
	public List<HorarioAlumno> buscarHorarioAlumnoPorNombre(String titulo) {
		List<HorarioAlumno> HorarioAlumnos = new ArrayList<HorarioAlumno>();
		try {
			TypedQuery<HorarioAlumno> query = em.createQuery("select  a from horario_alumnos a where a.nombre like:nombre",HorarioAlumno.class);
			query.setParameter("nombre", "%"+titulo+"%");
			HorarioAlumnos= query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return HorarioAlumnos;
	}

	@Override
	public List<HorarioAlumno> listar() {
		List<HorarioAlumno> HorarioAlumnos = new ArrayList<HorarioAlumno>();
		try {
			TypedQuery<HorarioAlumno> query = em.createQuery("select a from horario_alumnos a ",HorarioAlumno.class);
			HorarioAlumnos = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return HorarioAlumnos;
	}
	
}
