package pe.agendavirtual.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pe.agendavirtual.web.util.Message;

import pe.agendavirtual.entity.TipoObservacion;
import pe.agendavirtual.repository.TipoObservacionRepository;

@Named
@ViewScoped
public class TipoObservacionController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	TipoObservacionRepository tipoRepo;
	
	private TipoObservacion tipo;
	private List<TipoObservacion> tipos;
	
	
	@PostConstruct
	public void init() {
		tipo = new TipoObservacion();
		cargarTipos();
	}
	
	public void cargarTipos() {
		try {
			this.tipos = tipoRepo.listar();
		}catch (Exception e) {
			Message.messageError("Ocurrió un error al listar los tipos observaciones");
			System.out.println(e.getMessage());
		}
	}

	public TipoObservacionRepository getTipoRepo() {
		return tipoRepo;
	}

	public void setTipoRepo(TipoObservacionRepository tipoRepo) {
		this.tipoRepo = tipoRepo;
	}

	public TipoObservacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoObservacion tipo) {
		this.tipo = tipo;
	}

	public List<TipoObservacion> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoObservacion> tipos) {
		this.tipos = tipos;
	}
	

	
}
