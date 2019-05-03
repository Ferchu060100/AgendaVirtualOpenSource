package pe.agendavirtual.repository;

import java.util.List;

import pe.agendavirtual.entity.Dia;



public interface DiaRepository {

	public Dia buscarDiaPorID(int id);
	public List<Dia> buscarDiaPorNombre(String titulo);
	public List<Dia> listar();
}
