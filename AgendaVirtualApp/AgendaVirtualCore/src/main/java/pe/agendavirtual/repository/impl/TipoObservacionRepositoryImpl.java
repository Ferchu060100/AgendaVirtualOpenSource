package pe.agendavirtual.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.agendavirtual.entity.TipoObservacion;
import pe.agendavirtual.repository.TipoObservacionRepository;

@Named
public class TipoObservacionRepositoryImpl implements TipoObservacionRepository, Serializable {

private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="AgendaVirtualMySqlDS")
	private EntityManager em;
	
	@Override
	public TipoObservacion buscarTipoObservacionPorID(int id) {
		TipoObservacion objtipobser = new TipoObservacion();
		try {
			objtipobser  = em.find(TipoObservacion.class, id);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return objtipobser ;
	}

	@Override
	public List<TipoObservacion> buscarTipoObservacionPorTipo(String tipo) {
		List<TipoObservacion> tipos = new ArrayList<TipoObservacion>();
		try {
			TypedQuery<TipoObservacion> query = em.createQuery ("select a from tipo_observaciones a where a.nombre like :tipo", TipoObservacion.class);
			query.setParameter("Tipo", "%" + tipo + "%");
			tipos = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return tipos;
	}

	
	@Override
	public List<TipoObservacion> listar() {
		List<TipoObservacion> tipos = new ArrayList<TipoObservacion>();
		try {
			TypedQuery<TipoObservacion> query = em.createQuery ("select a from tipo_observaciones a", TipoObservacion.class);
			tipos = query.getResultList();
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return tipos;
	}

}
