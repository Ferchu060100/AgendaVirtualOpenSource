package pe.libreria.repository;

import java.util.List;

import pe.libreria.entity.Genero;

public interface GeneroRepository {

	public boolean insertar(Genero genero);
	
	public boolean eliminar(int id);
	
	public boolean actualizar(Genero genero);
		
	public Genero buscarGeneroPorID(int id);
	
	public List<Genero> buscarGeneroPorNombre(String nombre);
	
	public List<Genero> listar();
}
