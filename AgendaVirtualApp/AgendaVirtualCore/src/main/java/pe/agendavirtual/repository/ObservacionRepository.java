package pe.agendavirtual.repository;

import java.util.List;

import pe.agendavirtual.entity.Observacion;

public interface ObservacionRepository {
	
	public boolean insertar(Observacion observacion);
	
	public boolean eliminar(int id);
	
	public boolean actualizar(Observacion observacion);
		
	public Observacion buscarObservacionPorID(int id);
	
	public List<Observacion> listar();
}
