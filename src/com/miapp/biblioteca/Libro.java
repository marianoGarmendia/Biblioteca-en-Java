package com.miapp.biblioteca;

import java.util.ArrayList;

public class Libro {
	private String titulo;
    private String autor;
    private String ISBN;
    private String genero;
    private ArrayList<String> reseña;
    private boolean disponible;
    
    // Constructor
    public Libro(String titulo, String autor, String ISBN, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.genero = genero;
        this.reseña = new ArrayList<>();
        this.disponible = true;
    }
    
    // ConstructorVacio
    public Libro() {}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String newTitulo) {
		this.titulo = newTitulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String newAutor) {
		this.autor = newAutor;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public void setISBN(String newISBN) {
		this.ISBN = newISBN;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String newGenero) {
		this.genero = newGenero;
	}
	
	public ArrayList<String> getReseña() {
		return reseña;
	}
	
	public void setReseña(String newReseña) {
		reseña.add(newReseña);
	}
	
	public Boolean getDisponible() {
		return disponible;
	}
	
	public void setDisponible(Boolean newDisponible) {
		this.disponible = newDisponible;
	}
	
	public String toString(Libro libro) {
		return "Libro [ Titulo: "+ libro.getTitulo() + " - Autor: " + libro.getAutor() 
				+ " - ISBN: "+ libro.getISBN() + " - Género: "+ libro.getGenero() 
				+ " - Disponible: "+ libro.getDisponible() + " - Reseñas: "+libro.getReseña();
	}
}
