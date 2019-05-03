package pe.agendavirtual.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pe.agendavirtual.web.util.Message;
import pe.agendavirtual.entity.TipoDocumento;
import pe.agendavirtual.repository.TipoDocumentoRepository;

@Named
@ViewScoped
public class TipoDocumentoController implements Serializable {
	private static final long serialVersionUID = 1L;
    @Inject	
	TipoDocumentoRepository tipodocumentoRepo;
    
	private TipoDocumento tipodocumento;
    private List<TipoDocumento> tipodocumentos;
    
    @PostConstruct
    public void init() {
        tipodocumento = new TipoDocumento();
    	cargarTipoDocumentos();
    }
	public void cargarTipoDocumentos(){
		try {
			this.setTipodocumentos(tipodocumentoRepo.listar());
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al listar los tipo de documentos");
		}
		
	}
	public TipoDocumento getTipodocumento() {
		return tipodocumento;
	}
	public void setTipodocumento(TipoDocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	public List<TipoDocumento> getTipodocumentos() {
		return tipodocumentos;
	}
	public void setTipodocumentos(List<TipoDocumento> tipodocumentos) {
		this.tipodocumentos = tipodocumentos;
	}
    
    
    
}
