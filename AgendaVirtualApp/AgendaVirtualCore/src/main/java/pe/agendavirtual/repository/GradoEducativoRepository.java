package pe.agendavirtual.repository;

import java.util.List;

import pe.agendavirtual.entity.GradoEducativo;

public interface GradoEducativoRepository {

	public GradoEducativo buscarGradoEducativoPorID(int id);
	public List<GradoEducativo> buscarGradoEducativoPorNombre(String titulo);
	public List<GradoEducativo> listar();
}
