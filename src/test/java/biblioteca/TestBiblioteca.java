package biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Pruebas mejoradas para la clase Biblioteca.
 */
public class TestBiblioteca {

    private Biblioteca biblioteca;
    private Libro libro1;

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
        libro1 = new Libro("El Quijote", "Miguel de Cervantes", 1605);
    }

    @Test
    void AgregarLibro() {
        assertTrue(biblioteca.agregarLibro(libro1));
        assertEquals(1, biblioteca.getLibros().size());
    }

    @Test
    void EliminarLibro() {
        biblioteca.agregarLibro(libro1);
        assertTrue(biblioteca.eliminarLibro(libro1));
        assertEquals(0, biblioteca.getLibros().size());
    }

    @Test
    void EliminarLibroNoExistente() {
        assertFalse(biblioteca.eliminarLibro(libro1));
    }

    @Test
    void EncuentraLibroPorTitulo() {
        biblioteca.agregarLibro(libro1);
        assertEquals(libro1, biblioteca.encuentraLibroPorTitulo("El Quijote"));
    }

    @Test
    void EncuentraLibroPorTituloNoExistente() {
        assertNull(biblioteca.encuentraLibroPorTitulo("Libro inexistente"));
    }

    @Test
    void EncuentraLibrosPorAutor() {
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(new Libro("Novelas Ejemplares", "Miguel de Cervantes", 1613));

        List<Libro> librosDeCervantes = biblioteca.encuentraLibrosPorAutor("Miguel de Cervantes");
        assertNotNull(librosDeCervantes);
        assertEquals(2, librosDeCervantes.size());
    }

    @Test
    void EncuentraLibrosPorAutorNoExistente() {
        List<Libro> libros = biblioteca.encuentraLibrosPorAutor("Autor Desconocido");
        assertNull(libros);
    }
}
