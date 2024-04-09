package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Reseña;
import com.miapp.biblioteca.Usuario;

public class UsuarioServicios {

	private ArrayList<Usuario> usuarios;
	
	// Constructor
	public UsuarioServicios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	// ConstructorVacio
	public UsuarioServicios() {}
	
	public String crearUsuario(String nombre, String id) {
		Usuario usuarioEncontrado = this.buscarUsuarioPorId(id);
		if(usuarioEncontrado == null) {
			Usuario newUusario = new Usuario(nombre, id);
			usuarios.add(newUusario);
			return "Nuevo usuario creado";	
		}else {
			return "Ya hay un usuario con ese id";
		}
		
	}

	public ArrayList<Usuario> obtenerTodosLosUsuario(){
		return usuarios;
	}
	
	public String actualizarUsuario(String newNombre, String id) {
		for(Usuario usuario : usuarios) {
			if(usuario.getId().equals(id)) {
				usuario.setNombre(newNombre);
				return "Usuario actualizado correctamente";
			}
		}
		return "No se pudo actualizar";
	}
	
	public String eliminarUsuario(String id) {
		Iterator<Usuario> it = usuarios.iterator();
		while(it.hasNext()) {
			if(it.next().getId().equals(id)) {
				it.remove();
				return "Usuario eliminado correctamente";
			}
		}
		return "No se ha eliminado el usuario";
	}
	
	public String prestarLibro(Usuario usuario, Libro libro) {
			if(libro.getDisponible()) {
				usuario.setLibrosPrestados(libro);
				libro.setDisponible(false);
				return "Libro prestado a: "+ usuario.getNombre();
			}else {
				return "El libro no esta disponible para préstamo";
			}
		
	}
	
	public String calificarLibro(Usuario usuarioReseña, Libro libroReseña, String newReseña) {
		Reseña reseña = new Reseña(usuarioReseña, libroReseña,newReseña);
		
		libroReseña.setReseña(reseña.getReseña());
		return "Reseña agregada correctamente";
	}
	
	public Usuario buscarUsuarioPorId(String id) {
		for(Usuario usuario : usuarios) {
			if(usuario.getId().equals(id)) {
				return usuario;
			}
		}
		return null;
	}
	
	public String devolverLibro(Usuario usuario,	Libro libro) {
		ArrayList<Libro> librosPrestados = usuario.getLibrosPrestados();
		if(librosPrestados.contains(libro)) {
			librosPrestados.remove(libro);
			libro.setDisponible(true);	
			return "Libro devuelto correctamente";
		}else {
			
			return "Este libro no fue dado a préstamo a este usuario";
		}
	}
	
	
	
	public ArrayList<Libro> obtenerLibrosPrestados(Usuario usuario){
		return usuario.getLibrosPrestados();
	}
}
