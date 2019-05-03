package pe.agendavirtual.repository;

import java.util.List;

import pe.agendavirtual.entity.NivelEducativo;


public interface NivelEducativoRepository {

	public NivelEducativo buscarNivelEducativoPorID(int id);
	public List<NivelEducativo> buscarNivelEducativoPorNombre(String titulo);
	public List<NivelEducativo> listar();
}
