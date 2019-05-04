package pe.agendavirtual.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.agendavirtual.entity.GradoEducativo;
import pe.agendavirtual.repository.GradoEducativoRepository;

public class GradoEducativoImpl implements GradoEducativoRepository,Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="AgendaVirtualMySqlDS")
	private EntityManager em;

	@Override
	public GradoEducativo buscarGradoEducativoPorID(int id) {
		GradoEducativo objEducativo= new GradoEducativo();
		try {
			objEducativo= em.find(GradoEducativo.class,id);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return objEducativo;
	}

	@Override
	public List<GradoEducativo> buscarGradoEducativoPorNombre(String titulo) {
		List<GradoEducativo> educativos = new ArrayList<GradoEducativo>();
		try {
			TypedQuery<GradoEducativo> query = em.createQuery("select  a from grado_educativos a where a.nombre like:nombre",GradoEducativo.class);
			query.setParameter("nombre", "%"+titulo+"%");
			educativos= query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return educativos;
	}

	@Override
	public List<GradoEducativo> listar() {
		List<GradoEducativo> educativos = new ArrayList<GradoEducativo>();
		try {
			TypedQuery<GradoEducativo> query = em.createQuery("select a from grado_educativos a ",GradoEducativo.class);
			educativos = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return educativos;
	}



}
