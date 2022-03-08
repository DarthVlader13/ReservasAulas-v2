package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.memoria;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.IAulas;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.IProfesores;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.IReservas;

public interface IFuenteDatos {
	
	IAulas crearAulas();

	IProfesores crearProfesores();

	IReservas crearReservas();

}

