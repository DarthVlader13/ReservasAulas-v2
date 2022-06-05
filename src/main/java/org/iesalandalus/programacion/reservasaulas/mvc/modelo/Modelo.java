package org.iesalandalus.programacion.reservasaulas.mvc.modelo;

import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.IAulas;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.IProfesores;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.IReservas;

public class Modelo implements IModelo {

	// DECLARACIÓN DE ATRIBUTOS
	private IProfesores profesores;
	private IAulas aulas;
	private IReservas reservas;

	// CREAMOS EL CONSTRUCTOR QUE NOS CREA LOS OBJETOS ANTERIORES CON LA CAPACIDAD
	// REQUERIDA
	public Modelo() {
		aulas = FactoriaFuenteDatos.MEMORIA.crear().crearAulas();
		profesores = FactoriaFuenteDatos.MEMORIA.crear().crearProfesores();
		reservas = FactoriaFuenteDatos.MEMORIA.crear().crearReservas();
	}

	// CREAMOS MÉTODO GETAULAS Y NUMAULAS
	public List<Aula> getAulas(){
		return aulas.getAulas();
	}
		
	public int getNumAulas() {
		return aulas.getNumAulas();
	}

	// CREAMOS MÉTODO REPRESENTARAULAS
	public List<String> representarAulas() {
		List<String> listaAulas = aulas.representar();
		boolean vacio = true;
//		for(String s:listaAulas) {
//			if(s!=null) {
//				vacio=false;
//			}
//		}
//		if(vacio==true) {
//			return null;
//		}
		Iterator<String> iterador = listaAulas.iterator();
		while (iterador.hasNext()) {
			String auxiliar = iterador.next();
			if (auxiliar != null) {
				vacio = false;
			}
		}
		if (vacio == true) {
			return null;
		}
		return listaAulas;
	}

	// CREAMOS MÉTODO BUSCARAULA
	public Aula buscarAula(Aula aula) {
		Aula aulaEncontrada = aulas.buscar(aula);
		if (aulaEncontrada == null) {
			return null;
		} else {
			return new Aula(aulaEncontrada);
		}
	}

	// CREAMOS MÉTODO INSERTARAULA
	public void insertarAula(Aula aula) throws OperationNotSupportedException {
		aulas.insertar(aula);
	}

	// CREAMOS MÉTODO BORRARAULA
	public void borrarAula(Aula aula) throws OperationNotSupportedException {
		aulas.borrar(aula);
	}


	// GENERAMOS GETTER PROFESORES Y NUMPROFESORES
	public List<Profesor> getProfesores() {
		return profesores.getProfesores();
	}

	public int getNumProfesores() {
		return profesores.getNumProfesores();
	}
	// CREAMOS MÉTODO REPRESENTARPROFESORES
	public List<String> representarProfesores() {
		List<String> listaProfesores = profesores.representar();
		boolean vacio = true;
		Iterator<String> iterador = listaProfesores.iterator();
		while (iterador.hasNext()) {
			String auxiliar = iterador.next();
			if (auxiliar != null) {
				vacio = false;
			}
		}
		if (vacio == true) {
			return null;
		}
		return listaProfesores;
	}

	// CREAMOS MÉTODO BUSCARPROFESOR
	public Profesor buscarProfesor(Profesor profesor) {
		Profesor profesorEncontrado = profesores.buscar(profesor);
		if (profesorEncontrado == null) {
			return null;
		}
		return new Profesor(profesorEncontrado);
	}

	// CREAMOS MÉTODO INSERTARPROFESOR
	public void insertarProfesor(Profesor profesor) throws OperationNotSupportedException {
		profesores.insertar(profesor);
	}

	// CREAMOS MÉTODO BORRARPROFESOR
	public void borrarProfesor(Profesor profesor) throws OperationNotSupportedException {
		profesores.borrar(profesor);
	}

	// GENERAMOS GETTERS RESERVAS Y NUMRESERVAS
	public List<Reserva> getReservas() {
		return reservas.getReservas();
	}
	
	public int getNumReservas() {
		return reservas.getNumReservas();
	}
	

	// CREAMOS MÉTODO REPRESENTARRESERVAS
	@Override
	public List<String> representarReservas() {
		List<String> listaReservas=reservas.representar();
		boolean vacio=true;
		Iterator<String> iterador=listaReservas.iterator();
		while (iterador.hasNext()) {
			String auxiliar=iterador.next();
			if(auxiliar!=null) {
				vacio=false;
			}		
		}
		if(vacio==true) {
			return null;
		}
		return listaReservas;
	}

	// CREAMOS MÉTODO BUSCARRESERVA
	public Reserva buscarReserva(Reserva reserva) {
		Reserva reservaEncontrada = reservas.buscar(reserva);
		if (reservaEncontrada == null) {
			return null;
		}
		return new Reserva(reservaEncontrada);
	}

	// CREAMOS MÉTODO REALIZARRESERVA
	public void realizarReserva(Reserva reserva) throws OperationNotSupportedException {
		reservas.insertar(reserva);
	}

	// CREAMOS MÉTODO ANULARRESERVA
	public void anularReserva(Reserva reserva) throws OperationNotSupportedException {
		reservas.borrar(reserva);
	}

	// CREAMOS MÉTODO RESERVAPROFESOR
	public List<Reserva> getReservasProfesor(Profesor profesor) {
		List<Reserva> reservasProfesor = reservas.getReservasProfesor(profesor);
		boolean vacio = true;
		Iterator<Reserva> iterador = reservasProfesor.iterator();
		while (iterador.hasNext()) {
			Reserva auxiliar = iterador.next();
			if (auxiliar != null) {
				vacio = false;
			}
		}
		if (vacio == true) {
			return null;
		}
		return reservasProfesor;
	}

	// CREAMOS MÉTODO RESERVAAULA
	public List<Reserva> getReservasAula(Aula aula) {
		List<Reserva> reservasAula = reservas.getReservasAula(aula);
		boolean vacio = true;
		Iterator<Reserva> iterador = reservasAula.iterator();
		while (iterador.hasNext()) {
			Reserva auxiliar = iterador.next();
			if (auxiliar != null) {
				vacio = false;
			}
		}
		if (vacio == true) {
			return null;
		}
		return reservasAula;
	}

	// CREAMOS MÉTODO RESERVAPERMANENCIA
	public List<Reserva> getReservasPermanencia(Permanencia permanencia) {
		List<Reserva> reservasPermanencia = reservas.getReservasPermanencia(permanencia);
		boolean vacio = true;
		Iterator<Reserva> iterador = reservasPermanencia.iterator();
		while (iterador.hasNext()) {
			Reserva auxiliar = iterador.next();
			if (auxiliar != null) {
				vacio = false;
			}
		}
		if (vacio == true) {
			return null;
		}
		return reservasPermanencia;
	}

	// CREAMOS MÉTODO CONSULTARDISPONIBILIDAD
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		return reservas.consultarDisponibilidad(aula, permanencia);
	}
}
