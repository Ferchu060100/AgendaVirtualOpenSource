package pe.agendavirtual.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.agendavirtual.entity.Dia;
import pe.agendavirtual.repository.DiaRepository;

public class DiaRepositoryImpl implements DiaRepository,Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="AgendaVirtualMySqlDS")
	private EntityManager em;

	@Override
	public Dia buscarDiaPorID(int id) {
		Dia objDia= new Dia();
		try {
			objDia= em.find(Dia.class,id);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return objDia;
	}

	@Override
	public List<Dia> buscarDiaPorNombre(String titulo) {
		List<Dia> dias = new ArrayList<Dia>();
		try {
			TypedQuery<Dia> query = em.createQuery("select  a from dias a where a.nombre like:nombre",Dia.class);
			query.setParameter("nombre", "%"+titulo+"%");
			dias= query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return dias;
	}

	@Override
	public List<Dia> listar() {
		List<Dia> dias = new ArrayList<Dia>();
		try {
			TypedQuery<Dia> query = em.createQuery("select a from dias a ",Dia.class);
			dias = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return dias;
	}
	
	
}
