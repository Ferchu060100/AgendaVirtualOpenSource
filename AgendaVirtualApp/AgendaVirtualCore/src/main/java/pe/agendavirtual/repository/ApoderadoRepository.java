package pe.agendavirtual.repository;

import java.util.List;

import pe.agendavirtual.entity.Apoderado;

public interface ApoderadoRepository {

	public Apoderado buscarApoderadoPorID(int id);
	public List<Apoderado> buscarApoderadoPorNombre(String titulo);
	public List<Apoderado> listar();
}
