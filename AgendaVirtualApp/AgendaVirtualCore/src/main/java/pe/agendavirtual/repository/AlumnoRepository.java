package pe.agendavirtual.repository;

import java.util.List;

import pe.agendavirtual.entity.Alumno;



public interface AlumnoRepository {

	public Alumno buscarAlumnoPorID(int id);
	public List<Alumno> buscarAlumnoPorNombre(String titulo);
	public List<Alumno> listar();
}
