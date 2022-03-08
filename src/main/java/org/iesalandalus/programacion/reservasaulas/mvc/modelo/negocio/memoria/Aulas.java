package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.memoria;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.IAulas;

public class Aulas implements IAulas {

	// DECLARACIÓN DE ATRIBUTOS
	private List<Aula> coleccionAulas;

	// CONSTRUCTOR VACIO
	public Aulas() {
		coleccionAulas = new ArrayList<>();
	}

	// CREAMOS MÉTODO AULA GET, CREANDO COPIA PROFUNDA DEL ARRAY LIST PARA EVITAR EL
	// ALIASING
	public List<Aula> getAulas() {
		return copiaProfundaAulas(coleccionAulas);
	}

	// CREAMOS CONSTRUCTOR COPIA
	public Aulas(Aulas a) {
		if (a == null) {
			throw new NullPointerException("ERROR: No se pueden copiar aulas nulas.");
		}
		setAulas(a);
	}

	// CREAMOS MÉTODO SETAULAS
	private void setAulas(Aulas aulas) {
		if (aulas == null) {
			throw new NullPointerException("ERROR: No se puede copiar un aula nula.");
		}
		this.coleccionAulas = aulas.getAulas();
	}

	// CREAMOS MÉTODO COPIAPROFUNDAAULAS
	private List<Aula> copiaProfundaAulas(List<Aula> listaAulas) {
		List<Aula> copiaProfunda = new ArrayList<>();
		Iterator<Aula> iterador = listaAulas.iterator();
		while (iterador.hasNext()) {
			copiaProfunda.add(new Aula(iterador.next()));
		}
		return copiaProfunda;
	}

	// CREAMOS MÉTODO NUMAULAS
	public int getNumAulas() {
		return coleccionAulas.size();
	}

	// CREAMOS MÉTODO INSERTAR
	public void insertar(Aula aula) throws OperationNotSupportedException {
		if (aula == null) {
			throw new NullPointerException("ERROR: No se puede insertar un aula nula.");
		} else if (buscar(aula) == null) {
			coleccionAulas.add(new Aula(aula));
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe un aula con ese nombre.");
		}
	}

	// CREAMOS MÉTODO BUSCAR
	public Aula buscar(Aula aula) {
		if (aula == null) {
			throw new NullPointerException("ERROR: No se puede buscar un aula nula.");
		}
		Aula aulaEncontrada = null;
		int indice = coleccionAulas.indexOf(aula);
		if (indice == -1) {
			aulaEncontrada = null;
		} else {
			aulaEncontrada = new Aula(coleccionAulas.get(indice));
		}
		return aulaEncontrada;
	}

	// CREAMOS MÉTODO BORRAR
	public void borrar(Aula aula) throws OperationNotSupportedException {
		if (aula == null) {
			throw new NullPointerException("ERROR: No se puede borrar un aula nula.");
		} else if (buscar(aula) == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún aula con ese nombre.");
		} else {
			coleccionAulas.remove(coleccionAulas.indexOf(aula));
		}
	}

	// CREAMOS MÉTODO REPRESENTAR
	public List<String> representar() {
		List<String> representacion = new ArrayList<>();
		Iterator<Aula> iterador = coleccionAulas.iterator();
		while (iterador.hasNext()) {
			representacion.add(iterador.next().toString());
		}
		return representacion;
	}
}
