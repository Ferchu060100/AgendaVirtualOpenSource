package pe.libreria.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import pe.libreria.entity.Genero;
import pe.libreria.repository.GeneroRepository;
import pe.libreria.web.util.Message;

@Named
@ViewScoped
public class GeneroController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	GeneroRepository generoRepo;
	
	private Genero genero;
	private List<Genero> generos;
	
	@PostConstruct
	public void init() {
		genero = new Genero();
		cargarGeneros();
	}
	
	public void cargarGeneros() {
		try {
			this.generos = generoRepo.listar();
		}catch (Exception e) {
			Message.messageError("Ocurrió un error al listar los generos");
			System.out.println(e.getMessage());
		}
	}
	
	//Insertar un nuevo genero, llamado desde generos_crear.xhtml
	public void guardar() {
		try {
			boolean flag = generoRepo.insertar(genero);
	        if(flag) {
	        	this.limpiarFormulario();
	        	Message.messageInfo("Genero creado");
	        }else {
	        	Message.messageError("No se pudo crear el genero");
	        }
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al crear el genero");
			System.out.println(e.getMessage());
		}	
	}
	
	//Eliminar un genero, llamado desde generos_listado.xhtml
	public void eliminar(int generoID) {
		try {
			boolean flag = generoRepo.eliminar(generoID);
			
	        if(flag) {
	        	this.cargarGeneros();
	        	Message.messageInfo("Genero eliminado");
	        }else {
	        	Message.messageError("No se pudo eliminar el genero");
	        }
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al eliminar el genero");
		}
	}
	
	//Opción para buscar por nombres parecidos a generos, llamado desde generos_buscar.xhtml
    public void buscarPorNombre() {
		this.generos = generoRepo.buscarGeneroPorNombre(this.genero.getNombre());
	}
	
	/* Inicio: Editar genero, llamado desde generos_listado.xhtml en el evento rowEdit */
	public void onRowEdit(RowEditEvent event) {
		try {
			genero = (Genero)event.getObject();
	        boolean flag = generoRepo.actualizar(genero);
	        if(flag) {
	        	Message.messageInfo("Genero editado");
	        }else {
	        	Message.messageError("No se pudo editar el genero");
	        }
		}catch (Exception e) {
			Message.messageError("Ocurrió un error al editar el genero");
			System.out.println(e.getMessage());
		}
    }
     
    public void onRowCancel(RowEditEvent event) {
    	Message.messageInfo("Edición cancelada");
    }
    /* Fin: Editar editorial */
	
	public void limpiarFormulario() {
		genero = new Genero();
	}

	/* Métodos Get y Set de las variables declaradas a nivel de la clase */
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}	
}