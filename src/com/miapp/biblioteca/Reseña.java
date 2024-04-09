package com.miapp.biblioteca;

public class Reseña {
	Usuario usuarioReseña;
	Libro libroReseña;
	String reseña;
	public Reseña (Usuario usuario, Libro libroReseña, String reseña) {
		this.usuarioReseña = usuario;
		this.libroReseña = libroReseña;
		this.reseña = reseña;
	}
	
	public String getReseña() {
		return "Reseña del usuario: "
				+ usuarioReseña.getNombre() + " id: "+ usuarioReseña.getId() 
				+ " Reseña: "+ reseña;
	}
}
