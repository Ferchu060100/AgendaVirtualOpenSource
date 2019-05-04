package pe.agendavirtual.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.agendavirtual.entity.Calificacion;
import pe.agendavirtual.repository.CalificacionRepository;

public class CalificacionRepositoryImpl implements CalificacionRepository{
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="MySqlDS")
	private EntityManager em;
	
	@Override
	public Calificacion buscarCalificacionPorID(int id) {
		Calificacion objCalificacion= new Calificacion();
		try {
			objCalificacion= em.find(Calificacion.class,id);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return objCalificacion;
	}

	@Override
	public List<Calificacion> buscarCalificacionPorFecha(Date fecha) {
		List<Calificacion> calificaciones = new ArrayList<Calificacion>();
		try {
			TypedQuery<Calificacion> query = em.createQuery("select  a from calificaciones a where a.nombre like:nombre",Calificacion.class);
			query.setParameter("nombre", "%"+fecha+"%");
			calificaciones= query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return calificaciones;
	}

	@Override
	public List<Calificacion> listar() {
		List<Calificacion> calificaciones = new ArrayList<Calificacion>();
		try {
			TypedQuery<Calificacion> query = em.createQuery("select a from calificaciones a ",Calificacion.class);
			calificaciones = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return calificaciones;
	}

	@Override
	public Calificacion registrar(Calificacion calificacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Calificacion modificar(Calificacion calificacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Calificacion> listId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
