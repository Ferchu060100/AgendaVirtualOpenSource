package pe.agendavirtual.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.agendavirtual.entity.Apoderado;
import pe.agendavirtual.repository.ApoderadoRepository;
import pe.agendavirtual.repository.TipoDocumentoRepository;
import pe.agendavirtual.web.util.Message;


@Named
@ViewScoped
public class ApoderadoController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	ApoderadoRepository apoderadoRepo;
	@Inject
	TipoDocumentoRepository tipodocuRepo;
	private List<Apoderado> apoderados;

	@PostConstruct
	public void init() {
     cargarApoderados();		
	
	}

	private void cargarApoderados() {
		try {
			this.setApoderados(apoderadoRepo.listar());
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al listar los apoderados");
			System.out.println(e.getMessage());
		}
		
	}

	public List<Apoderado> getApoderados() {
		return apoderados;
	}

	public void setApoderados(List<Apoderado> apoderados) {
		this.apoderados = apoderados;
	}
	
	
}
