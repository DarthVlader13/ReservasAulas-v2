package org.iesalandalus.programacion.reservasaulas.mvc.vista;

import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.controlador.IControlador;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;

public class Vista implements IVista {

	private final static String ERROR = "No existen reservas para el parámetro proporcionado";
	private final static String NOMBRE_VALIDO = "Manolo";
	private final static String CORREO_VALIDO = "manolo@eldelbombo.com";
	private IControlador controlador;

	// DECLARACIÓN DE ATRIBUTOS
	IControlador Icontrolador;

	// CREAMOS CONSTRUCTOR DEFAULT
	public Vista() {
		Opcion.setVista(this);
	}

	// CREAMOS MÉTODO SETCONTROLADOR
	@Override
	public void setControlador(IControlador controlador) {
		this.Icontrolador = controlador;
	}

	// CREAMOS MÉTODO COMENZAR
	public void comenzar() {
		int ordinalOpcion = 0;
		do {
			try {
				Consola.mostrarMenu();
				ordinalOpcion = Consola.elegirOpcion();
				Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
				opcion.ejecutar();
			} catch (NullPointerException | IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} while (ordinalOpcion != Opcion.SALIR.ordinal());
	}

	// CREAMOS MÉTODO SALIR
	public void salir() {
		System.out.println("¡Hasta la próxima!");
		Icontrolador.terminar();
	}

	// CREAMOS MÉTODO INSERTARAULA
	public void insertarAula() {
		try {
			Icontrolador.insertarAula(Consola.leerAula());
			System.out.println("Aula insertada correctamente.");
		} catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}

	}

