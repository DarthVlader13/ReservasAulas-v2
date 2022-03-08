package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

public enum Tramo {

	MANANA("Mañana"), TARDE("Tarde");

	private String cadenaAMostrar;

	Tramo(String string) {
		this.cadenaAMostrar = string;
	}

	@Override
	public String toString() {
		return cadenaAMostrar;
	}
}
