package pe.agendavirtual.repository;

import java.util.List;

import pe.agendavirtual.entity.Curso;

public interface CursoRepository {

	public Curso buscarCursoPorID(int id);
	public List<Curso> buscarCursoPorNombre(String titulo);
	public List<Curso> listar();

}
