package pe.libreria.repository;

import java.util.List;

import pe.libreria.entity.Editorial;

public interface EditorialRepository {

	public boolean insertar(Editorial editorial);
	
	public boolean eliminar(int id);
	
	public boolean actualizar(Editorial editorial);
		
	public Editorial buscarEditorialPorID(int id);
	
	public List<Editorial> buscarEditorialPorNombre(String nombre);
	
	public List<Editorial> listar();
}
