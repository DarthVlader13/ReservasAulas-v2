package org.iesalandalus.programacion.reservasaulas.mvc.controlador;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.IModelo;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.mvc.vista.IVista;

public class Controlador implements IControlador {

	// DECLARACIÓN DE ATRIBUTOS
	private IModelo Imodelo;
	private IVista Ivista;

	// CREAMOS CONSTRUCTOR CON PARÁMETROS DE MODELO Y VISTA
	public Controlador(IModelo modelo, IVista vista) {
		if (modelo == null) {
			throw new IllegalArgumentException("ERROR: El modelo no puede ser nulo.");
		}
		if (vista == null) {
			throw new IllegalArgumentException("ERROR: La vista no puede ser nula.");
		}
		this.Imodelo = modelo;
		this.Ivista = vista;
		this.Ivista.setControlador(this);
	}

	// CREAMOS MÉTODO COMENZAR
	public void comenzar() {
		Ivista.comenzar();
	}

	// CREAMOS MÉTODO TERMINAR
	public void terminar() {
		System.exit(0);
	}

	// CREAMOS MÉTODO INSERTARAULA
	public void insertarAula(Aula aula) throws OperationNotSupportedException {
		Imodelo.insertarAula(aula);
	}

	// CREAMOS MÉTODO INSERTARPROFESOR
	public void insertarProfesor(Profesor profesor) throws OperationNotSupportedException {
		Imodelo.insertarProfesor(profesor);
	}

	// CREAMOS MÉTODO BORRARAULA
	public void borrarAula(Aula aula) throws OperationNotSupportedException {
		Imodelo.borrarAula(aula);
	}

	// CREAMOS MÉTODO BORRARPROFESOR
	public void borrarProfesor(Profesor profesor) throws OperationNotSupportedException {
		Imodelo.borrarProfesor(profesor);
	}

	// CREAMOS MÉTODO BUSCARAAULA
	public Aula buscarAula(Aula aula) {
		Aula aulaBuscada = Imodelo.buscarAula(aula);
		return aulaBuscada;
	}

	// CREAMOS MÉTODO BUSCARPROFESOR
	public Profesor buscarProfesor(Profesor profesor) {
		Profesor profesorBuscado = Imodelo.buscarProfesor(profesor);
		return profesorBuscado;
	}

	// CREAMOS MÉTODO REPRESENTARAULAS
	public List<String> representarAulas() {
		List<String> listaAulas = Imodelo.representarAulas();
		return listaAulas;
	}

	// CREAMOS MÉTODO REPRESENTARPROFESOR
	public List<String> representarProfesores() {
		List<String> listaProfesores = Imodelo.representarProfesores();
		return listaProfesores;
	}

	// CREAMOS MÉTODO REPRESENTARRESERVA
	@Override
	public List<String> representarReservas() {
		List<String> listaReservas = Imodelo.representarReservas();
		return listaReservas;
	}

	// CREAMOS MÉTODO RALIZARRESERVA
	public void realizarReserva(Reserva reserva) throws OperationNotSupportedException {
		Imodelo.realizarReserva(reserva);
	}

	// CREAMOS MÉTODO ANULARRESERVA
	public void anularReserva(Reserva reserva) throws OperationNotSupportedException {
		Imodelo.anularReserva(reserva);
	}

	// CREAMOS MÉTODO RESERVASAURLA
	public List<Reserva> getReservasAula(Aula aula) {
		List<Reserva> reservasAula = Imodelo.getReservasAula(aula);
		return reservasAula;
	}

	// CREAMOS MÉTODO RESERVASPROFESOR
	public List<Reserva> getReservasProfesor(Profesor profesor) {
		List<Reserva> reservasProfesor = Imodelo.getReservasProfesor(profesor);
		return reservasProfesor;
	}

	// CREAMOS MÉTODO RESERVASPERMANENCIA
	public List<Reserva> getReservasPermanencia(Permanencia permanencia) {
		List<Reserva> reservasPermanencia = Imodelo.getReservasPermanencia(permanencia);
		return reservasPermanencia;
	}

	// CREAMOS MÉTODO CONSULTARDISPONIBILIDAD
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		boolean disponibilidad = Imodelo.consultarDisponibilidad(aula, permanencia);
		return disponibilidad;
	}

}
