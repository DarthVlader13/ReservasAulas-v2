package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.util.Objects;

public class Aula implements Comparable<Aula> {

	// DECLARACIÓN DE ATRIBUTOS
	private final static float PUNTOS_POR_PUESTO = 0.5f;
	private final static int MIN_PUESTOS = 10;
	private final static int MAX_PUESTOS = 50;
	private String nombre;
	private int puestos;

	// CONSTRUCTOR CON PARAMETROS
	public Aula(String nombre, int puestos) {
		setNombre(nombre);
		setPuestos(puestos);
	}

	// GENERAMOS GETTER Y SETTER
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	private void setNombre(String nombre) {
		if (nombre == null) {
			throw new NullPointerException("ERROR: El nombre del aula no puede ser nulo.");
		} else if (nombre.isEmpty()) {
			throw new IllegalArgumentException("ERROR: El nombre del aula no puede estar vacío.");
		} else {
			this.nombre = nombre;
		}

	}

	/**
	 * @return the puestos
	 */
	public int getPuestos() {
		return puestos;
	}

	/**
	 * @param puestos the puestos to set
	 */
	private void setPuestos(int puestos) {
		if (puestos < MIN_PUESTOS || puestos > MAX_PUESTOS) {
			throw new IllegalArgumentException("ERROR: El número de puestos no es correcto.");
		}
		this.puestos = puestos;
	}

	// CONSTRUCTOR COPIA
	public Aula(Aula a) {
		if (a == null) {
			throw new NullPointerException("ERROR: No se puede copiar un aula nula.");
		}
		setNombre(a.getNombre());
		setPuestos(a.getPuestos());
	}
	
	// GENERAMOS EL MÉTODO GETPUNTOS
	public float getPuntos() {
		float puntos=getPuestos()*PUNTOS_POR_PUESTO;
		return puntos;
	}
	
	// GENERAMOS MÉTODO GETAULAFICTICIA
	public static Aula getAulaFicticia (String nombre) {
		Aula aula=new Aula (nombre,10);
		return new Aula(aula);
	}


	// GENERAMOS METODOS HASDHCODE Y EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(nombre, other.nombre);
	}

	// METODO STRING
	@Override
	public String toString() {
		return "nombre=" + getNombre() + ", puestos=" + getPuestos();
	}
	
	// MÉTODO COMPARETO
	public int compareTo(Aula aula) {
		int resultado=0;
		resultado=this.getNombre().compareTo(aula.getNombre());
		return resultado;
	}

}
