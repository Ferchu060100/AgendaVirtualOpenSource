package pe.agendavirtual.repository;
import java.util.List;

import pe.agendavirtual.entity.TipoDocumento;;
public interface TipoDocumentoRepository {

	public TipoDocumento buscarTipoDocumentoPorID(int id);
    public List<TipoDocumento> buscarTipoDocumentoPorTitulo(String titulo);
    public List<TipoDocumento> listar();
}
