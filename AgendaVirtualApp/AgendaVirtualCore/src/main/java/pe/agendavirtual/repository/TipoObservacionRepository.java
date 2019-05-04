package pe.agendavirtual.repository;

import java.util.List;

import pe.agendavirtual.entity.TipoObservacion;

public interface TipoObservacionRepository {
	public TipoObservacion buscarTipoObservacionPorID(int id);
    public List<TipoObservacion> buscarTipoObservacionPorTitulo(String tipo);
    public List<TipoObservacion> listar();
}
