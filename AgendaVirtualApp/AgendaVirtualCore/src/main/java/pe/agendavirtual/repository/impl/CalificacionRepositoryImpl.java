package pe.agendavirtual.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.agendavirtual.entity.Calificacion;
import pe.agendavirtual.repository.CalificacionRepository;

public class CalificacionRepositoryImpl implements CalificacionRepository,Serializable{
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="AgendaVirtualMySqlDS")
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
			TypedQuery<Calificacion> query = em.createQuery("select a from Calificacion a ",Calificacion.class);
			calificaciones = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return calificaciones;
	}

	@Override
	@Transactional
	public boolean registrar(Calificacion calificacion) {
		boolean flag = false;
		try {
			em.persist(calificacion);
			flag=true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	@Override
	@Transactional
	public boolean modificar(Calificacion calificacion) {
		boolean flag = false;
		try {
			em.merge(calificacion);
			flag=true;
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
			Calificacion objCalificacion = this.buscarCalificacionPorID(id);
			em.remove(objCalificacion);
			flag=true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}



}