	// CREAMOS MÉTODO BORRAR AULA
	public void borrarAula() {
		List<String> listaAulas = Icontrolador.representarAulas();
		if (listaAulas == null) {
			System.out.println("No existen aulas que borrar");
		} else {
			try {
				Icontrolador.borrarAula(Consola.leerAulaFicticia());
				System.out.println("Aula borrada correctamente.");
			} catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// CREAMOS MÉTODO BUSCARAULA
	public void buscarAula() {
		Aula aula = null;
		List<String> listaAulas = Icontrolador.representarAulas();
		if (listaAulas == null) {
			System.out.println("No existen aulas que buscar");
		} else {
			try {
				aula = Icontrolador.buscarAula(Consola.leerAulaFicticia());
			} catch (NullPointerException | IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			if (aula == null) {
				System.out.println("El aula buscada no existe");
			} else {
				System.out.println(aula.toString());
			}
		}
	}

	// CREAMOS MÉTODO LISTARAULA
	public void listarAulas() {
		List<String> listaAulas = null;
		try {
			listaAulas = Icontrolador.representarAulas();
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		if (listaAulas == null) {
			System.out.println("No hay aulas que mostrar");
		} else {
			Iterator<String> iterador = listaAulas.iterator();
			while (iterador.hasNext()) {
				System.out.println(iterador.next().toString());
			}
		}
	}

	// CREAMOS MÉTODO INSERTARPROFESOR
	public void insertarProfesor() {
		try {
			Icontrolador.insertarProfesor(Consola.leerProfesor());
			System.out.println("Profesor insertado correctamente.");
		} catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	// CREAMOS MÉTODO BORRARPROFESOR
	public void borrarProfesor() {
		List<String> listaProfesores = Icontrolador.representarProfesores();
		if (listaProfesores == null) {
			System.out.println("No existen profesores que borrar");
		} else {
			try {
				Profesor profesorABorrar = new Profesor(Consola.leerProfesorFicticio());
				Icontrolador.borrarProfesor(profesorABorrar);
				System.out.println("Profesor borrado correctamente.");
			} catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// CREAMOS MÉTODO BUSCARPROFESOR
	public void buscarProfesor() {
		Profesor profesor = null;
		List<String> listaProfesores = Icontrolador.representarProfesores();
		if (listaProfesores == null) {
			System.out.println("No existen profesores que buscar");
		} else {
			try {
				Profesor profesorABuscar = new Profesor(Consola.leerProfesorFicticio());
				profesor = Icontrolador.buscarProfesor(profesorABuscar);
			} catch (NullPointerException | IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			if (profesor == null) {
				System.out.println("El profesor buscado no existe");
			} else {
				System.out.println(profesor.toString());
			}
		}
	}

	// CREAMOS MÉTODO LISTARPROFESOR
	public void listarProfesores() {
		List<String> listaProfesores = null;
		try {
			listaProfesores = Icontrolador.representarProfesores();
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		if (listaProfesores == null) {
			System.out.println("No hay profesores que mostrar");
		} else {
			Iterator<String> iterador = listaProfesores.iterator();
			while (iterador.hasNext()) {
				System.out.println(iterador.next().toString());
			}
		}
	}

	// CREAMOS MÉTODO REALIZARRESERVA
	public void realizarReserva() {
		Reserva reservaARealizar = null;
		try {
			reservaARealizar = Consola.leerReserva();
			if (Icontrolador.buscarProfesor(reservaARealizar.getProfesor()) == null) {
				System.out.println(
						"ERROR: El profesor introducido no existe. Por favor, creélo antes de intentar realizar una reserva con él.");
			} else if (Icontrolador.buscarAula(reservaARealizar.getAula()) == null) {
				System.out.println(
						"ERROR: El aula introducida no existe. Por favor, creéla antes de intentar realizar una reserva con ella.");
			} else {
				Profesor profesor = new Profesor(Icontrolador.buscarProfesor(reservaARealizar.getProfesor()));
				Aula aula = new Aula(Icontrolador.buscarAula(reservaARealizar.getAula()));
				Reserva reservaFinal = new Reserva(profesor, aula, reservaARealizar.getPermanencia());
				Icontrolador.realizarReserva(reservaFinal);
				System.out.println("Reserva realizada correctamente.");

			}
		} catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	
	// CREAMOS MÉTODO ANULAR RESERVA
	public void anularReserva() {
		Reserva reserva = null;
		List<String> listaReservas = Icontrolador.representarReservas();
		if (listaReservas == null) {
			System.out.println("No existen reservas que borrar");
		} else {
			try {
				reserva = Consola.leerReservaFicticia();
				Icontrolador.anularReserva(reserva);
				System.out.println("Reserva anulada correctamente.");
			} catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// CREAMOS MÉTODO LISTAR RESERVAS
	public void listarReservas() {
		Consola.mostrarCabecera("Listado de reservas existentes: ");
		List<String> representar = controlador.representarReservas();

		if (representar.size() == 0) {
			System.out.println("No hay reservas existentes.");
		} else {
			Iterator<String> iterador = representar.iterator();

			while (iterador.hasNext()) {
				System.out.println(iterador.next());
			}
		}
	}
	
	// CREAMOS MÉTODO LISTARRESERVASAULA
	public void listarReservasAula() {
		Consola.mostrarCabecera("Listar reservas aula");
		Aula aula = Consola.leerAula();
		List<Reserva> reservasAulas = Icontrolador.getReservasAula(aula);
		if (reservasAulas.size() != 0) {
			for (Reserva reservaAula : reservasAulas) {
				System.out.println(reservaAula);
			}
		} else {
			System.out.println(aula.getNombre() + " no tiene ninguna reserva a su nombre.");
		}
	}

	// CREAMOS MÉTODO LISTARRESERVASPROFESOR
	public void listarReservasProfesor() {
		Consola.mostrarCabecera("Listar reservas profesor");
		Profesor profesor = Consola.leerProfesor();
		List<Reserva> reservasProfesor = Icontrolador.getReservasProfesor(profesor);
		if (reservasProfesor.size() != 0) {
			for (Reserva reservaProfesor : reservasProfesor) {
				System.out.println(reservaProfesor);
			}
		} else {
			System.out.println(profesor.getNombre() + " no tiene ninguna reserva a su nombre.");
		}
	}

	// CREAMOS MÉTODO CONSULTARDISPONIBILIDAD
	public void consultarDisponibilidad() {
		Consola.mostrarCabecera("Consultar disponibilidad");
		boolean disponibilidad = true;
		Permanencia permanencia = null;
		Aula aula = null;
		try {
			permanencia = Consola.leerPermanencia();
			aula = Consola.leerAulaFicticia();
			disponibilidad = Icontrolador.consultarDisponibilidad(aula, permanencia);
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		if (Icontrolador.buscarAula(aula) == null) {
			System.out.println("El aula introducida no existe");
		} 
		else if (disponibilidad == true) {
			System.out.println("El aula se encuentra disponible para la permanencia y día introducidos.");
		} else {
			System.out.println("El aula no se encuentra disponible para la permanencia y día introducidos.");
		}
	}

}
