package pe.agendavirtual.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.agendavirtual.entity.Apoderado;
import pe.agendavirtual.repository.ApoderadoRepository;

@Named
public class ApoderadoRepositoryImpl implements ApoderadoRepository,Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="MySqlDS")
	private EntityManager em;
	
	@Override
	public Apoderado buscarApoderadoPorID(int id) {
		Apoderado objApoderado= new Apoderado();
		try {
			objApoderado= em.find(Apoderado.class,id);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return objApoderado;
	}

	@Override
	public List<Apoderado> buscarApoderadoPorNombre(String titulo) {
		List<Apoderado> apoderados = new ArrayList<Apoderado>();
		try {
			TypedQuery<Apoderado> query = em.createQuery("select  a from apoderados a where a.nombre like:nombre",Apoderado.class);
			query.setParameter("nombre", "%"+titulo+"%");
			apoderados= query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return apoderados;
	}

	@Override
	public List<Apoderado> listar() {
		List<Apoderado> apoderados = new ArrayList<Apoderado>();
		try {
			TypedQuery<Apoderado> query = em.createQuery("select a from apoderados a ",Apoderado.class);
			apoderados = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return apoderados;
	}
	
	
	
	
}
