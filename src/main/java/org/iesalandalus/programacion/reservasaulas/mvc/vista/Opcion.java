package org.iesalandalus.programacion.reservasaulas.mvc.vista;

public enum Opcion {

	//OPCIONES A MOSTRAR
	
	SALIR("Salir") {
		public void ejecutar() {
			vista.salir();
		}
	},
	INSERTAR_AULA("Insertar aula") {
		public void ejecutar() {
			vista.insertarAula();
		}
	},
	BORRAR_AULA("Borrar aula") {
		public void ejecutar() {
			vista.borrarAula();
		}
	},
	BUSCAR_AULA("Buscar aula") {
		public void ejecutar() {
			vista.buscarAula();
		}
	},
	LISTAR_AULAS("Listar aulas") {
		public void ejecutar() {
			vista.listarAulas();
		}
	},
	INSERTAR_PROFESOR("Insertar profesor") {
		public void ejecutar() {
			vista.insertarProfesor();
		}
	},
	BORRAR_PROFESOR("Borrar profesor") {
		public void ejecutar() {
			vista.borrarProfesor();
		}
	},
	BUSCAR_PROFESOR("Buscar profesor") {
		public void ejecutar() {
			vista.buscarProfesor();
		}
	},
	LISTAR_PROFESORES("Listar profesores") {
		public void ejecutar() {
			vista.listarProfesores();
		}
	},
	INSERTAR_RESERVA("Insertar reserva") {
		public void ejecutar() {
			vista.realizarReserva();
		}
	},
	BORRAR_RESERVA("Borrar reserva") {
		public void ejecutar() {
			vista.anularReserva();
		}
	},
	LISTAR_RESERVAS("Listar reservas") {
		public void ejecutar() {
			vista.listarReservas();
		}
	},
	LISTAR_RESERVAS_AULA("Listar reservas de aula") {
		public void ejecutar() {
			vista.listarReservasAula();
		}
	},
	LISTAR_RESERVAS_PROFESOR("Listar reservas de profesor") {
		public void ejecutar() {
			vista.listarReservasProfesor();
		}
	},
	CONSULTAR_DISPONIBILIDAD("Consultar disponibilidad") {
		public void ejecutar() {
			vista.consultarDisponibilidad();
		}
	};

	// DECLARACION DE ATRIBUTOS
	private String mensajeAMostrar;
	private static Vista vista;

	// CREAMOS MÉTODO OPCION
	private Opcion(String mensaje) {
		this.mensajeAMostrar = mensaje;
	}

	// CREAMOS MÉTODO GETMENSAJE
	public String getMensaje() {
		return mensajeAMostrar;
	}

	// CREAMOS MÉTODO EJECUTAR
	public abstract void ejecutar();

	// CREAMOS MÉTODO SETVISTA
	public static void setVista(Vista vista) {
		if (vista == null) {
			throw new NullPointerException("ERROR: La vista no pueda ser nula.");
		}
		Opcion.vista = vista;
	}

	// CREAMOS MÉTODO GETOPCIONSEGUNORDINAL
	public static Opcion getOpcionSegunOrdinal(int ordinal) {
		if (!esOrdinalValido(ordinal)) {
			throw new IllegalArgumentException("Ordinal de la opción no válido");
		}
		return values()[ordinal];
	}

	// CREAMOS MÉTOD ESORDINALVALIDO
	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1);
	}

	// GENERAMOS MÉTODO TOSTRING
	@Override
	public String toString() {
		return String.format("%d.- %s", ordinal(), getMensaje());
	}

}
