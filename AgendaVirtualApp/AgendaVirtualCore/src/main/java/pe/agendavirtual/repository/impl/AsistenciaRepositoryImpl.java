package pe.agendavirtual.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.agendavirtual.entity.Asistencia;
import pe.agendavirtual.repository.AsistenciaRepository;


@Named
public class AsistenciaRepositoryImpl implements AsistenciaRepository, Serializable  {
private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="AgendaVirtualMySqlDS")
	private EntityManager em;
	
	
	@Override
	@Transactional
	public boolean insertar(Asistencia asistencia) {
		boolean flag = false;
		try {
			em.persist(asistencia);
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
			Asistencia objAsistencia = this.buscarAsistenciaPorID(id);
			em.remove(objAsistencia );
			flag = true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}	
		return flag;
	}

	@Override
	@Transactional
	public boolean actualizar(Asistencia asistencia) {
		boolean flag = false;
		try {
			em.merge(asistencia);
			flag = true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}	
		return flag;
	}

	@Override
	public Asistencia buscarAsistenciaPorID(int id) {
		
		Asistencia objAsistencia = new Asistencia();
		try {
			objAsistencia = em.find(Asistencia.class, id);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return objAsistencia;
	}

	
	@Override
	public List<Asistencia> listar() {
		List<Asistencia> asistencias = new ArrayList<Asistencia>();
		try {
			TypedQuery<Asistencia> query = em.createQuery ("select a from asistencias a", Asistencia.class);
			asistencias = query.getResultList();
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return asistencias;
	}

}
