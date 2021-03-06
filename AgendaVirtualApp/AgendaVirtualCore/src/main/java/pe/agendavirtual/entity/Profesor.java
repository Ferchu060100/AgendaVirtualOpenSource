package pe.agendavirtual.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="profesores")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido_paterno")
	private String apellidopaterno;
	@Column(name="apellido_materno")
	private String apellidomaterno;
	@Column(name="fecha_nacimiento")
	private Date fechanacimiento;
	@Column(name="nro_documento")
	private String nrodocumento;
	private String correo;
	private String telefono;
	@ManyToOne
	@JoinColumn(name = "tipo_documento_id")
	private TipoDocumento tipodocumento;
	@ManyToOne
	@JoinColumn(name = "nivel_educativo_id")
	private TipoDocumento niveleducativo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidopaterno() {
		return apellidopaterno;
	}
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public String getApellidomaterno() {
		return apellidomaterno;
	}
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	public Date getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public String getNrodocumento() {
		return nrodocumento;
	}
	public void setNrodocumento(String nrodocumento) {
		this.nrodocumento = nrodocumento;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public TipoDocumento getTipodocumento() {
		return tipodocumento;
	}
	public void setTipodocumento(TipoDocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	public TipoDocumento getNiveleducativo() {
		return niveleducativo;
	}
	public void setNiveleducativo(TipoDocumento niveleducativo) {
		this.niveleducativo = niveleducativo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
