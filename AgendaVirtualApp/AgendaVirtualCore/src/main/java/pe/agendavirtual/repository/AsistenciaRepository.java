package pe.agendavirtual.repository;

import java.util.List;

import pe.agendavirtual.entity.Asistencia;

public interface AsistenciaRepository {

	public boolean insertar(Asistencia asistencia);
	
	public boolean eliminar(int id);
	
	public boolean actualizar(Asistencia asistencia);
		
	public Asistencia buscarAsistenciaPorID(int id);
	
	public List<Asistencia> listar();
	
}
