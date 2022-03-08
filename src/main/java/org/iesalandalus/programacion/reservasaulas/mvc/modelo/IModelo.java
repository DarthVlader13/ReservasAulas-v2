package org.iesalandalus.programacion.reservasaulas.mvc.modelo;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;

public interface IModelo {

	// MÉTODO GETAULAS LIST
	List<Aula> getAulas();

	// MÉTODO GETNUMAULAS
	int getNumAulas();

	// MÉTODO REPRESENTARAULAS LIST
	List<String> representarAulas();

	// MÉTODO BUSCARAULA
	Aula buscarAula(Aula aula);

	// MÉTODO INSERTARAULA 
	void insertarAula(Aula aula) throws OperationNotSupportedException;

	// MÉTODO BORRARAULA
	void borrarAula(Aula aula) throws OperationNotSupportedException;

	// MÉTODO GETPROFESORES LIST
	List<Profesor> getProfesores();

	// MÉTODO GETNUMPROFESORES
	int getNumProfesores();

	// MÉTODO REPRESENTARPROFESORES
	List<String> representarProfesores();

	// MÉTODO BORRARPROFESOR
	Profesor buscarProfesor(Profesor profesor);

	// MÉTODO INSERTARPROFESOR
	void insertarProfesor(Profesor profesor) throws OperationNotSupportedException;

	// MÉTODO BORRARPROFESOR
	void borrarProfesor(Profesor profesor) throws OperationNotSupportedException;

	// MÉTODO GETRESERVAS LIST
	List<Reserva> getReservas();

	// MÉTODO GETNUMRESERVAS
	int getNumReservas();

	// MÉTODO REPRESENTARRESERVAS
	List<String> representarReservas();

	// MÉTODO BUSCARRESERVA
	Reserva buscarReserva(Reserva reserva);

	// MÉTODO REALIZARRESERVA
	void realizarReserva(Reserva reserva) throws OperationNotSupportedException;

	// MÉTODO ANULARRESERVA
	void anularReserva(Reserva reserva) throws OperationNotSupportedException;

	// MÉTODO GETRESERVASPROFESOR LIST
	List<Reserva> getReservasProfesor(Profesor profesor);

	// MÉTODO GERRESERVASAULA LIST
	List<Reserva> getReservasAula(Aula aula);

	// MÉTODO GETRESERVASPERMANENCIA LIST
	List<Reserva> getReservasPermanencia(Permanencia permanencia);

	// MÉTODO CONSULTARDISPONIBILIDAD
	boolean consultarDisponibilidad(Aula aula, Permanencia permanencia);

}
