package pe.agendavirtual.repository;

import java.util.List;

import pe.agendavirtual.entity.HorarioProfesor;

public interface HorarioProfesorRepository {
	public HorarioProfesor buscarHorarioProfesorPorID(int id);
	public List<HorarioProfesor> buscarHorarioProfesorPorNombre(String titulo);
	public List<HorarioProfesor> listar();
}
