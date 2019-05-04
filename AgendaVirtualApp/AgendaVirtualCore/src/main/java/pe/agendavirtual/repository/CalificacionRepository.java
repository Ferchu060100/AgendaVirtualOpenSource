package pe.agendavirtual.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import pe.agendavirtual.entity.Calificacion;

public interface CalificacionRepository {
	public Calificacion buscarCalificacionPorID(int id);
	public List<Calificacion> buscarCalificacionPorFecha(Date fecha);
	public List<Calificacion> listar();
	
	//CRUD
	public boolean registrar(Calificacion calificacion);

	public boolean modificar(Calificacion calificacion);

	public boolean eliminar(int id);


}
