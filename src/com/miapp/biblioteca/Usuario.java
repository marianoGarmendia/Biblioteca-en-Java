package com.miapp.biblioteca;

import java.util.ArrayList;

public class Usuario {
	
	  	private String nombre;
	    private String id;
	    private ArrayList<Libro> librosPrestados;
	    
	    
	    
	    // Constructor
	    public Usuario(String nombre, String id) {
	        this.nombre = nombre;
	        this.id = id;
	        this.librosPrestados = new ArrayList<>();
	        
	    }
	    
	    // ConstructorVacio
	    public Usuario() {
	    	
	    }
	    
	    public static void main(String[] args) {
			// TODO Auto-generated method stub

		}
	    
	    public String getNombre() {
	    	return nombre;
	    }
	    
	    public void setNombre( String newNombre) {
	    	nombre = newNombre;
	    }
	    
	    public String getId () {
	    	return id;
	    }
	    
	    public void setId ( String newId) {
	     id = newId;
	    }
	    
	    public ArrayList<Libro> getLibrosPrestados(){
	    	return librosPrestados;
	    }
	    
	    public void setLibrosPrestados(Libro newLibro) {
	    	this.librosPrestados.add(newLibro);
	    }
	    
	    
	    
	    @Override
	    public String toString() {
	    	return "Usuario: "+ nombre + "- id: "+ id + "-"
	    			;
	    }

}
