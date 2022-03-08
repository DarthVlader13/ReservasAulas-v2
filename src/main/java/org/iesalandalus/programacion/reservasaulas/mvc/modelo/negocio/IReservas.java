package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;

public interface IReservas {

	//Este getter devuelve una copia profunda mediante un método específico para ello, para evitar aliasing
	List<Reserva> getReservas();

	//Método getNumAulas que nos devuelve el tamaño de coleccionAulas
	int getNumReservas();

	//Método buscar, que crea un Aula y ante un Aula dada como parámetro busca su índice con .indexOf. Si no existe, nos devolverá -1 y
	//devolvemos nulo. Si devuelve otro número, será el índice de la coincidencia así que guardamos una copia de ese objeto mediante el índice
	//obtenido y lo devolvemos
	Reserva buscar(Reserva reserva);

	//Método borrar, que comprueba nulo, comprueba que el aula exista mediante buscar y después borra el aula accediendo a su índice
	void borrar(Reserva reserva) throws OperationNotSupportedException;

	//Creamos el método representar que creará un ArrayList de tipo String en el que guardaremos los .toString de las aulas para su posterior uso.
	List<String> representar();

	//Método que recibe un Profesor, valida en null y después crea una lista de Reserva y un iterador para recorrerla. Utilizaremos una variable auxiliar
	//para guardar cada Reserva para después sacar su profesor con el método apropiado y compararlo con el del parámetro. De haber coincidencia, copiamos
	//dicha Reserva en la lista creada y finalmente la devolvemos.
	List<Reserva> getReservasProfesor(Profesor profesor);

	//Método que recibe un Aula, valida en null y después crea una lista de Reserva y un iterador para recorrerla. Utilizaremos una variable auxiliar
	//para guardar cada Reserva para después sacar su aula con el método apropiado y compararla con el del parámetro. De haber coincidencia, copiamos
	//dicha Reserva en la lista creada y finalmente la devolvemos.
	List<Reserva> getReservasAula(Aula aula);

	//Método que recibe una Permanencia, valida en null y después crea una lista de Reserva y un iterador para recorrerla. Utilizaremos una variable auxiliar
	//para guardar cada Reserva para después sacar su permanencia con el método apropiado y compararla con el del parámetro. De haber coincidencia, copiamos
	//dicha Reserva en la lista creada y finalmente la devolvemos.
	List<Reserva> getReservasPermanencia(Permanencia permanencia);

	//Método que ante un Aula y una Permanencia pasadas como parámetros, valida nulo y después crea un iterador para recorrer coleccionReservas. Usa una
	//variable auxiliar para ir guardando cada Reserva de la iteración y comprueba mediante los métodos apropiados si el aula y la permanencia de dicha
	//Reserva coinciden con las pasadas como parámetros. De ser así, devuelve una disponibilidad false, de lo contrario la devuelve como true
	boolean consultarDisponibilidad(Aula aula, Permanencia permanencia);

	// Método que recibe un Aula y un LocalDate como parámetros. Valida null y luego crea un iterador que guarda en una variable auxiliar la reserva que
	// está iterando. Si el aula y la fecha del auxiliar, extraídos con los métodos adecuados, coinciden con las de los parámetros, hace una copia del
	// auxiliar y lo retorna. Si no, retorna null
	Reserva getReservaAulaDia(Aula aula, LocalDate fecha);

	// Método insertar, que a un Aula dada comprueba si es nullo y si no, recorre coleccionAulas buscando alguna coincidencia. De haberla, nos
	// retorna una excepción avisándonos del aula duplicada y si no, inserta una copia del Aula pasada como parámetro
	void insertar(Reserva reserva) throws OperationNotSupportedException;

}