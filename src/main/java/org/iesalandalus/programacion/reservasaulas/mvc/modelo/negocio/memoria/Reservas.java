package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.memoria;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.IReservas;

public class Reservas implements IReservas {

	// DECLARACIÓN DE ATRIBUTOS
	private List<Reserva> coleccionReservas;
	
	//CREAMOS MÉTODO GETRESERVAS
	public List<Reserva> getReservas() {
		return copiaProfundaReservas(coleccionReservas);
	}
	
	//CREAMOS CONSTRUCTOR VACIO
	public Reservas() {
		coleccionReservas = new ArrayList<>();
	}


	// CREAMOS CONSTRUCTOR COPIA
	public Reservas(Reservas r) {
		if (r == null) {
			throw new NullPointerException("ERROR: No se pueden copiar reservas nulas.");
		}
		setReservas(r);
	}

	// CREAMOS MÉTODO SETAULAS
	private void setReservas(Reservas reservas) {
		if (reservas == null) {
			throw new NullPointerException("ERROR: No se puede copiar una reserva nula.");
		}
		this.coleccionReservas = reservas.getReservas();
	}
	
	// CREAMOS MÉTODO GETNUMRESERVAS
	public int getNumReservas() {
		return coleccionReservas.size();
	}
	
	// CREAMOS MÉTODO COPIAPROFUNDA DEL ARRAYLIST
	private List<Reserva> copiaProfundaReservas(List<Reserva> listaReservas) {
		List<Reserva> copiaProfunda = new ArrayList<>();
		Iterator<Reserva> iterador = listaReservas.iterator();
		while (iterador.hasNext()) {
			copiaProfunda.add(new Reserva(iterador.next()));
		}
		return copiaProfunda;
	}

	// CREAMOS MÉTODO INSERTAR
	public void insertar(Reserva reserva) throws OperationNotSupportedException {
		if (reserva == null) {
			throw new NullPointerException("ERROR: No se puede realizar una reserva nula.");
		} else if (buscar(reserva) == null) {
			coleccionReservas.add(new Reserva(reserva));
		} else {
			throw new OperationNotSupportedException("ERROR: La reserva ya existe.");
		}
	}


	// CREAMOS MÉTODO BUSCAR
	public Reserva buscar(Reserva reserva) {
		if (reserva == null) {
			throw new NullPointerException("ERROR: No se puede buscar un reserva nula.");
		}
		Reserva reservaEncontrada = null;
		int indice = coleccionReservas.indexOf(reserva);
		if (indice == -1) {
			reservaEncontrada = null;
		} else {
			reservaEncontrada = new Reserva(coleccionReservas.get(indice));
		}
		return reservaEncontrada;
	}

	// CREAMOS MÉTODO BORRAR
	public void borrar(Reserva reserva) throws OperationNotSupportedException {
		if (reserva == null) {
			throw new NullPointerException("ERROR: No se puede anular una reserva nula.");
		} else if (buscar(reserva) == null) {
			throw new OperationNotSupportedException("ERROR: La reserva a anular no existe.");
		} else {
			coleccionReservas.remove(coleccionReservas.indexOf(reserva));
		}
	}

	// CREAMOS MÉTODO REPRESENTAR
	public List<String> representar() {
		List<String> representacion = new ArrayList<>();
		Iterator<Reserva> iterador = coleccionReservas.iterator();
		while (iterador.hasNext()) {
			representacion.add(iterador.next().toString());
		}
		return representacion;
	}
	// CREAMOS MÉTODO GETRESERVASPROFESOR
	public List<Reserva> getReservasProfesor(Profesor profesor) {
		if (profesor == null) {
			throw new NullPointerException("ERROR: No se puede anula una reserva nula.");
		}
		List<Reserva> listaProfesor = new ArrayList<>();
		Iterator<Reserva> iterador = coleccionReservas.iterator();
		while (iterador.hasNext()) {
			Reserva auxiliar = iterador.next();
			if (profesor.equals(auxiliar.getProfesor())) {
				listaProfesor.add(new Reserva(auxiliar));
			}
		}
		return listaProfesor;
	}

