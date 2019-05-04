package pe.agendavirtual.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.agendavirtual.entity.Alumno;
import pe.agendavirtual.entity.Calificacion;
import pe.agendavirtual.entity.Curso;
import pe.agendavirtual.entity.Evaluacion;
import pe.agendavirtual.entity.Profesor;
import pe.agendavirtual.repository.AlumnoRepository;
import pe.agendavirtual.repository.CalificacionRepository;
import pe.agendavirtual.repository.CursoRepository;
import pe.agendavirtual.repository.EvaluacionRepository;
import pe.agendavirtual.repository.ProfesorRepository;
import pe.agendavirtual.web.util.Message;

@Named
@ViewScoped
public class CalificacionController implements Serializable{
	private static final long serialVersionUID = 1L;
	@Inject
	CalificacionRepository calificacionRepo;
	@Inject
	CursoRepository cursoRepo;
	@Inject
	EvaluacionRepository evaluacionRepo;
	@Inject
	ProfesorRepository profesorRepo;
	@Inject
	AlumnoRepository alumnoRepo;
	
	private List<Curso>cursos;
	private List<Evaluacion>evaluaciones;
	private List<Profesor>profesores;
	private List<Alumno>alumnos;
	private Curso curso;
	private Evaluacion evaluacion;
	private Profesor profesor;
	private Alumno alumno;
	private Calificacion calificacion;
	private Calificacion calificacionSeleccionada;
	@PostConstruct
	public void init() {
		curso = new Curso();
		evaluacion = new Evaluacion();
		profesor = new Profesor();
		calificacion = new Calificacion();
		calificacionSeleccionada = new Calificacion();
		cargarCursos();
		cargarProfesores();
		cargarAlumnos();
		cargarEvaluaciones();
		
	}
	
	public void guardar() {
		try {
			calificacion.setAlumno(alumno);
			calificacion.setCurso(curso);
			calificacion.setProfesor(profesor);
			calificacion.setEvaluacion(evaluacion);
			boolean flag = calificacionRepo.registrar(calificacion);
			if(flag) {
				this.limpiarFormulario();
				Message.messageInfo("Calificacion Agregada");
			}else {
				Message.messageError("No se pudo agregar la calificacion");
			}
			
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al agregar la calificacion");
			System.out.println(e.getMessage());
		}
		
	}
	
	public void actualizar() {
		try {
			if(this.calificacionSeleccionada.getId()>0) {
				calificacionSeleccionada.setAlumno(this.calificacionSeleccionada.getAlumno());
				calificacionSeleccionada.setCurso(this.calificacionSeleccionada.getCurso());
				calificacionSeleccionada.setEvaluacion(this.calificacionSeleccionada.getEvaluacion());
				calificacionSeleccionada.setProfesor(this.calificacionSeleccionada.getProfesor());
				
				boolean flag = calificacionRepo.modificar(calificacionSeleccionada);
				if(flag) {
					this.limpiarFormulario();
					Message.messageInfo("Calificacion actualizada");
				}else {
					Message.messageError("No se pudo actualizar la calificacion");
				}
	
			}else {  Message.messageError("Debe seleccionar una calificacion"); }
			
			
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al editar la calificacion");
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	
	public void limpiarFormulario() {
		calificacion = new Calificacion();
	}
	
	
	private void cargarEvaluaciones() {
		try {
			evaluaciones = evaluacionRepo.listar();
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al listar las evaluaciones");
			System.out.println(e.getMessage());
		}
		
	}
	private void cargarProfesores() {
		try {
			profesores = profesorRepo.listar();
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al listar los profesores");
			System.out.println(e.getMessage());
		}
		
	}
	private void cargarAlumnos() {
	   try {
		
		   this.alumnos = alumnoRepo.listar();		   
	} catch (Exception e) {
		Message.messageError("Ocurrió un error al listar los alumnos");
		System.out.println(e.getMessage());
	}
	
		
		
	}
	private void cargarCursos() {
		try {
			this.setCursos(cursoRepo.listar());
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al listar los cursos");
			System.out.println(e.getMessage());
		}
		
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public List<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}
	public void setEvaluaciones(List<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}
	public List<Profesor> getProfesores() {
		return profesores;
	}
	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Evaluacion getEvaluacion() {
		return evaluacion;
	}
	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Calificacion getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}
	public Calificacion getCalificacionSeleccionada() {
		return calificacionSeleccionada;
	}
	public void setCalificacionSeleccionada(Calificacion calificacionSeleccionada) {
		this.calificacionSeleccionada = calificacionSeleccionada;
	}
	
	
}
