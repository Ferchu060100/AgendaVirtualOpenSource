package pe.agendavirtual.repository;

import java.util.List;

import pe.agendavirtual.entity.HorarioAlumno;


public interface HorarioAlumnoRepository {

	public HorarioAlumno buscarHorarioAlumnoPorID(int id);
	public List<HorarioAlumno> buscarHorarioAlumnoPorNombre(String titulo);
	public List<HorarioAlumno> listar();
}
