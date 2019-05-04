package pe.agendavirtual.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import pe.agendavirtual.entity.TipoDocumento;
import pe.agendavirtual.repository.TipoDocumentoRepository;
import java.io.Serializable;

@Named
public class TipoDocumentoRepositoryImpl implements TipoDocumentoRepository, Serializable {
	private static final long serialVersionUID = 1L;  
	
	@PersistenceContext(unitName="AgendaVirtualMysqlDS")
	private EntityManager em;
	
	@Override
	public TipoDocumento buscarTipoDocumentoPorID(int id) {
		TipoDocumento objTipoDocu = new TipoDocumento();
         try {
        	 objTipoDocu = em.find(TipoDocumento.class, id);
         }catch (Exception e) {
			System.out.print(e.getMessage());
		}		
	
		return objTipoDocu;
	}

	@Override
	public List<TipoDocumento> buscarTipoDocumentoPorTitulo(String titulo) {
		List<TipoDocumento> tipodocumentos = new ArrayList<TipoDocumento>();
		try {
			TypedQuery<TipoDocumento> query = em.createQuery("select a from tipo_documentos a where a.nombre like nombre",TipoDocumento.class);
			query.setParameter("nombre", "%"+titulo+"%");
			tipodocumentos = query.getResultList();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return tipodocumentos;
	}

	@Override
	public List<TipoDocumento> listar() {
		List<TipoDocumento> tipodocumentos = new ArrayList<TipoDocumento>();
		try {
			TypedQuery<TipoDocumento> query = em.createQuery("select a from tipo_documentos a",TipoDocumento.class);
			tipodocumentos = query.getResultList();
		}catch(Exception e) {System.out.print(e.getMessage()); }
		
		return tipodocumentos;
	}

}
