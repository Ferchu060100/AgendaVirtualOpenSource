package pe.libreria.repository;

import java.util.List;

import pe.libreria.entity.Libro;


public interface LibroRepository {

	public boolean insertar(Libro libro);
	
	public boolean eliminar(int id);
	
	public boolean actualizar(Libro libro);
		
	public Libro buscarLibroPorID(int id);
	
	public List<Libro> buscarLibroPorTitulo(String titulo);
	
	public List<Libro> listar();
}
