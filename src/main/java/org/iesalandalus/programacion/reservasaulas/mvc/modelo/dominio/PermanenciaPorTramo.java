package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.time.LocalDate;
import java.util.Objects;

public class PermanenciaPorTramo extends Permanencia {

	// DECLARACIÓN DE VARIABLES Y CONSTANTES.
	private static final int PUNTOS = 10;
	private Tramo tramo;

	// CONSTRUCTOR CON PARAMETROS
	public PermanenciaPorTramo(LocalDate dia, Tramo tramo) {
		super(dia);
		setTramo(tramo);
	}

	// CONSTRUCTOR COPIA
	public PermanenciaPorTramo(PermanenciaPorTramo otraPermanencia) {
		super(otraPermanencia);
		if (otraPermanencia == null) {
			throw new NullPointerException("ERROR: No se puede copiar una permanencia nula.");
		} else {
			setTramo(otraPermanencia.getTramo());
		}
	}

	// GENERAMOS GETTER Y SETTER DE TRAMO

	/**
	 * @return the tramo
	 */
	public Tramo getTramo() {
		return tramo;
	}

	/**
	 * @param tramo the tramo to set
	 */
	private void setTramo(Tramo tramo) {
		if (tramo == null) {
			throw new NullPointerException("ERROR: El tramo de una permanencia no puede ser nulo.");
		}
		this.tramo = tramo;
	}

	// GENERAMOS MÉTODO GETPUNTOS
	@Override
	public int getPuntos() {
		return PUNTOS;
	}

	// GENERAMOS HASCODE Y EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(getDia(), tramo);
	}

	@Override

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermanenciaPorTramo other = (PermanenciaPorTramo) obj;
		return Objects.equals(getDia(), other.getDia()) && tramo == other.tramo;
	}

	// GENERAMOS MÉTODO TOSTRING
	@Override
	public String toString() {
		return super.toString() + ", tramo=" + tramo + "";
	}

	@Override
	public int compareTo(Permanencia o) {
		int resultado = 0;
		if (this.getDia().isAfter(o.getDia())) {
			resultado = 1;
		} else if (this.getDia().isBefore(o.getDia())) {
			resultado = -1;
		} else if (this.getDia().isEqual(o.getDia())) {
			if (o instanceof PermanenciaPorTramo) {
				PermanenciaPorTramo p = new PermanenciaPorTramo((PermanenciaPorTramo) o);
				if (this.getTramo().equals(Tramo.MANANA) && p.getTramo().equals(Tramo.TARDE)) {
					resultado = -1;
				} else if (this.getTramo().equals(Tramo.TARDE) && p.getTramo().equals(Tramo.MANANA)) {
					resultado = 1;
				} else {
					resultado = 0;
				}
			}
		}
		return resultado;
	}

}
