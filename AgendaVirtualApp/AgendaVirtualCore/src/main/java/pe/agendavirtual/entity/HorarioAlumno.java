package pe.agendavirtual.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="horario_alumnos")
public class HorarioAlumno implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int HoraInicio;
	private int HoraFin;
	@JoinColumn(name = "dia_id")
	private Dia dia;
	@JoinColumn(name = "curso_id")
	private Curso curso;
	@JoinColumn(name = "alumno_id")
	private Alumno alumno;
	/*@JoinColumn(name = "profesor_id")
	private Profesor profesor;*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHoraInicio() {
		return HoraInicio;
	}
	public void setHoraInicio(int horaInicio) {
		HoraInicio = horaInicio;
	}
	public int getHoraFin() {
		return HoraFin;
	}
	public void setHoraFin(int horaFin) {
		HoraFin = horaFin;
	}
	public Dia getDia() {
		return dia;
	}
	public void setDia(Dia dia) {
		this.dia = dia;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	/*public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}*/
	
}
