package pe.agendavirtual.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.agendavirtual.entity.HorarioProfesor;
import pe.agendavirtual.repository.HorarioProfesorRepository;

public class HorarioProfesorRepositoryImpl implements HorarioProfesorRepository,Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="MySqlDS")
	private EntityManager em;
	
	@Override
	public HorarioProfesor buscarHorarioProfesorPorID(int id) {
		HorarioProfesor HorarioProfesores= new HorarioProfesor();
		try {
			HorarioProfesores= em.find(HorarioProfesor.class,id);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return HorarioProfesores;
	}

	@Override
	public List<HorarioProfesor> buscarHorarioProfesorPorNombre(String titulo) {
		List<HorarioProfesor> HorarioProfesores = new ArrayList<HorarioProfesor>();
		try {
			TypedQuery<HorarioProfesor> query = em.createQuery("select  a from horario_profesores a where a.nombre like:nombre",HorarioProfesor.class);
			query.setParameter("nombre", "%"+titulo+"%");
			HorarioProfesores= query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return HorarioProfesores;
	}

	@Override
	public List<HorarioProfesor> listar() {
		List<HorarioProfesor> HorarioProfesores = new ArrayList<HorarioProfesor>();
		try {
			TypedQuery<HorarioProfesor> query = em.createQuery("select a from horario_profesores a ",HorarioProfesor.class);
			HorarioProfesores = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return HorarioProfesores;
	}

}
