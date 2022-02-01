

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		
		
		//Crear una Lista de Equipo

		int edad = (int) Math.floor(Math.random()*15)+4;
		int numeroEquipos = (int) Math.floor(Math.random()*13)+4;
		Equipo[] listaEquipos = crearEquipos(numeroEquipos, edad);
		for (int i=0 ; i <numeroEquipos; i++) {
			listaEquipos[i].setJugadores(crearJugadores(22 ,edad,listaEquipos[i]));
			listaEquipos[i].setCampo(crearCampos(listaEquipos[i]));
		}

		
		//Imprimimos los equipos
		System.out.println("Numero de equipos: "+numeroEquipos);
		for (int i=0 ; i <numeroEquipos; i++) {
			Jugador[] listaJugadores =listaEquipos[i].getJugadores();
			System.out.println("El nombre del equipo es : "+listaEquipos[i].getNombre());
			System.out.println("El entrenador del equipo es :");
			System.out.println(listaEquipos[i].getEntrenador());
			System.out.println();
			System.out.println("El nombre del cammpo es: "+listaEquipos[i].getCampo().getNombre());
			System.out.println();
			for(int j = 0 ; j < 22; j++) {
				System.out.println(listaJugadores[i].getNombre()+" "+listaJugadores[j].getApellidos());
				System.out.println("El dorsal del jugador es: "+listaJugadores[j].getDorsal());
				System.out.println("La categoria del jugador es: "+listaJugadores[j].getCategoria());
				System.out.println("La posición del jugador es: "+listaJugadores[j].getPosicion());
				System.out.println("");
			}
			System.out.println("----------------------------------------------------");
			System.out.println();
			System.out.println();
		}
		//Arbitros[] listaArbitros = crearArbitros();
	
		Arbitro [] listaArbitros = crearArbitros();
		for(int i=0;i<listaArbitros.length;i++) {
			System.out.println("arbitro :"+ i+ listaArbitros[i].getNombre());
		}
		//Imprimimos los equipos
		System.out.println("Numero de equipos: "+numeroEquipos);
		for (Equipo e: listaEquipos) {
			System.out.println(e.getNombre());
		}
		
		Calendario calendario  = null;
		calendario = crearCalendario(listaEquipos,listaArbitros);
		mostrarCalendario(calendario);



	}
	
	private static Arbitro[] crearArbitros() {



		String [] nombres = {"Mateu Real Madrid", "Gil Real Madrid", "Del Cerro Grande Real Madrid", "González González Real madrid",
		"Soto Grado Real Madrid"};




		Arbitro [] listaArbitros = new Arbitro[5];
		for(int i = 0; i < 5; i++) {
		Arbitro arbitro = new Arbitro();
		//nombre
		arbitro.setNombre(nombres[i]);



		//Edad
		int edad = (int) Math.floor(Math.random()*47)+18;
		arbitro.setEdad(edad);



		//Licencia
		int licencia = (int) Math.floor(Math.random()*100000);
		arbitro.setLicencia(licencia);
		listaArbitros[i] = arbitro;
		}
		return listaArbitros;



		}
	
	private static Jugador[] crearJugadores(int numeroJugadores, int edad, Equipo equipo) {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "PiquÃ©","Bale (lesionado)",
				"Amunike","N'kono","ButragueÃ±o","SanchÃ­s","Neymar","Batistuta","Maradona",
				"PelÃ©","Beckenbauer"};
		String[] posiciones = {"Portero/a","Defensa","Centrocampista","Delantero/a"};

		//Estructura de Array de Jugadores
		Jugador[] jugadores = new Jugador[numeroJugadores];

		for (int i=0; i<numeroJugadores; i++) {
			//Crear un Jugador
			Jugador jug = new Jugador();
			//Nombre
			int numero = (int) Math.floor(Math.random()*nombres.length);
			String nombre = nombres[numero];
			jug.setNombre(nombre);

			//Apellidos
			numero = (int) Math.floor(Math.random()*apellidos.length);
			String apellido1 = apellidos[numero];
			numero = (int) Math.floor(Math.random()*apellidos.length);
			String apellido2 = apellidos[numero];
			jug.setApellidos(apellido1+" "+apellido2);

			//PosiciÃ³n
			numero = (int) Math.floor(Math.random()*posiciones.length);
			String posicion = posiciones[numero];
			jug.setPosicion(posicion);

			//Edad
			jug.setEdad(edad);

			//Dorsal
			jug.setDorsal(i+1);

			//Equipo
			jug.setEquipo(equipo);

			jugadores[i]=jug;

		}

		return jugadores;
	}

	private static Equipo[] crearEquipos(int numeroEquipos,int edad) {

		String [] nombreBarrios = {"El Candado", "Huelin", "Tiro PichÃ³n", "RincÃ³n de la Victoria", "La Rosaleda", "Torremolinos",
				"Velez MÃ¡laga","Cerrado de Calderon", "El Puerto de la Torre", "Bresca", "Mezquitilla", "Teatinos", "Motril",
				"Centro","Santa Paula", "El Palo", "Los Corazones", "Las Delicias", "Recogidas","Nueva MÃ¡laga", "Casas Blancas",
				"La Palmilla","Los Asperones","Campanillas","La Corta"};
		String [] mascotas = {"Los Pollos", "Los Araclanes", "Los Limones", "Los Delfines", "Los Chanquetes", "Los Gatitos",
				"Los Boquerones", "Los Toros", "Los Perritos", "Los Halcones", "Los Ornitorrincos", "Los Caracoles",
				"Los Palomos Cojos", "Los Heterosaurios", "Las Tortugas Ninjas", "Los Pintarrojas"};

		Equipo [] listaEquipos= new Equipo[numeroEquipos];

		for (int i=0; i<numeroEquipos; i++) {
			//Creamos Equipo
			Equipo equipo = new Equipo();



			//Elegimos random un nombre y una mascota de las listas respectivas.
			int numero = (int) Math.floor(Math.random()*nombreBarrios.length);
			String barrio= nombreBarrios[numero];
			numero = (int) Math.floor(Math.random()*mascotas.length);
			String mascota= mascotas[numero];

			//Definimos el club en base al nombre del barrio
			equipo.setClub(barrio+" F.C.");

			//Las pegamos con un "de" en medio+
			String nombre;
			if (barrio.startsWith("El ")) {
				barrio=barrio.substring(3);
				nombre = mascota + " del "+ barrio;
			}else {
				nombre = mascota + " de "+ barrio;
			}

			equipo.setNombre(nombre);
			//Continuamos con entrenador
			Entrenador entrenador = crearEntrenador(equipo);
			equipo.setEntrenador(entrenador);

			//Meter los jugadores
			int numeroJugadores=(int) Math.floor(Math.random()*7)+15;
			Jugador[] jugadores = crearJugadores(numeroJugadores,edad,equipo);
			equipo.setJugadores(jugadores);

			//Meter el equipo en el array de equipos

			listaEquipos[i]=equipo;



		}
		return listaEquipos;

	}
	
	private static Campo crearCampos(Equipo equipo) {
		String [] campos = {"San Mamés", "Vicente Calderón", "Campo nuevo", "Balaídos", "Riazor", "Ipurua",
		"Alfonso Pérez", "Nuevo Lois Cármenes", "Estadio de Gran Canaria", "Ciutat de València",
		"Estadio de Vallecas", "Benito Villamarín","Santiago Bnernabéu", "Anoeta",
		"El Molinón", "Ramón Sánchez Pijuán", "Mestalla", "El Madrigal"};



		Campo campo = new Campo();
		int numero = (int) Math.floor(Math.random()*campos.length);
		String nombre = campos[numero];
		campo.setNombre(nombre);
		equipo.setCampo(campo);
		return campo;


	}
	private static Entrenador crearEntrenador(Equipo equipo) {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "PiquÃ©","Bale (lesionado)",
				"Amunike","N'kono","ButragueÃ±o","SanchÃ­s","Neymar","Batistuta","Maradona",
				"PelÃ©","Beckenbauer"};
		Entrenador entrenador = new Entrenador();

		//Nombre
		int numero = (int) Math.floor(Math.random()*nombres.length);
		String nombre = nombres[numero];
		entrenador.setNombre(nombre);

		//Apellidos
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido1 = apellidos[numero];
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido2 = apellidos[numero];
		entrenador.setApellidos(apellido1+" "+apellido2);

		//Equipo
		entrenador.setEquipo(equipo);

		//Edad
		int edad = (int) Math.floor(Math.random()*47)+18;
		entrenador.setEdad(edad);
		//Licencia
		int licencia = (int) Math.floor(Math.random()*100000);
		entrenador.setNumeroLicencia(licencia);

		return entrenador;
	}



	private static Calendario crearCalendario(Equipo[] equipos, Arbitro[] arbitros) {
		Calendario calendario = new Calendario();
		String[] horas = {"10:00","11:30","13:00","14:30","16:00"};
		Jornada[] jornadas = new Jornada[18];
		Equipo equipo1_ant = new Equipo();
		Equipo equipo2_ant = new Equipo();
		Arbitro arbitro_ant = new Arbitro();
		for(int i = 0; i < jornadas.length; i++) {
			jornadas[i] = new Jornada();
			Partido[] partidos= new Partido[5];
			//Asignamos arbitros a los partidos
			for(int j = 0; j < partidos.length; j++) {
				partidos[j] = new Partido();
				String hora = horas[(int)Math.floor(Math.random()*5)];
				Horario horario = new Horario(hora);
				partidos[j].setHorario(horario);
				Partido partido_jornada = partidos[j];
				partidos[j].setArbitro(arbitros[j]);
				
				//Asignamos los equipos 
				int random1=(int) Math.floor(Math.random()*equipos.length);
				Equipo equipo1 = equipos[random1];
//				while(equipo1.equals(equipo1_ant) && equipo1.equals(equipo2_ant) ) {
//					equipo1 = equipos[(int) Math.floor(Math.random()*equipos.length)];
//				}
//				equipo1_ant = equipo1;
				int random2=(int) Math.floor(Math.random()*equipos.length);
				Equipo equipo2 = equipos[random2];
//				while(equipo2.equals(equipo1) && equipo1.equals(equipo2_ant)) {
//					equipo2 = equipos[(int) Math.floor(Math.random()*equipos.length)];
//				}
//				equipo2_ant = equipo2;

				partidos[j].setEquipos(equipo1,equipo2);
				
			}
			jornadas[i].setPartidos(partidos);
		}
		
		calendario.setJornadas(jornadas);

		return calendario;
	}
	
	private static void mostrarCalendario(Calendario calendario) {
		Jornada[] jornadas = calendario.getJornadas();
		for(int i = 0; i< calendario.getJornadas().length;i++) {
			System.out.println("Jornada " + i + ": ");
			for(int j = 0; j < jornadas[i].partidos.length;j++) {
				Partido[] partidos = jornadas[i].getPartidos();
				Equipo[] equipos = partidos[j].getEquipos();
				System.out.println(equipos[0].getNombre() + " VS " + equipos[1].getNombre() +" " + partidos[j].getHorario());
				
			}
			System.out.println();
		}

		
	}
}
