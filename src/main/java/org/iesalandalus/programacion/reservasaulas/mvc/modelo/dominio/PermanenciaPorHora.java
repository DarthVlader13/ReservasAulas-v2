package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class PermanenciaPorHora extends Permanencia {

	// DECLARACIÓN DE VARIABLES Y CONSTANTES.
	private static final int PUNTOS = 3;
	private static final LocalTime HORA_INICIO = LocalTime.of(8, 0);
	private static final LocalTime HORA_FIN = LocalTime.of(22, 0);
	protected static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm");
	private LocalTime hora;

	// CONSTRUCTOR CON PARAMETROS
	public PermanenciaPorHora(LocalDate dia, LocalTime hora) {
		super(dia);
		setHora(hora);
	}

	// CONSTRUCTOR COPIA
	public PermanenciaPorHora(PermanenciaPorHora otraPermanencia) {
		super(otraPermanencia);
		if (otraPermanencia == null) {
			throw new NullPointerException ("ERROR: No se puede copiar una permanencia nula.");
		} else if (otraPermanencia.hora != null && otraPermanencia.hora.isBefore(HORA_INICIO) && otraPermanencia.hora.isAfter(HORA_FIN)) {
			throw new IllegalArgumentException ("ERROR: La hora de una permanencia no es válida.");	
		} else {
			setHora(otraPermanencia.getHora());
		}
	}

	// GENERAMOS GETTER Y SETTER DE HORA

	/**
	 * @return the hora
	 */
	public LocalTime getHora() {
		return hora;
	}

	/**
	 * @param hora the hora to set
	 */
	private void setHora(LocalTime hora) {
		if (hora == null) {
			throw new NullPointerException("ERROR: La hora de una permanencia no puede ser nula.");
		} else if (hora.isBefore(HORA_INICIO) || hora.isAfter(HORA_FIN)) {
			throw new IllegalArgumentException("ERROR: La hora de una permanencia no es válida.");
		} else if (hora.getMinute() != 0) {
			throw new IllegalArgumentException("ERROR: La hora de una permanencia debe ser una hora en punto.");
		}
		this.hora = hora;
	}

	// GENERAMOS MÉTODO GETPUNTOS
	@Override
	public int getPuntos() {
		return PUNTOS;
	}

	// GENERAMOS HASCODE Y EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(getDia(), hora);
	}


	@Override

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermanenciaPorHora other = (PermanenciaPorHora) obj;
		return Objects.equals(getDia(), other.getDia()) && hora == other.hora;
	}

	// GENERAMOS MÉTODO TOSTRING
	@Override
	public String toString() {
		return super.toString() + ", hora=" + hora + "";
	}

	@Override
	public int compareTo(Permanencia o) {
		int resultado = 0;
		if (this.getDia().isAfter(o.getDia())) {
			resultado = 1;
		} else if (this.getDia().isBefore(o.getDia())) {
			resultado = -1;
		} else if (this.getDia().isEqual(o.getDia())) {
			if (o instanceof PermanenciaPorHora) {
				PermanenciaPorHora p = new PermanenciaPorHora((PermanenciaPorHora) o);
				if (this.getHora().isAfter(p.getHora())) {
					resultado = 1;
				} else if (this.getHora().isBefore(p.getHora())) {
					resultado = -1;
				} else {
					resultado = 0;
				}
			}
		}

		return resultado;
	}


}
