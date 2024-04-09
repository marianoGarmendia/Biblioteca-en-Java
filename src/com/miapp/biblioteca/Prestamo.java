package com.miapp.biblioteca;
import java.time.LocalDate;

public class Prestamo {

	private String usuarioPrestamo;
	private LocalDate fecha;
	private LocalDate fechaDevolucion;
	
	public Prestamo(String usuarioPrestamo, LocalDate fecha, int diasDePrestamo) {
		this.usuarioPrestamo = usuarioPrestamo;
		this.fecha = fecha;
		this.fechaDevolucion = fecha.plusDays(diasDePrestamo);
	}
	
	public Prestamo() {}
	
	public String getPrestamo(Libro libro) {
			if(!libro.getDisponible()) {
				return "Prestado a: "+ usuarioPrestamo +
						" - el dia: "+ fecha.toString() +
						" - Devolver el dia: "+ fechaDevolucion.toString();							
			}else {
				return "Sin info de préstamo";
			}
		
	}
	

}
