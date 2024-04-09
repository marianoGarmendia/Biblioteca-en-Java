package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Libro;

public class LibroServicios {

	private ArrayList<Libro> biblioteca;
	
	public LibroServicios(ArrayList<Libro> newBiblioteca) {
		this.biblioteca = newBiblioteca;
	}
	
	public LibroServicios() {}
	
	public String crearLibro(String titulo, String autor, String ISBN, String genero) {
		Libro libroPorIsbn = buscarLibroPorIsbn(ISBN);
		if(libroPorIsbn == null) {
			Libro newLibro = new Libro(titulo, autor,ISBN,genero);
			this.biblioteca.add(newLibro);
			return "Libro creado";
		}else {
			return "Ya hay un libro con ese ISBN";
		}
		}
	
	public ArrayList<Libro> obtenerLibros (){
		return biblioteca;
	}
	
	public String actualizarLibro (String titulo, String autor, String ISBN, String genero) {
		for(Libro libro : biblioteca) {
			if(libro.getISBN().equals(ISBN)) {
				libro.setAutor(autor);
				libro.setGenero(genero);
				libro.setTitulo(titulo);
			
			}else {
				return "No hay ningun libro con ese ISBN";
			}
		}
		return "Libro ISBN: "+ ISBN + " actualizado";
	}

	public String eliminarLibro(String ISBN) {
		if(biblioteca.isEmpty()) {
			return "La biblioteca esta vacia";
		}
		Iterator<Libro> it = biblioteca.iterator();
		while(it.hasNext()) {
			if(it.next().getISBN().equals(ISBN)) {
				it.remove();
				return "Libro de ISBN: "+ ISBN +" eliminado correctamente";
			}
		}
		return "No hay un libro con ese ISBN";
	}
	
	public Libro buscarLibroPorIsbn(String ISBN) {
		for(Libro libro : biblioteca) {
			if(libro.getISBN().equals(ISBN)) {
				return libro;
			}
		}
		return null;
	}
	
	public ArrayList<Libro> buscarLibroPorTitulo(String titulo){
		ArrayList<Libro> librosEncontrados = new ArrayList<>();
		for(Libro libro : biblioteca) {
			if(libro.getTitulo().equalsIgnoreCase(titulo)) {
				librosEncontrados.add(libro);
			}
		}
		return librosEncontrados;
	}
	
	public String infoDelLibro(Libro libro) {
		return libro.toString(libro);
	}
	
	public ArrayList<String> obtenerReseñas(Libro libro){
		return libro.getReseña();
	}
	
	public Boolean estaDisponible(Libro libro) {
		return libro.getDisponible();
		
	}
	
}
