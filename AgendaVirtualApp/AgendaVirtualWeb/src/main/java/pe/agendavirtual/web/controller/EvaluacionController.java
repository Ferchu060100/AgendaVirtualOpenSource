package pe.agendavirtual.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.agendavirtual.entity.Evaluacion;
import pe.agendavirtual.repository.EvaluacionRepository;
import pe.agendavirtual.web.util.Message;
@Named
@ViewScoped
public class EvaluacionController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	EvaluacionRepository evaluacionRepo;
	private Evaluacion evaluacion;
	private List<Evaluacion> evaluaciones;
	
	@PostConstruct
	public void init(){
		setEvaluacion(new Evaluacion());
		cargarEvaluaciones();
	}

	private void cargarEvaluaciones() {
		try {
			this.setEvaluaciones(evaluacionRepo.listar());
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al listar las evaluaciones");
			System.out.println(e.getMessage());
		}
		
	}

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public List<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	public void setEvaluaciones(List<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}
	
	
}
