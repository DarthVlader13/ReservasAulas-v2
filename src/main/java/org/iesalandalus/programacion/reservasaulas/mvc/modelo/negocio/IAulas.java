package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;

public interface IAulas {

	//Este getter devuelve una copia profunda mediante un método específico para ello, para evitar aliasing
	List<Aula> getAulas();

	//Método getNumAulas que nos devuelve el tamaño de coleccionAulas
	int getNumAulas();

	//Método insertar, que a un Aula dada comprueba si es nullo y si no, recorre coleccionAulas buscando alguna coincidencia. De haberla, nos
	//retorna una excepción avisándonos del aula duplicada y si no, inserta una copia del Aula pasada como parámetro
	void insertar(Aula aula) throws OperationNotSupportedException;

	//Método buscar, que crea un Aula y ante un Aula dada como parámetro busca su índice con .indexOf. Si no existe, nos devolverá -1 y
	//devolvemos nulo. Si devuelve otro número, será el índice de la coincidencia así que guardamos una copia de ese objeto mediante el índice
	//obtenido y lo devolvemos
	Aula buscar(Aula aula);

	//Método borrar, que comprueba nulo, comprueba que el aula exista mediante buscar y después borra el aula accediendo a su índice
	void borrar(Aula aula) throws OperationNotSupportedException;

	//Creamos el método representar que creará un ArrayList de tipo String en el que guardaremos los .toString de las aulas para su posterior uso.
	List<String> representar();

}

