package org.iesalandalus.programacion.reservasaulas.mvc.vista;

import org.iesalandalus.programacion.reservasaulas.mvc.controlador.IControlador;

public interface IVista {
	
	// MÉTODO SETCONTROLADOR
	void setControlador(IControlador controlador);

	// MÉTODO COMENZAR
	void comenzar();

	// MÉTODO SALIR
	void salir();

}
