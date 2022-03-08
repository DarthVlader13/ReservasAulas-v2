package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Profesor {
	
	// DECLACIÓN DE ATRIBUTOS
	private static final String ER_TELEFONO = ("[69][0-9]{8}");
	private static final String ER_CORREO = "^[A-Za-z0-9+_.-]+@(.+)$";
	private String nombre;
	private String correo;
	private String telefono;
	

	// GENERAMOS PRIMERO GETTER Y SETTERS NOMBRE
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
			throw new NullPointerException("ERROR: El nombre del profesor no puede ser nulo.");
		} else if (nombre.isBlank()) {
			throw new IllegalArgumentException("ERROR: El nombre del profesor no puede estar vacío.");
		}
		this.nombre = formateaNombre(nombre);
	}


	
	// GENERAMOS GETTER Y SETTER CORREO
	/**
	 * @return the correo
	 */
	private String getCorreo() {
		return correo;
	}


	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {

		if (correo == null) {
			throw new NullPointerException("ERROR: El correo del profesor no puede ser nulo.");
		}

		Pattern pat = Pattern.compile(ER_CORREO);
		Matcher mat = pat.matcher(correo);
		if (mat.matches() == false) {
			throw new IllegalArgumentException("ERROR: El correo del profesor no es válido.");
		}
		this.correo = correo;
	}

	// GENERAMOS GETTER Y SETTER TELEFONO
	/**
	 * @return the telefono
	 */
	private String getTelefono() {
		return telefono;
	}


	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		if (telefono == null) {
			this.telefono = telefono;
		} else {
			Pattern pat = Pattern.compile(ER_TELEFONO);
			Matcher mat = pat.matcher(telefono);
			if (mat.matches() == false) {
				throw new IllegalArgumentException("ERROR: El teléfono del profesor no es válido.");
			}
		}
		this.telefono = telefono;
	}
	
	// CONSTRUCTOR CON DOS PARAMETROS
		public Profesor(String nombre, String correo) {
			setNombre(nombre);
			setCorreo(correo);
		}
	
	// AHORA PODEMOS GENERAR EL CONSTRUCTOR CON TRES PARAMETROS
		public Profesor(String nombre, String correo, String telefono) {
			setNombre(nombre);
			setCorreo(correo);
			setTelefono(telefono);
		}
		
	// GENERAMOS EL CONSTRUCTOR COPIA
	public Profesor(Profesor otroProfesor) {
		if (otroProfesor == null) {
			throw new NullPointerException("ERROR: No se puede copiar un profesor nulo.");
			} else {
			setNombre(otroProfesor.getNombre());
			setCorreo(otroProfesor.getCorreo());
			setTelefono(otroProfesor.getTelefono());
			}
	}

	// CREAMOS METODO FORMATEARNOMBRE
	private String formateaNombre(String nombreSinFormato) {
		String nombre = nombreSinFormato.trim().replaceAll("\\s{2,}", " ").toLowerCase();
		char cadenaChar[] = new char[nombre.length()];
		cadenaChar=nombre.toCharArray();
		for (int i = 0; i < cadenaChar.length; ++i) {
			if (cadenaChar[i] == ' ') {
				cadenaChar[i + 1] = Character.toUpperCase(cadenaChar[i + 1]);
			}
		}
		cadenaChar[0] = Character.toUpperCase(cadenaChar[0]);
		nombre = String.valueOf(cadenaChar);
		return nombre;
	}
	
	// CREAMOS MÉTODO GETPROFESORFICTICIO
	// Este método devuelve un profesor a partir de un correo del mismo.
	public static Profesor getProfesorFicticio (String correo) {
		Profesor profesor=new Profesor("Jose",correo,"640785633");
		return new Profesor(profesor);
	}
	
	//GENERAMOS MÉTODOS HAASH AND EQUALS
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
		Profesor other = (Profesor) obj;
		return Objects.equals(nombre, other.nombre);
	}


		
	//GENERAMOS MÉTODO STRING
	@Override
	public String toString() {
		if (telefono != null) {
			return "nombre=" + nombre + ", correo=" + correo + ", teléfono=" + telefono;
		}
		return "nombre=" + nombre + ", correo=" + correo;
	}
	
}
