package pe.agendavirtual.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.agendavirtual.entity.NivelEducativo;

import pe.agendavirtual.repository.NivelEducativoRepository;


public class NivelEducativoRepositoryImpl implements NivelEducativoRepository, Serializable {
	private static final long serialVersionUID = 1L;  
	
	@PersistenceContext(unitName="AgendaVirtualMySqlDS")
	private EntityManager em;

	@Override
	public NivelEducativo buscarNivelEducativoPorID(int id) {
		NivelEducativo objNivelEdu = new NivelEducativo();
        try {
       	 objNivelEdu = em.find(NivelEducativo.class, id);
        }catch (Exception e) {
			System.out.print(e.getMessage());
		}		
	
		return objNivelEdu;
	}

	@Override
	public List<NivelEducativo> buscarNivelEducativoPorNombre(String titulo) {
		List<NivelEducativo> niveleducativos = new ArrayList<NivelEducativo>();
		try {
			TypedQuery<NivelEducativo> query = em.createQuery("select a from nivel_educativos a where a.nombre like nombre",NivelEducativo.class);
			query.setParameter("nombre", "%"+titulo+"%");
			niveleducativos = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return niveleducativos;
	}

	@Override
	public List<NivelEducativo> listar() {
		List<NivelEducativo> niveleducativos = new ArrayList<NivelEducativo>();
		try {
			TypedQuery<NivelEducativo> query = em.createQuery("select a from nivel_educativos a",NivelEducativo.class);
			niveleducativos = query.getResultList();
		}catch(Exception e) {System.out.print(e.getMessage()); }
		
		return niveleducativos;
	}
	
}
