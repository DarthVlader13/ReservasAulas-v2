package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Permanencia {

	// DECLARACIÓN DE VARIABLES Y CONSTANTES.
	private LocalDate dia;
	protected static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// CONSTRUCTOR CON PARAMETROS
	public Permanencia(LocalDate dia) {
		setDia(dia);
	}

	// CONSTRUCTOR COPIA
	public Permanencia(Permanencia p) {
		if (p == null) {
			throw new NullPointerException("ERROR: No se puede copiar una permanencia nula.");
		}
		setDia(p.getDia());
	}

	// GENERAMOS GETTER Y SETTER CON POSIBLES NULL DE DIA

	/**
	 * @return the dia
	 */
	public LocalDate getDia() {
		return dia;
	}

	/**
	 * @param dia the dia to set
	 */
	private void setDia(LocalDate dia) {
		if (dia == null) {
			throw new NullPointerException("ERROR: El día de una permanencia no puede ser nulo.");
		}
		this.dia = dia;
	}

	// CREAMOS MÉTODO GETPUNTOS ABSTRACT
	public abstract int getPuntos();

	// GENERAMOS HASCODE Y EQUALS
	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(Object obj);

	// MÉTODO TOSTRING
	@Override
	public String toString() {
		return "dia=" + dia.format(FORMATO_DIA);
	}

	public abstract int compareTo(Permanencia p);

}
