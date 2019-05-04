package pe.agendavirtual.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import pe.agendavirtual.entity.Alumno;
import pe.agendavirtual.entity.Asistencia;
import pe.agendavirtual.entity.HorarioProfesor;
import pe.agendavirtual.entity.Observacion;
import pe.agendavirtual.entity.Profesor;
import pe.agendavirtual.entity.TipoObservacion;
import pe.agendavirtual.repository.AlumnoRepository;
import pe.agendavirtual.repository.AsistenciaRepository;
import pe.agendavirtual.repository.HorarioProfesorRepository;
import pe.agendavirtual.repository.ObservacionRepository;
import pe.agendavirtual.repository.ProfesorRepository;
import pe.agendavirtual.repository.TipoObservacionRepository;
import pe.agendavirtual.web.util.Message;

public class AsistenciaController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	AlumnoRepository alumnoRepo;
	@Inject
	HorarioProfesorRepository profesorRepo;
	@Inject
	AsistenciaRepository asistenciaRepo;
	
	
	private List<Alumno> alumnos;
	private List<HorarioProfesor> profesores;
	private List<Asistencia> asistencias;
	private Asistencia asistencia;
	private Asistencia asistenciaSeleccionado;
	private HorarioProfesor profesor; 
	private Alumno alumno;

	
	@PostConstruct
	public void init() {
		asistencia = new Asistencia(); //objeto creado para usarse en el libros_crear.xhtml
		cargarasistencias(); //obtener la lista de editoriales a cargarse en el libros_crear.xhtml
		cargarHorarios(); //obtener la lista de generos a cargarse en el libros_crear.xhtml
		cargarAlumnos(); //obtener la lista de generos a cargarse en el libros_listado.xhtml
		
		profesor = new HorarioProfesor(); //creado para recibir el genero seleccionado en el libros_crear.xhtml
		asistenciaSeleccionado = new Asistencia();
		alumno= new Alumno();
	}
	
	public void guardar() {
		try {
			
			asistencia.setAlumno(alumno);
			asistencia.setHorarioprofesor(profesor);

			boolean flag = asistenciaRepo.insertar(asistencia);
			if(flag) {
				this.limpiarFormulario();
		       	Message.messageInfo("asistencia creada");
			}else {
				Message.messageError("No se pudo crear la asistencia");
			}
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al crear la asistencia");
			System.out.println(e.getMessage());
		}	
	}
	
	
	public void cargarasistencias() {
		try {
			this.asistencias = asistenciaRepo.listar();
		}catch (Exception e) {
			Message.messageError("Ocurrió un error al listar las asistencias");
			System.out.println(e.getMessage());
		}
	}
	

	public void cargarHorarios() {
		try {
			this.profesores = profesorRepo.listar();
		}catch (Exception e) {
			Message.messageError("Ocurrió un error al listar los horarios");
			System.out.println(e.getMessage());
		}
	}
	

	public void cargarAlumnos(){
		try {
			this.alumnos = alumnoRepo.listar();
		}catch (Exception e) {
			Message.messageError("Ocurrió un error al listar los alumnos");
			System.out.println(e.getMessage());
		}
	}
	
	public void eliminar(int asistenciaID) {
		try {
			boolean flag = asistenciaRepo.eliminar(asistenciaID);
			if(flag) {
		       	this.cargarasistencias();
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
		asistencia = new Asistencia();
	}
	
	public void actualizar() {
		try {
			if (this.asistenciaSeleccionado.getId() > 0) {
				asistenciaSeleccionado.setHorarioprofesor(this.asistenciaSeleccionado.getHorarioprofesor());
				asistenciaSeleccionado.setAlumno(this.asistenciaSeleccionado.getAlumno()); 
				
				boolean flag = asistenciaRepo.actualizar(asistenciaSeleccionado);
				if(flag) {
					this.limpiarFormulario();
			       	Message.messageInfo("Asistencia actualizada");
				}else {
					Message.messageError("No se pudo actualizar la asistencia");
				}
			} else {
				Message.messageInfo("Debe seleccionar una asistencia");
			}
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al editar la asistencia");
			System.out.println(e.getMessage());
		}

	}
}
