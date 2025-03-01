package org.example;

import biblioteca.Libro;
import biblioteca.Biblioteca;


public class Main {
    public static void main(String[] args) {
        Biblioteca biblio = new Biblioteca();

        Libro libro1 = new Libro("The Art of Computer Programming", "Donald Knuth", 1968);
        biblio.agregarLibro(libro1);
        System.out.println(libro1);

        Libro libro2 = new Libro("Clean Code", "Robert C. Martin ", 2009);
        biblio.agregarLibro(libro2);
        System.out.println(libro2);

        Libro libro3 = new Libro("Clean Arquitecture", "Robert C. Martin", 1968);
        System.out.println(biblio.agregarLibro(libro3));
        System.out.println(libro3);

        System.out.println(biblio.encuentaLibroPorAutor("Robert C. Martin"));
        System.out.println(biblio.encuentraLibrosPorAutor("Robert C. Martin"));

        System.out.println(biblio.getLibros());
        System.out.println(biblio.eliminarLibro(libro1));
        System.out.println(biblio.getLibros());

        System.out.println(biblio.encuentraLibroPorTitulo("Clean Code"));

        // Copia de la biblioteca
        Biblioteca biblio2 = new Biblioteca(biblio.getLibros());
        System.out.println(biblio2.getLibros());
    }
}