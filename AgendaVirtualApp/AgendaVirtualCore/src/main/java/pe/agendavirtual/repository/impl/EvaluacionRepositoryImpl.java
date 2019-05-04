package pe.agendavirtual.repository.impl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.agendavirtual.entity.Evaluacion;
import  pe.agendavirtual.repository.EvaluacionRepository;


public class EvaluacionRepositoryImpl implements EvaluacionRepository,Serializable{
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="AgendaVirtualMySqlDS")
	private EntityManager em;
	@Override
	public Evaluacion buscarEvaluacionPorID(int id) {
		Evaluacion objEvaluacion = new Evaluacion();
		try {
			objEvaluacion= em.find(Evaluacion.class, id);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return objEvaluacion;
	}

	@Override
	public List<Evaluacion> buscarEvaluacionPorTitulo(String titulo) {
		List<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();
		try {
			TypedQuery<Evaluacion> query = em.createQuery("select a from Evaluacion a where a.nombre like :nombre",Evaluacion.class);
			query.setParameter("nombre", "%"+titulo+"%") ;
			evaluaciones = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return evaluaciones;
	}

	@Override
	public List<Evaluacion> listar() {
		List<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();
		try {
			TypedQuery<Evaluacion> query = em.createQuery("select a from Evaluacion a",Evaluacion.class);
			evaluaciones = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return evaluaciones;
	}
}
