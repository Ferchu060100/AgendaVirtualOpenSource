package pe.agendavirtual.repository;
import java.util.List;

import pe.agendavirtual.entity.Evaluacion;;

public interface EvaluacionRepository {
	public Evaluacion buscarEvaluacionPorID(int id);
	public List<Evaluacion> buscarEvaluacionPorTitulo(String titulo);
	public List<Evaluacion> listar();
}
