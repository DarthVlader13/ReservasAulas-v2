package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;

public interface IProfesores {

	// Este getter devuelve una copia profunda mediante un método específico para
	// ello, para evitar aliasing
	List<Profesor> getProfesores();

	// Método getNumProfesores que nos devuelve el tamaño de coleccionProfesores
	int getNumProfesores();

	// Método insertar, que a un Profesor dado comprueba si es nullo y si no,
	// recorre coleccionProfesores buscando alguna coincidencia. De haberla, nos
	// retorna una excepción avisándonos del profesor duplicado y si no, inserta una
	// copia del Profesor pasado como parámetro
	void insertar(Profesor profesor) throws OperationNotSupportedException;

	// Método buscar, que crea un Profesor y ante un Profesor dado como parámetro
	// busca su índice con .indexOf. Si no existe, nos devolverá -1 y
	// devolvemos nulo. Si devuelve otro número, será el índice de la coincidencia
	// así que guardamos una copia de ese objeto mediante el índice
	// obtenido y lo devolvemos
	Profesor buscar(Profesor profesor);

	// Método borrar, que comprueba nulo, comprueba que el profesor exista mediante
	// buscar y después borra el profesor accediendo a su índice
	void borrar(Profesor profesor) throws OperationNotSupportedException;

	// Creamos el método representar que creará un ArrayList de tipo String en el
	// que guardaremos los .toString de los profesores para su posterior uso.
	List<String> representar();

}
