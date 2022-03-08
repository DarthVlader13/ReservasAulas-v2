package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.memoria;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.IAulas;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.IProfesores;

public class Profesores implements IProfesores {

	// DECLARACIÓN DE ATRIBUTOS
	List<Profesor> coleccionProfesores;

	// CREAMOS MÉTODO GETPROFESORES
	public List<Profesor> getProfesores() {
		return copiaProfundaProfesores(coleccionProfesores);
	}

	// CREAMOS MÉTODO SETPROFESORES
	private void setProfesores(Profesores profesores) {
		if (profesores == null) {
			throw new NullPointerException("ERROR: No se puede copiar un profesor nulo.");
		}
		this.coleccionProfesores = profesores.getProfesores();
	}

	// CONSTRUCTOR VACIO
	public Profesores() {
		coleccionProfesores = new ArrayList<>();
	}

	// CREAMOS CONSTRUCTOR COPIA
	public Profesores(Profesores p) {
		if (p == null) {
			throw new NullPointerException("ERROR: No se pueden copiar profesores nulos.");
		}
		setProfesores(p);
	}

	// CREAMOS MÉTODO GETNUMPROFESORES
	public int getNumProfesores() {
		return coleccionProfesores.size();
	}

	// CREAMOS MÉTODO COPIAPROFUNDAPROFESORES
	private List<Profesor> copiaProfundaProfesores(List<Profesor> listaProfesores) {
		List<Profesor> copiaProfunda = new ArrayList<>();
		Iterator<Profesor> iterador = listaProfesores.iterator();
		while (iterador.hasNext()) {
			copiaProfunda.add(new Profesor(iterador.next()));
		}
		return copiaProfunda;
	}

	// CREAMOS MÉTODO INSERTAR
	public void insertar(Profesor profesor) throws OperationNotSupportedException {
		if (profesor == null) {
			throw new NullPointerException("ERROR: No se puede insertar un profesor nulo.");
		} else if (buscar(profesor) == null) {
			coleccionProfesores.add(new Profesor(profesor));
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe un profesor con ese nombre.");
		}
	}

	// CREAMOS MÉTODO BUSCAR
	public Profesor buscar(Profesor profesor) {
		if (profesor == null) {
			throw new NullPointerException("ERROR: No se puede buscar un profesor nulo.");
		}
		Profesor profesorEncontrado = null;
		int indice = coleccionProfesores.indexOf(profesor);
		if (indice == -1) {
			profesorEncontrado = null;
		} else {
			profesorEncontrado = new Profesor(coleccionProfesores.get(indice));
		}
		return profesorEncontrado;
	}

	// CREAMOS MÉTODO BORRAR
	public void borrar(Profesor profesor) throws OperationNotSupportedException {
		if (profesor == null) {
			throw new NullPointerException("ERROR: No se puede borrar un profesor nulo.");
		} else if (buscar(profesor) == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún profesor con ese nombre.");
		} else {
			coleccionProfesores.remove(coleccionProfesores.indexOf(profesor));
		}
	}

	// CREAMOS MÉTODO REPRESENTAR
	public List<String> representar() {
		List<String> representacion = new ArrayList<>();
		Iterator<Profesor> iterador = coleccionProfesores.iterator();
		while (iterador.hasNext()) {
			representacion.add(iterador.next().toString());
		}
		return representacion;
	}
}
