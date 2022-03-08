package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.util.Objects;

public class Reserva {

	// DECLARACIÓN DE ATRIBUTOS
	private Profesor profesor;
	private Aula aula;
	private Permanencia permanencia;

	// GENERAMOS GETTERS AND SETTERS

	/**
	 * @return the profesor
	 */
	public Profesor getProfesor() {
		return new Profesor(profesor);
	}

	/**
	 * @param profesor the profesor to set
	 */
	private void setProfesor(Profesor profesor) {
		if (profesor == null) {
			throw new NullPointerException("ERROR: La reserva debe estar a nombre de un profesor.");
		}
		this.profesor = new Profesor(profesor);
	}

	/**
	 * @return the aula
	 */
	public Aula getAula() {
		return new Aula(aula);
	}

	/**
	 * @param aula the aula to set
	 */
	private void setAula(Aula aula) {
		if (aula == null) {
			throw new NullPointerException("ERROR: La reserva debe ser para un aula concreta.");
		}
		this.aula = new Aula(aula);
	}

	/**
	 * @return the permanencia
	 */
	public Permanencia getPermanencia() {
		Permanencia permanenciaCopia = null;
		if (permanencia instanceof PermanenciaPorHora) {
			permanenciaCopia = new PermanenciaPorHora((PermanenciaPorHora) permanencia);
		} else if (permanencia instanceof PermanenciaPorTramo) {
			permanenciaCopia = new PermanenciaPorTramo((PermanenciaPorTramo) permanencia);
		}
		return permanenciaCopia;
	}

	/**
	 * @param permanencia the permanencia to set
	 */
	private void setPermanencia(Permanencia permanencia) {
		if (permanencia == null) {
			throw new NullPointerException("ERROR: La reserva se debe hacer para una permanencia concreta.");
		} else if (permanencia instanceof PermanenciaPorHora) {
			this.permanencia = new PermanenciaPorHora((PermanenciaPorHora) permanencia);
		} else if (permanencia instanceof PermanenciaPorTramo) {
			this.permanencia = new PermanenciaPorTramo((PermanenciaPorTramo) permanencia);
		}
	}

	// CONSTRUCTOR CON PARAMETROS
	public Reserva(Profesor profesor, Aula aula, Permanencia permanencia) {
		setProfesor(profesor);
		setAula(aula);
		setPermanencia(permanencia);
	}

	// CONSTRUCTOR COPIA
	public Reserva(Reserva r) {
		if (r == null) {
			throw new NullPointerException("ERROR: No se puede copiar una reserva nula.");
		}
		setProfesor(r.getProfesor());
		setAula(r.getAula());
		setPermanencia(r.getPermanencia());
	}

	// CREAMOS MÉTODO GETRESERVAFICTICIA
	public static Reserva getReservaFicticia(Aula aula, Permanencia permanencia) {
		Reserva reserva = new Reserva(Profesor.getProfesorFicticio("pepe@gmail.com"), aula, permanencia);
		return new Reserva(reserva);
	}

	// CREAMOS MÉTODO GETPUNTOS
	public float getPuntos() {
		return permanencia.getPuntos() + aula.getPuntos();
	}

	// GENERAMOS EQUALS AND HASH
	@Override
	public int hashCode() {
		return Objects.hash(aula, permanencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(aula, other.aula) && Objects.equals(permanencia, other.permanencia);
	}

	// GENERAMOS METODO TOSTRING
	@Override
	public String toString() {
		return profesor.toString() + ", " + aula.toString() + ", " + permanencia.toString() + ", "
				+ String.format("puntos=%.1f", getPuntos());
	}
}
