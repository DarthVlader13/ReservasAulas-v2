package org.iesalandalus.programacion.reservasaulas.mvc.controlador;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;

public interface IControlador {

	// MÉTODO COMENZAR
	void comenzar();

	// MÉTODO TERMINAR
	void terminar();

	// MÉTODO INSERTARAULA
	void insertarAula(Aula aula) throws OperationNotSupportedException;

	// MÉTODO INSERTARPROFESOR
	void insertarProfesor(Profesor profesor) throws OperationNotSupportedException;

	// MÉTODO BORRARAULA
	void borrarAula(Aula aula) throws OperationNotSupportedException;

	// MÉTODO BORRARPROFESOR
	void borrarProfesor(Profesor profesor) throws OperationNotSupportedException;

	// MÉTODO BUSCARAULA
	Aula buscarAula(Aula aula);

	// MÉTODO BUSCARPROFESOR
	Profesor buscarProfesor(Profesor profesor);

	// MÉTODO REPRESENTARAULAS LIST
	List<String> representarAulas();

	// MÉTODO REPRESENTARPROFESORES LIST
	List<String> representarProfesores();

	// MÉTODO REPRESENTARRESERVAS LIST
	List<String> representarReservas();

	// MÉTODO REALIZARRESERVAS
	void realizarReserva(Reserva reserva) throws OperationNotSupportedException;

	// MÉTODO ANULARRESERVAS
	void anularReserva(Reserva reserva) throws OperationNotSupportedException;

	// MÉTODO GETRESERVASPROFESOR LIST
	List<Reserva> getReservasProfesor(Profesor profesor);

	// MÉTODO GETRESERVASAULA LIST
	List<Reserva> getReservasAula(Aula aula);

	// MÉTODO GETRESERVASPERMANENCIA LIST
	List<Reserva> getReservasPermanencia(Permanencia permanencia);

	// MÉTODO CONSULTARDISPONIBILIDAD
	boolean consultarDisponibilidad(Aula aula, Permanencia permanencia);

}
