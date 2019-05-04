package pe.agendavirtual.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.agendavirtual.entity.Observacion;
import pe.agendavirtual.repository.ObservacionRepository;


@Named
public class ObservacionRepositoryImpl implements ObservacionRepository, Serializable  {

private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="AgendaVirtualMySqlDS")
	private EntityManager em;
	
	@Override
	@Transactional
	public boolean insertar(Observacion observacion) {
		boolean flag = false;
		try {
			em.persist(observacion);
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
			Observacion objobserv = this.buscarObservacionPorID(id);
			em.remove(objobserv);
			flag = true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}	
		return flag;
	}

	@Override
	@Transactional
	public boolean actualizar(Observacion observacion) {
		boolean flag = false;
		try {
			em.merge(observacion);
			flag = true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}	
		return flag;
	}

	@Override
	public Observacion buscarObservacionPorID(int id) {
		Observacion objobs = new Observacion();
		try {
			objobs = em.find(Observacion.class, id);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return objobs;
	}

	@Override
	public List<Observacion> listar() {
		
		List<Observacion> observaciones = new ArrayList<Observacion>();
		try {
			TypedQuery<Observacion> query = em.createQuery ("select a from observaciones a", Observacion.class);
			observaciones = query.getResultList();
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return observaciones;
	}

}
