package pe.libreria.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.libreria.entity.Editorial;
import pe.libreria.entity.Genero;
import pe.libreria.entity.Libro;
import pe.libreria.repository.EditorialRepository;
import pe.libreria.repository.GeneroRepository;
import pe.libreria.repository.LibroRepository;
import pe.libreria.web.util.Message;

@Named
@ViewScoped
public class LibroController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	EditorialRepository editorialRepo;
	@Inject
	GeneroRepository generoRepo;
	@Inject
	LibroRepository libroRepo;
	
	private List<Editorial> editoriales;
	private List<Genero> generos;
	private List<Libro> libros;
	private Libro libro;
	private Libro libroSeleccionado;
	private Editorial editorial; 
	private Genero genero; 
	
	@PostConstruct
	public void init() {
		libro = new Libro(); //objeto creado para usarse en el libros_crear.xhtml
		cargarEditoriales(); //obtener la lista de editoriales a cargarse en el libros_crear.xhtml
		cargarGeneros(); //obtener la lista de generos a cargarse en el libros_crear.xhtml
		
		cargarLibros(); //obtener la lista de generos a cargarse en el libros_listado.xhtml
		
		genero = new Genero(); //creado para recibir la editorial seleccionada en el libros_crear.xhtml
		editorial = new Editorial(); //creado para recibir el genero seleccionado en el libros_crear.xhtml
		
		libroSeleccionado = new Libro();
	}
	
	//Insertar un nuevo genero, llamado desde generos_crear.xhtml
	public void guardar() {
		try {
			libro.setEditorial(editorial); //setear al libro la editorial seleccionada
			libro.setGenero(genero); //setear al libro el genero seleccionado
			
			boolean flag = libroRepo.insertar(libro);
			if(flag) {
				this.limpiarFormulario();
		       	Message.messageInfo("Libro creado");
			}else {
				Message.messageError("No se pudo crear el libro");
			}
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al crear el libro");
			System.out.println(e.getMessage());
		}	
	}
		
	/*Obtener la lista de editoriales*/
	public void cargarEditoriales() {
		try {
			this.editoriales = editorialRepo.listar();
		}catch (Exception e) {
			Message.messageError("Ocurrió un error al listar las editoriales");
			System.out.println(e.getMessage());
		}
	}
	/*Obtener la lista de generos*/
	public void cargarGeneros() {
		try {
			this.generos = generoRepo.listar();
		}catch (Exception e) {
			Message.messageError("Ocurrió un error al listar los generos");
			System.out.println(e.getMessage());
		}
	}
	/*Obtener la lista de libros*/
	public void cargarLibros() {
		try {
			this.libros = libroRepo.listar();
		}catch (Exception e) {
			Message.messageError("Ocurrió un error al listar los libros");
			System.out.println(e.getMessage());
		}
	}
	
	//Eliminar un libro, llamado desde libros_listado.xhtml
	public void eliminar(int libroID) {
		try {
			boolean flag = libroRepo.eliminar(libroID);
			if(flag) {
		       	this.cargarGeneros();
		       	Message.messageInfo("Libro eliminado");
	       }else {
	       		Message.messageError("No se pudo eliminar el libro");
	       }
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al eliminar el libro");
			System.out.println(e.getMessage());
		}
	}

	public void limpiarFormulario() {
		libro = new Libro();
	}
	
	/**/
	public void actualizar() {
		try {
			if (this.libroSeleccionado.getId() > 0) {
				libroSeleccionado.setEditorial(this.libroSeleccionado.getEditorial()); //setear al libro la editorial seleccionada
				libroSeleccionado.setGenero(this.libroSeleccionado.getGenero()); //setear al libro el genero seleccionado
				
				boolean flag = libroRepo.actualizar(libroSeleccionado);
				if(flag) {
					this.limpiarFormulario();
			       	Message.messageInfo("Libro actualizado");
				}else {
					Message.messageError("No se pudo actualizar el libro");
				}
			} else {
				Message.messageInfo("Debe seleccionar un  producto");
			}
		} catch (Exception e) {
			Message.messageError("Ocurrió un error al editar el libro");
			System.out.println(e.getMessage());
		}

	}
	
	/*public void onCellEdit(CellEditEvent event) {  
        Object oldValue = event.getOldValue();  
        Object newValue = event.getNewValue();  */
        /*if(!oldValue.equals(newValue)){
            // Save to the database
            DataTable table = (DataTable) event.getSource();
            Customer customer = (Customer) table.getRowData();
            ejbFacade.edit(customer);
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Successfully Updated", "Updated value to " + newValue));  
        }*/
    /*}*/
	
	/* Métodos Get y Set de las variables declaradas a nivel de la clase */
	public List<Editorial> getEditoriales() {
		return editoriales;
	}

	public void setEditoriales(List<Editorial> editoriales) {
		this.editoriales = editoriales;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public void setLibroSeleccionado(Libro libroSeleccionado) {
		this.libroSeleccionado = libroSeleccionado;
	}

	public Libro getLibroSeleccionado() {
		return libroSeleccionado;
	}
	
}