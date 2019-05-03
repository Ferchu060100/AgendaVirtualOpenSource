package pe.libreria.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import pe.libreria.entity.Editorial;
import pe.libreria.repository.EditorialRepository;
import pe.libreria.web.util.Message;

@Named
@ViewScoped
public class EditorialController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	EditorialRepository editorialRepo;
	
	private Editorial editorial;
	private List<Editorial> editoriales;
	
	@PostConstruct
	public void init() {
		editorial = new Editorial();
		cargarEditoriales();
	}
	
	public void cargarEditoriales() {
		try {
			this.editoriales = editorialRepo.listar();
		}catch (Exception e) {
			Message.messageError("Ocurrió un error al listar las editoriales");
			System.out.println(e.getMessage());
		}
	}
	
	//Insertar una nueva editorial, llamado desde editorales_crear.xhtml
	public void guardar() {
		try {
			boolean flag = editorialRepo.insertar(editorial);
	        if(flag) {
	        	this.limpiarFormulario();
	        	Message.messageInfo("Editorial creada");
	        }else {
	        	Message.messageError("No se pudo crear la editorial");
	        }
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al crear la editorial");
			System.out.println(e.getMessage());
		}	
	}
	
	//Eliminar una categoria, llamado desde editorales_listado.xhtml
	public void eliminar(int editorialID) {
		try {
			boolean flag = editorialRepo.eliminar(editorialID);
			
	        if(flag) {
	        	this.cargarEditoriales();
	        	Message.messageInfo("Editorial eliminada");
	        }else {
	        	Message.messageError("No se pudo eliminar la editorial");
	        }
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al eliminar la editorial");
		}
	}
	
	/* Inicio: Editar editorial, llamado desde editorales_listado.xhtml en el evento rowEdit */
	public void onRowEdit(RowEditEvent event) {
		try {
			editorial = (Editorial)event.getObject();
	        boolean flag = editorialRepo.actualizar(editorial);
	        if(flag) {
	        	Message.messageInfo("Editorial editada");
	        }else {
	        	Message.messageError("No se pudo editar la editorial");
	        }
		}catch (Exception e) {
			Message.messageError("Ocurrió un error al editar la editorial");
			System.out.println(e.getMessage());
		}
    }
     
    public void onRowCancel(RowEditEvent event) {
    	Message.messageInfo("Edición cancelada");
    }
    /* Fin: Editar editorial */
    
	//Opción para buscar por nombres parecidos a editoriales, llamado desde editorales_buscar.xhtml
    public void buscarPorNombre() {
		this.editoriales = editorialRepo.buscarEditorialPorNombre(this.editorial.getNombre());
	}
	
	public void limpiarFormulario() {
		editorial = new Editorial();
	}

	/* Métodos Get y Set de las variables declaradas a nivel de la clase */
	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public List<Editorial> getEditoriales() {
		return editoriales;
	}

	public void setEditoriales(List<Editorial> editoriales) {
		this.editoriales = editoriales;
	}	
}
