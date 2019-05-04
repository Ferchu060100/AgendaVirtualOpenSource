package pe.agendavirtual.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import pe.agendavirtual.entity.Alumno;
import pe.agendavirtual.entity.Observacion;
import pe.agendavirtual.entity.Profesor;
import pe.agendavirtual.entity.TipoObservacion;
import pe.agendavirtual.repository.AlumnoRepository;
import pe.agendavirtual.repository.ObservacionRepository;
import pe.agendavirtual.repository.ProfesorRepository;
import pe.agendavirtual.repository.TipoObservacionRepository;
import pe.agendavirtual.web.util.Message;

public class ObservacionController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	AlumnoRepository alumnoRepo;
	@Inject
	ProfesorRepository profesorRepo;
	@Inject
	TipoObservacionRepository tipoRepo;
	@Inject
	ObservacionRepository observacionRepo;
	
	private List<Alumno> alumnos;
	private List<Profesor> profesores;
	private List<TipoObservacion> tipos;
	private List<Observacion> observaciones;
	private Observacion observacion;
	private Observacion observacionSeleccionado;
	private Profesor profesor; 
	private Alumno alumno;
	private TipoObservacion tipo;
	
	@PostConstruct
	public void init() {
		observacion = new Observacion(); //objeto creado para usarse en el libros_crear.xhtml
		cargarobservaciones(); //obtener la lista de editoriales a cargarse en el libros_crear.xhtml
		cargarProfesores(); //obtener la lista de generos a cargarse en el libros_crear.xhtml
		cargarTipos();
		cargarAlumnos(); //obtener la lista de generos a cargarse en el libros_listado.xhtml
		
		tipo = new TipoObservacion(); //creado para recibir la editorial seleccionada en el libros_crear.xhtml
		profesor = new Profesor(); //creado para recibir el genero seleccionado en el libros_crear.xhtml
		observacionSeleccionado = new Observacion();
		alumno= new Alumno();
	}
	
	public void guardar() {
		try {
			
			observacion.setObservacion(tipo);
			observacion.setProfesor(profesor);//setear al libro el genero seleccionado
			observacion.setAlumno(alumno); 
			boolean flag = observacionRepo.insertar(observacion);
			if(flag) {
				this.limpiarFormulario();
		       	Message.messageInfo("Libro creado");
			}else {
				Message.messageError("No se pudo crear la observacion");
			}
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al crear la observacion");
			System.out.println(e.getMessage());
		}	
	}
	
	
	public void cargarobservaciones() {
		try {
			this.observaciones = observacionRepo.listar();
		}catch (Exception e) {
			Message.messageError("Ocurrió un error al listar las editoriales");
			System.out.println(e.getMessage());
		}
	}
	

	public void cargarProfesores() {
		try {
			this.profesores = profesorRepo.listar();
		}catch (Exception e) {
			Message.messageError("Ocurrió un error al listar las editoriales");
			System.out.println(e.getMessage());
		}
	}
	
	public void cargarTipos() {
		try {
			this.tipos = tipoRepo.listar();
		}catch (Exception e) {
			Message.messageError("Ocurrió un error al listar las editoriales");
			System.out.println(e.getMessage());
		}
	}
	
	public void cargarAlumnos(){
		try {
			this.alumnos = alumnoRepo.listar();
		}catch (Exception e) {
			Message.messageError("Ocurrió un error al listar las editoriales");
			System.out.println(e.getMessage());
		}
	}
	
	public void eliminar(int observacionID) {
		try {
			boolean flag = observacionRepo.eliminar(observacionID);
			if(flag) {
		       	this.cargarTipos();
		       	Message.messageInfo("Observacion eliminado");
	       }else {
	       		Message.messageError("No se pudo eliminar la observacion");
	       }
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al eliminar la observacion");
			System.out.println(e.getMessage());
		}
	}

	public void limpiarFormulario() {
		observacion = new Observacion();
	}
	
	public void actualizar() {
		try {
			if (this.observacionSeleccionado.getId() > 0) {

				observacionSeleccionado.setObservacion(this.observacionSeleccionado.getObservacion());
				observacionSeleccionado.setProfesor(this.observacionSeleccionado.getProfesor());//setear al libro el genero seleccionado
				observacionSeleccionado.setAlumno(this.observacionSeleccionado.getAlumno()); 
				
				boolean flag = observacionRepo.actualizar(observacionSeleccionado);
				if(flag) {
					this.limpiarFormulario();
			       	Message.messageInfo("Observacion actualizado");
				}else {
					Message.messageError("No se pudo actualizar la observacion");
				}
			} else {
				Message.messageInfo("Debe seleccionar una observacion");
			}
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al editar la observacion");
			System.out.println(e.getMessage());
		}

	}

	public AlumnoRepository getAlumnoRepo() {
		return alumnoRepo;
	}

	public void setAlumnoRepo(AlumnoRepository alumnoRepo) {
		this.alumnoRepo = alumnoRepo;
	}

	public ProfesorRepository getProfesorRepo() {
		return profesorRepo;
	}

	public void setProfesorRepo(ProfesorRepository profesorRepo) {
		this.profesorRepo = profesorRepo;
	}

	public TipoObservacionRepository getTipoRepo() {
		return tipoRepo;
	}

	public void setTipoRepo(TipoObservacionRepository tipoRepo) {
		this.tipoRepo = tipoRepo;
	}

	public ObservacionRepository getObservacionRepo() {
		return observacionRepo;
	}

	public void setObservacionRepo(ObservacionRepository observacionRepo) {
		this.observacionRepo = observacionRepo;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	public List<TipoObservacion> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoObservacion> tipos) {
		this.tipos = tipos;
	}

	public List<Observacion> getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(List<Observacion> observaciones) {
		this.observaciones = observaciones;
	}

	public Observacion getObservacion() {
		return observacion;
	}

	public void setObservacion(Observacion observacion) {
		this.observacion = observacion;
	}

	public Observacion getObservacionSeleccionado() {
		return observacionSeleccionado;
	}

	public void setObservacionSeleccionado(Observacion observacionSeleccionado) {
		this.observacionSeleccionado = observacionSeleccionado;
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

	public TipoObservacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoObservacion tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
