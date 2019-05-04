package pe.agendavirtual.repository;

import java.util.List;

import pe.agendavirtual.entity.Profesor;

public interface ProfesorRepository {
	public Profesor buscarProfesorPorID(int id);
	public List<Profesor> buscarProfesorPorNombre(String titulo);
	public List<Profesor> listar();
}
