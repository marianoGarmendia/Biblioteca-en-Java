package com.miapp.biblioteca.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.LibroServicios;
import com.miapp.biblioteca.service.UsuarioServicios;

public class Main {

	public static void main(String[] args) {
		
	ArrayList<Libro> biblioteca = new ArrayList<>(); 
	ArrayList<Usuario> usuarios = new ArrayList<>();
	LibroServicios libroServicio = new LibroServicios(biblioteca);
	UsuarioServicios usuarioServicio = new UsuarioServicios(usuarios);
	MenuPrincipal menuPrincipal = new MenuPrincipal();
	Scanner scanner = new Scanner(System.in);
	
	
	int opcion = 0;
	
	do {
		System.out.println(menuPrincipal.toString());
		opcion = scanner.nextInt();
	switch(opcion){
	case 1 :
		System.out.println("Ingrese el titulo del libro: \n");
		scanner.nextLine();
		String titulo = scanner.nextLine();
		System.out.println("Ingrese el autor: ");
		String autor = scanner.nextLine();
		System.out.println("Ingrese el ISBN: ");
		String ISBN = scanner.nextLine();
		System.out.println("Ingrese el género: ");
		String genero = scanner.nextLine();
		String messageLibroCreado = libroServicio.crearLibro(titulo, autor, ISBN, genero);
		System.out.println(messageLibroCreado);
		System.out.println("Para volver al menu presiona: 1 y luego ENTER");
		scanner.nextLine();	
		break;
	case 2:
		System.out.println("Ingrese el ISBN del libro a actualizar: ");
		scanner.nextLine();
		String isbn = scanner.nextLine();
		if(libroServicio.buscarLibroPorIsbn(isbn) == null) {
			System.out.println("No hay libro con ese ISBN");
			System.out.println("Para volver al menu presiona: 1 y luego ENTER");
			scanner.nextLine();	
		}else {
		System.out.println("Ingrese el nuevo titulo: ");
		String tituloActualizado = scanner.nextLine();
		System.out.println("Ingrese el nuevo autor: ");
		String autorActualizado = scanner.nextLine();
		System.out.println("Ingrese el nuevo género: ");
		String generoActualizado = scanner.nextLine();
		String messageLibroActualizado = libroServicio.actualizarLibro(tituloActualizado, autorActualizado, isbn, generoActualizado);
		System.out.println(messageLibroActualizado);
		System.out.println("Para volver al menu presiona: 1 y luego ENTER");
		scanner.nextLine();	}
		break;
	case 3:
		System.out.println("Ingrese el ISBN del libro a buscar: ");
		scanner.nextLine();
		String isbnAbuscar = scanner.nextLine();
		Libro libroPorISBN = libroServicio.buscarLibroPorIsbn(isbnAbuscar);
		if(libroPorISBN != null) {
			System.out.println("Libro encontrado: "+ libroPorISBN.getTitulo());
			System.out.println("Para volver al menu presiona: 1");
			scanner.nextLine();
		}else {
			System.out.println("Libro no encontrado");
			System.out.println("Para volver al menu presiona: 1");
			scanner.nextLine();
		}
		break;
	case 4:
		System.out.println("Ingrese el titulo del libro a buscar: ");
		scanner.nextLine();
		String tituloABuscar = scanner.nextLine();
		ArrayList<Libro> libroEncontrado = libroServicio.buscarLibroPorTitulo(tituloABuscar);
		if(libroEncontrado.isEmpty()) {
			System.out.println("No hay libros con ese titulo");
			System.out.println("Para volver al menu presiona: 1 y luego ENTER");
			scanner.nextLine();
			
		}else {
			System.out.println("Libro/s encontrado/s: ");
			for(Libro libro: libroEncontrado) {
				System.out.println(libro.toString(libro));
				System.out.println("Para volver al menu presiona: 1 y luego ENTER");
				scanner.nextLine();	
		    }
		}
		break;
	case 5:
		ArrayList<Libro> librosTotales = libroServicio.obtenerLibros();
		if(librosTotales.isEmpty()) {
			System.out.println("No hay ningun libro cargado");
			System.out.println("Para volver al menu presiona: 1 y luego ENTER");
			scanner.nextLine();	
		}else {
			for(Libro libro : librosTotales) {
				System.out.println(libroServicio.infoDelLibro(libro));
				
			}
			
		}
		System.out.println("Para volver al menu presiona: 1 y luego ENTER");
		scanner.nextLine();
		scanner.nextLine();
		
		break;
	case 6:
		System.out.println("Ingresa el ISBN del libro a eliminar");
		scanner.nextLine();
		String isbnAEliminar = scanner.nextLine();
		String messageLibroAEliminar = libroServicio.eliminarLibro(isbnAEliminar);
		System.out.println(messageLibroAEliminar);
		System.out.println("Para volver al menu presiona: 1 y luego ENTER");
		scanner.nextLine();
		break;
	case 7:
		System.out.println("Ingrese el id del usuario solicitante del prestamo: ");
		scanner.nextLine();
		String idUusarioPrestamo = scanner.nextLine();
		Usuario usuarioParaPrestamo = usuarioServicio.buscarUsuarioPorId(idUusarioPrestamo);
		if(usuarioParaPrestamo == null) {
			System.out.println("No hay usuarios con ese id");
			System.out.println("Para volver al menu presiona: 1 y luego ENTER");
			scanner.nextLine();
			break;
		}else {
			System.out.println("Ingrese el ISBN del libro a prestar: ");
			String isbnLibroAPrestar = scanner.nextLine();
			Libro libroAPrestar = libroServicio.buscarLibroPorIsbn(isbnLibroAPrestar);
			if(libroAPrestar != null) {
				String messagePrestamo = usuarioServicio.prestarLibro(usuarioParaPrestamo, libroAPrestar);
				System.out.println(messagePrestamo);
				System.out.println("Para volver al menu presiona: 1 y luego ENTER");
				scanner.nextLine();				
			}else {
				System.out.println("No hay un libro con ese ISBN");
				System.out.println("Para volver al menu presiona: 1 y luego ENTER");
				scanner.nextLine();
			}
		}
		break;
	case 8:
		System.out.println("Ingrese el id del usuario que solicito el prestamo: ");
		scanner.nextLine();
		String usuarioDevolucionId = scanner.nextLine();
		Usuario usuarioDevolucion = usuarioServicio.buscarUsuarioPorId(usuarioDevolucionId);
		if(usuarioDevolucion == null) {
			System.out.println("No hay usuarios con ese id");
			System.out.println("Para volver al menu presiona: 1 y luego ENTER");
			scanner.nextLine();
			break;
		}else {
			System.out.println("Ingrese ISBN del libro a devolver: ");
			String isbnDevolucion = scanner.nextLine(); 
			Libro libroDevolucion = libroServicio.buscarLibroPorIsbn(isbnDevolucion);
			if(libroDevolucion != null) {
				String messageDevolucion = usuarioServicio.devolverLibro(usuarioDevolucion, libroDevolucion);
				System.out.println(messageDevolucion);
				System.out.println("Para volver al menu presiona: 1 y luego ENTER");
				scanner.nextLine();
			}else {
				System.out.println("No hay un libro con ese ISBN");
				System.out.println("Para volver al menu presiona: 1 y luego ENTER");
				scanner.nextLine();
			}
		}
		break;
	case 9:
		System.out.println("Ingrese el nombre del Usuario a crear: ");
		scanner.nextLine();
		String nombreUsuarioNuevo = scanner.nextLine();
		System.out.println("Ingrese el id: ");
		String idNuevoUsuario = scanner.nextLine();
		String messageUsuarioCreado = usuarioServicio.crearUsuario(nombreUsuarioNuevo, idNuevoUsuario);
		System.out.println(messageUsuarioCreado);
		System.out.println("Para volver al menu presiona: 1 y luego ENTER");
		scanner.nextLine();
		break;	
	case 10:
		System.out.println("Ingrese el id del usuario a actualizar: ");
		scanner.nextLine();
		String idUusarioActualizar = scanner.nextLine();
		Usuario usuarioActualizar = usuarioServicio.buscarUsuarioPorId(idUusarioActualizar) ;
		if(usuarioActualizar != null) {
			System.out.println("Ingrese el nombre a actualizar: ");
			String nombreNuevo = scanner.nextLine();
			String messageActualizarUsuario = usuarioServicio.actualizarUsuario(nombreNuevo, idUusarioActualizar);
			System.out.println(messageActualizarUsuario);
			System.out.println("Para volver al menu presiona: 1 y luego ENTER");
			scanner.nextLine();
		}else {
			System.out.println("No hay usuarios con ese id");
			System.out.println("Para volver al menu presiona: 1 y luego ENTER");
			scanner.nextLine();
			break;
		}
		break;
	case 11:
		System.out.println("Ingrese el id del usuario a buscar: ");
		scanner.nextLine();
		String idUsuarioBuscar = scanner.nextLine();
		Usuario usuarioEncontrado = usuarioServicio.buscarUsuarioPorId(idUsuarioBuscar);
		if(usuarioEncontrado != null) {
			System.out.println( usuarioEncontrado.toString());
			System.out.println("Para volver al menu presiona: 1 y luego ENTER");
			scanner.nextLine();
		}else {
			System.out.println("No hay usuarios con ese id");
			System.out.println("Para volver al menu presiona: 1 y luego ENTER");
			scanner.nextLine();
		}
		break;
	case 12:
		System.out.println("Ingrese el id del usuario a eliminar");
		scanner.nextLine();
		String idUsuarioEliminar = scanner.nextLine();
		Usuario usuarioEliminar = usuarioServicio.buscarUsuarioPorId(idUsuarioEliminar);
		if(usuarioEliminar != null) {
			String messageEliminar = usuarioServicio.eliminarUsuario(idUsuarioEliminar);
			System.out.println(messageEliminar);
			System.out.println("Para volver al menu presiona: 1 y luego ENTER");
			scanner.nextLine();
		}else {
			System.out.println("No hay usuario con ese id");
			System.out.println("Para volver al menu presiona: 1 y luego ENTER");
			scanner.nextLine();
		}
		break;
	case 13:
		System.out.println("Ingrese id del usuario para consultar libros prestados: ");
		scanner.nextLine();
		String idUsuarioConsultaPrestamos = scanner.nextLine();
		Usuario usuarioConsultaPrestamo = usuarioServicio.buscarUsuarioPorId(idUsuarioConsultaPrestamos);
		if(usuarioConsultaPrestamo != null) {
			ArrayList<Libro> librosPrestados = usuarioServicio.obtenerLibrosPrestados(usuarioConsultaPrestamo);
			if(!librosPrestados.isEmpty()) {
				System.out.println("Libros prestados: ");
				for(Libro libro : librosPrestados) {
					System.out.println(libro.toString(libro));	
				}
				System.out.println("Para volver al menu presiona: 1 y luego ENTER");
				scanner.nextLine();
			}else {
				System.out.println("Este usuario no tiene préstamos");
				System.out.println("Para volver al menu presiona: 1 y luego ENTER");
				scanner.nextLine();
			}
		}else {
			System.out.println("No hay un usuario con ese id");
			System.out.println("Para volver al menu presiona: 1 y luego ENTER");
			scanner.nextLine();
		}
		break;
	case 14:
		System.out.println("Ingrese el id de usuario que hace la reseña: ");
		scanner.nextLine();
		String idUusarioResena = scanner.nextLine();
		Usuario usuarioReseña = usuarioServicio.buscarUsuarioPorId(idUusarioResena);
		if(usuarioReseña != null) {
			System.out.println("Ingrese el ISBN del libro para hacer la reseña: ");
			String isbnReseña = scanner.nextLine();
			Libro libroReseña =	libroServicio.buscarLibroPorIsbn(isbnReseña);
			if(libroReseña != null) {
				System.out.println("Escriba su reseña: ");
				String reseñaDelLibro = scanner.nextLine();
				String messageReseña = usuarioServicio.calificarLibro(usuarioReseña, libroReseña, reseñaDelLibro);
				System.out.println(messageReseña);
				System.out.println("Para volver al menu presiona: 1 y luego ENTER");
				scanner.nextLine();
			}else {
				System.out.println("No hay un libro con ese ISBN");
				System.out.println("Para volver al menu presiona: 1 y luego ENTER");
				scanner.nextLine();
			}
		}else {
			System.out.println("No hay un usuario con ese id");
			System.out.println("Para volver al menu presiona: 1 y luego ENTER");
			scanner.nextLine();
		}
		break;
	case 15:
		System.out.println("Ingrese el ISBN del libro para ver reseñas: ");
		scanner.nextLine();
		String isbnReseñas = scanner.nextLine();
		Libro reseñasLibro =	libroServicio.buscarLibroPorIsbn(isbnReseñas);
		if(reseñasLibro != null) {
			ArrayList<String> reseñasDelLibro =	libroServicio.obtenerReseñas(reseñasLibro);
			if(!reseñasDelLibro.isEmpty()) {
				System.out.println("Reseñas del libro: "+ reseñasLibro.getTitulo());
				for(String reseña : reseñasDelLibro) {
					System.out.println(reseña);
				}
				System.out.println("Para volver al menu presiona: 1 y luego ENTER");
				scanner.nextLine();
			}else {
				System.out.println("El libro: "+ reseñasLibro.getTitulo()+ " no tiene reseñas");
				System.out.println("Para volver al menu presiona: 1 y luego ENTER");
				scanner.nextLine();
			}
		}else {
			System.out.println("No hay un libro con ese ISBN");
			System.out.println("Para volver al menu presiona: 1 y luego ENTER");
			scanner.nextLine();
		}
		break;
	}
	
	
	}while(opcion != 16);
	
	
	scanner.close();
	}
	

}
