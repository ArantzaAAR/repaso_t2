package biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que permite agregar, eliminar y consultar libros.
 *
 * @see Libro
 * @version 2025.03.01
 * @author Arantza Alcazar
 */
public class Biblioteca {

    /** Lista de libros que hay en la biblioteca. */
    private final List<Libro> libros;

    /**
     * Constructor por defecto que inicializa la lista de libros.
     */
    public Biblioteca() {
        libros = new ArrayList<>();
    }

    /**
     * Constructor con parámetros.
     *
     * @param libros Lista inicial de libros para la biblioteca.
     */
    public Biblioteca(List<Libro> libros) {
        this.libros = libros;
    }

    /**
     * Agrega un libro a la biblioteca.
     *
     * @param libro El libro a agregar.
     * @return true si el libro se agregó con éxito, false en caso contrario.
     */
    public boolean agregarLibro(Libro libro) {
        return libros.add(libro);
    }

    /**
     * Elimina un libro de la biblioteca.
     *
     * @param libro El libro a eliminar.
     * @return true si el libro se eliminó con éxito, false si no se encontró.
     */
    public boolean eliminarLibro(Libro libro) {
        return libros.remove(libro);
    }

    /**
     * Obtiene la lista de libros disponibles en la biblioteca.
     *
     * @return Lista de libros en la biblioteca.
     */
    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * Busca un libro por su título.
     *
     * @param titulo El título del libro a buscar.
     * @return El libro encontrado o null si no existe.
     */
    public Libro encuentraLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }

    /**
     * Busca un libro por su autor.
     *
     * @param autor El nombre del autor del libro.
     * @return El primer libro encontrado del autor o null si no existe.
     * @deprecated Este método está obsoleto. Usar {@link #encuentraLibrosPorAutor(String)} en su lugar.
     */
    @Deprecated
    public Libro encuentaLibroPorAutor(String autor) {
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                return libro;
            }
        }
        return null;
    }

    /**
     * Busca todos los libros de un autor.
     *
     * @param autor El nombre del autor.
     * @return Una lista de libros del autor o null si no hay libros.
     * @since 2.0
     */
    public List<Libro> encuentraLibrosPorAutor(String autor) {
        List<Libro> listaLibros = null;
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                if (listaLibros == null) {
                    listaLibros = new ArrayList<>();
                }
                listaLibros.add(libro);
            }
        }
        return listaLibros;
    }
}
