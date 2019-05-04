package pe.agendavirtual.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="asistencias")
public class Asistencia implements Serializable  {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private boolean inasistencia;
	private Date fecha;
	@ManyToOne
	@JoinColumn(name = "alumno_id")
	private Alumno alumno;
    @JoinColumn(name = "horario_profesor_id")
	private HorarioProfesor horarioprofesor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isInasistencia() {
		return inasistencia;
	}
	public void setInasistencia(boolean inasistencia) {
		this.inasistencia = inasistencia;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public HorarioProfesor getHorarioprofesor() {
		return horarioprofesor;
	}
	public void setHorarioprofesor(HorarioProfesor horarioprofesor) {
		this.horarioprofesor = horarioprofesor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	
}
