package pe.agendavirtual.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="horarioProfesores")
public class HorarioProfesor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int horainicio;
	private int horafin;
	@ManyToOne
	@JoinColumn(name = "profesor_id")
	private Profesor profesor;
	@ManyToOne
	@JoinColumn(name = "gradoEducativo_id")
	private GradoEducativo gradoEducativo;
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	@ManyToOne
	@JoinColumn(name = "dia_id")
	private Dia dia;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHorainicio() {
		return horainicio;
	}
	public void setHorainicio(int horainicio) {
		this.horainicio = horainicio;
	}
	public int getHorafin() {
		return horafin;
	}
	public void setHorafin(int horafin) {
		this.horafin = horafin;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public GradoEducativo getGradoEducativo() {
		return gradoEducativo;
	}
	public void setGradoEducativo(GradoEducativo gradoEducativo) {
		this.gradoEducativo = gradoEducativo;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Dia getDia() {
		return dia;
	}
	public void setDia(Dia dia) {
		this.dia = dia;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