	// CREAMOS MÉTODO GETRESERVASAULA
	public List<Reserva> getReservasAula(Aula aula) {
		if (aula == null) {
			throw new NullPointerException("ERROR: No se puede anula una reserva nula.");
		}
		List<Reserva> listaAula = new ArrayList<>();
		Iterator<Reserva> iterador = coleccionReservas.iterator();
		while (iterador.hasNext()) {
			Reserva auxiliar = iterador.next();
			if (aula.equals(auxiliar.getAula())) {
				listaAula.add(new Reserva(auxiliar));
			}
		}
		return listaAula;
	}

	// CREAMOS MÉTODO GETRESERVASPERMANENCIA
	public List<Reserva> getReservasPermanencia(Permanencia permanencia) {
		if (permanencia == null) {
			throw new NullPointerException("ERROR: No se puede anula una reserva nula.");
		}
		List<Reserva> listaPermanencia = new ArrayList<>();
		Iterator<Reserva> iterador = coleccionReservas.iterator();
		while (iterador.hasNext()) {
			Reserva auxiliar = iterador.next();
			if (permanencia.equals(auxiliar.getPermanencia())) {
				listaPermanencia.add(new Reserva(auxiliar));
			}
		}
		return listaPermanencia;
	}

	// CREAMOS MÉTODO CONSULTARDISPONIBILIDAD
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		if (aula == null) {
			throw new NullPointerException("ERROR: No se puede consultar la disponibilidad de un aula nula.");
		} else if (permanencia == null) {
			throw new NullPointerException("ERROR: No se puede consultar la disponibilidad de una permanencia nula.");
		}
		boolean disponible = true;
		Iterator<Reserva> iterador = coleccionReservas.iterator();
		while (iterador.hasNext()) {
			Reserva auxiliar = iterador.next();
			if (permanencia.equals(auxiliar.getPermanencia()) && aula.equals(auxiliar.getAula())) {
				disponible = false;
			}
		}
		return disponible;
	}
	
	//CREAMOS MÉTODO ESMESSIGUIENTEOPOSTERIOR
	private boolean esMesSiguienteOPosterior(Reserva reserva) {
		if (reserva == null) {
			throw new NullPointerException("ERROR: La reserva no puede ser nula");
		}
		boolean mesSiguiente = false;
		Month mes = reserva.getPermanencia().getDia().getMonth();
		Month mesActual = LocalDate.now().getMonth();
		if (mes.getValue() > mesActual.getValue()) {
			mesSiguiente = true;
		}
		return mesSiguiente;
	}
	
	
	//CREAMOS MÉTODO GETRESERVASPROFESORMES
	private List<Reserva> getReservasProfesorMes(Profesor profesor, LocalDate fecha) {
		if (profesor == null) {
			throw new NullPointerException("ERROR: El profesor no puede ser nulo");
		} else if (fecha == null) {
			throw new NullPointerException("ERROR: La fecha no puede ser nula");
		}
		List<Reserva> reservasMes = new ArrayList<>();
		Iterator<Reserva> iterador = coleccionReservas.iterator();
		while (iterador.hasNext()) {
			Reserva auxiliar = iterador.next();
			Month mesLista = auxiliar.getPermanencia().getDia().getMonth();
			Month mesFecha = fecha.getMonth();
			if (profesor.equals(auxiliar.getProfesor()) && mesLista.getValue() == mesFecha.getValue()) {
				reservasMes.add(new Reserva(auxiliar));
			}
		}
		return reservasMes;
	}
	
	//CREAMOS MÉTODO GETRESERVAAULADIA
	public Reserva getReservaAulaDia(Aula aula, LocalDate fecha) {
		if (aula == null) {
			throw new NullPointerException("ERROR: El aula no puede ser nula");
		} else if (fecha == null) {
			throw new NullPointerException("ERROR: La fecha no puede ser nula");
		}
		Reserva reservaDia = null;
		Iterator<Reserva> iterador = coleccionReservas.iterator();
		while (iterador.hasNext()) {
			Reserva auxiliar = iterador.next();
			if (aula.equals(auxiliar.getAula()) && fecha.equals(auxiliar.getPermanencia().getDia())) {
				reservaDia = new Reserva(auxiliar);
			}
		}
		return reservaDia;
	}

}
