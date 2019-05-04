
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="observaciones")
public class Observacion {
	private static final long serialVersionUID = 1L;
 @Id	
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
 private Date fecha;
 private String descripcion;
 @ManyToOne
	@JoinColumn(name = "alumno_id")
	private Alumno alumno;
 @JoinColumn(name = "tipo_Observacion_id")
	private TipoObservacion observacion;
 @JoinColumn(name = "profesor_id")
	private Profesor profesor;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public Alumno getAlumno() {
	return alumno;
}
public void setAlumno(Alumno alumno) {
	this.alumno = alumno;
}
public TipoObservacion getObservacion() {
	return observacion;
}
public void setObservacion(TipoObservacion observacion) {
	this.observacion = observacion;
}
public Profesor getProfesor() {
	return profesor;
}
public void setProfesor(Profesor profesor) {
	this.profesor = profesor;
}

 
 
}

