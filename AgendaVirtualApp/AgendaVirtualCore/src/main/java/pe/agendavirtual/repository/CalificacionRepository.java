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
	Calificacion registrar(Calificacion calificacion);

	Calificacion modificar(Calificacion calificacion);

	void eliminar(int id);

	Optional<Calificacion> listId(int id);
}
