import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int edad = (int) Math.floor(Math.random()*15)+4;
					Scanner sc = new Scanner(System.in);
					int numeroEquipos = (int) Math.floor(Math.random()*13)+4;
					Equipo[] listaEquipos = crearEquipos(numeroEquipos, edad);
					Arbitro [] listaArbitros = crearArbitros();
					
					
					Iniciar(listaEquipos);
					Calendario calendario = crearCalendario(listaEquipos, listaArbitros);
					Menu frame = new Menu(listaEquipos,listaArbitros,calendario);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public Menu(Equipo[] listaEquipos, Arbitro [] listaArbitros,Calendario calendario) {
		setForeground(new Color(178, 34, 34));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setForeground(new Color(153, 50, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("La Liga");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 33));
		lblNewLabel.setBounds(224, 27, 124, 57);
		contentPane.add(lblNewLabel);
		
		//Bot�n mostrar equipos
		JButton btnNewButton = new JButton("Mostrar Equipos");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarEquipos(listaEquipos);
				System.out.print("Seleccione equipo: ");
				Scanner sc = new Scanner(System.in);
				int i = sc.nextInt();
				System.out.println();
				Equipo equipo = listaEquipos[i];
				mostrarPlantilla(equipo);
			}
		});
		btnNewButton.setBounds(38, 98, 185, 33);
		contentPane.add(btnNewButton);
		
		//Bot�n mostrar arbitros
		JButton btnNewButton_1 = new JButton("Mostrar arbitros");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarArbitros(listaArbitros);
			}
		});
		btnNewButton_1.setBounds(38, 174, 185, 33);
		contentPane.add(btnNewButton_1);
		
		//Bot�n mostrar todas las plantillas
		JButton btnNewButton_2 = new JButton("Todas las plantillas");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarEquiposLiga(listaEquipos);
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(38, 248, 185, 33);
		contentPane.add(btnNewButton_2);
		
		//Bot�n mostrar calendario
		JButton btnNewButton_3 = new JButton("Mostrar calendario");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Calendario calendario = crearCalendario(listaEquipos, listaArbitros);
				mostrarCalendario(calendario);
			}
		});
		btnNewButton_3.setBounds(331, 98, 185, 33);
		contentPane.add(btnNewButton_3);
		
		//Bot�n jugar
		JButton btnNewButton_4 = new JButton("Jugar");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Scanner sc = new Scanner(System.in);
				int j = 0;
				String o;
				if(j == 0) {
					jugarPratidos(calendario);
					j = 1;
				}else {
					System.out.println("Quieres resetear los partidos? S/N");
					System.out.print("Marque la opcion: ");
					o = sc.next();
					if (( o.contains( "S") || (o.contains("s")))){
						jugarPratidos(calendario);
						j = 1;
					}else {
						j = 1;
					}
				}
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(331, 174, 185, 30);
		contentPane.add(btnNewButton_4);
		
		//Bot�n mostrar clasificaci�n
		JButton btnNewButton_5 = new JButton("Mostrar clasificaci\u00F3n");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clasificacion clasificacion = new Clasificacion();
				clasificacion.setEquipos(listaEquipos);
				clasificacion.mostrar();
				System.out.println();
			}
		});
		btnNewButton_5.setBounds(331, 248, 185, 33);
		contentPane.add(btnNewButton_5);
		
		JLabel lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\rma\\Desktop\\la liga.jpg"));
		lblFondo.setBounds(0, 0, 564, 319);
		contentPane.add(lblFondo);
	}
	
	
	
	
	private static void Iniciar(Equipo[] listaEquipos) {
		int edad = (int) Math.floor(Math.random()*15)+4;
		int numeroEquipos = listaEquipos.length;
		listaEquipos = crearEquipos(numeroEquipos, edad);
		for (int i=0 ; i <numeroEquipos; i++) {
			listaEquipos[i].setJugadores(crearJugadores(22 ,edad,listaEquipos[i]));
			listaEquipos[i].setCampo(crearCampos(listaEquipos[i]));
		}
		
		}
	private static void mostrarArbitros(Arbitro[] listaArbitros) {
			for(int i=0;i<listaArbitros.length;i++) {
				System.out.println("arbitro :"+ i +" "+ listaArbitros[i].getNombre()+listaArbitros[i].getApellidos());
			}
			System.out.println();
		}

		private static void mostrarEquipos(Equipo[] listaEquipos) {
			int numeroEquipos =listaEquipos.length;
			System.out.println("Equipos: ");
			for (int i=0 ; i <numeroEquipos; i++) {
				System.out.println("Equipo "+ i+ " : "+listaEquipos[i].getNombre());
				System.out.println("La camiseta que usara este equipo en los parrtidos que juege de Local sera: "+listaEquipos[i].getEquipacionCasa());
				System.out.println("La camiseta que usara este equipo en los parrtidos que juege de Visitante sera: "+listaEquipos[i].getEquipacionFuera());
				System.out.println();
			}
		}

		private static void mostrarEquiposLiga(Equipo[] listaEquipos) {
			int numeroEquipos =listaEquipos.length;
			for (int i=0 ; i <numeroEquipos; i++) {
				Jugador[] listaJugadores =listaEquipos[i].getJugadores();
				System.out.println("El nombre del equipo es : "+listaEquipos[i].getNombre());
				System.out.println("El entrenador del equipo es :");
				System.out.println(listaEquipos[i].getEntrenador());
				System.out.println();
				/*System.out.println("El nombre del campo es: "+listaEquipos[i].getCampo().getNombre());
				System.out.println();*/
				for(int j = 0 ; j < listaEquipos[i].getJugadores().length; j++) {
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
		}

		private static void mostrarPlantilla(Equipo equipo) {
			System.out.println("Plantilla equipo " + equipo.getNombre());
			System.out.println("Entrenador: "+ equipo.getEntrenador().getNombre() + " " +equipo.getEntrenador().getApellidos()  );
			for(int j = 0 ; j < equipo.getJugadores().length; j++) {
				Jugador jugador = equipo.getJugadores()[j];
				System.out.println(equipo.getNombre()+" "+jugador.getApellidos());
				System.out.println("El dorsal del jugador es: "+jugador.getDorsal());
				System.out.println("La categoria del jugador es: "+jugador.getCategoria());
				System.out.println("La posición del jugador es: "+jugador.getPosicion());
				System.out.println("");
			}
			System.out.println("El campo del equipo es: " + equipo.getCampo().getNombre());

		}
		private static Arbitro[] crearArbitros() {



			String [] nombres = {"Mateu", "Gil", "Del Cerro Grande", "González González ",
			"Soto Grado"};
			String [] apellido = {" Real Madrid"," Barcelona"," Real Betico Balompie"};
			Arbitro [] listaArbitros = new Arbitro[25];
			for(int i = 0; i < 25; i++) {
				Arbitro arbitro = new Arbitro();
				//nombre
				int numero = (int) Math.floor(Math.random()*nombres.length);
				arbitro.setNombre(nombres[numero]);
				//apellidos
				numero = (int) Math.floor(Math.random()*3);
				arbitro.setEdad(numero);
				arbitro.setApellidos(apellido[numero]);
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

			String[] CamisetaLocal = {"Rojo","Amarillo","Naranja","Verde"};

			String[] CamisetaVisitante = {"Azul","Negro","Blanco"};

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
				crearCampos(equipo);
				//Meter el equipo en el array de equipos

				//Crear Camiseta Local
				int numero1 = (int) Math.floor(Math.random()*CamisetaLocal.length);
				String CamisetaL= CamisetaLocal[numero1];
				equipo.setEquipacionCasa(CamisetaL);

				//Crear Camiseta Visitante
				int numero2 = (int) Math.floor(Math.random()*CamisetaVisitante.length);
				String CamisetaV= CamisetaLocal[numero2];
				equipo.setEquipacionFuera(CamisetaV);

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

			int numero = equipos.length;
			int numeroJornadas = (numero-1)*2;
			Jornada[] jornadas = new Jornada[numeroJornadas];
			int numeroPartidos = numero/2;
			Equipo[][] emparejamientos = new Equipo[2][numeroPartidos];
			//Mitad izquierda
			for(int i = 0; i < numeroPartidos; i++) {
				emparejamientos[0][i] = equipos[i];
			}
			//mitad derecha
			for(int j = numeroPartidos-1; j >= 0; j--) {
				emparejamientos[1][j] = equipos[numero-(1+j)];
			}

			for(int i = 0; i<numeroJornadas/2; i++) {
				Partido[] partidosIda = new Partido[numeroPartidos];
				Partido[] partidosVuelta = new Partido[numeroPartidos];

				for(int j = 0; j < numeroPartidos;j++) {
					int hora = (int) Math.floor(Math.random()*horas.length);
					Horario horario = new Horario(horas[hora]);
					//partidos de ida
					partidosIda[j] = new Partido();
					partidosIda[j].setLocal(emparejamientos[0][j]);
					partidosIda[j].setVisitante(emparejamientos[1][j]);
					partidosIda[j].setArbitro(arbitros[j]);
					partidosIda[j].setHorario(horario);
					//Partidos de vuelta
					partidosVuelta[j] = new Partido();
					partidosVuelta[j].setLocal(emparejamientos[1][j]);
					partidosVuelta[j].setVisitante(emparejamientos[0][j]);
					partidosVuelta[j].setArbitro(arbitros[j]);
					partidosVuelta[j].setHorario(horario);
				}
				jornadas[i] = new Jornada();
				jornadas[i].setPartidos(partidosIda);
				jornadas[numeroJornadas-1-i] = new Jornada();
				jornadas[numeroJornadas-1-i].setPartidos(partidosVuelta);

				//rotamos el array doble
				Equipo[][] auxEmp = new Equipo[2][numeroPartidos];
				for(int k=0; k < numeroPartidos;k++) {
					if(k == 0) {
						auxEmp[0][k]=emparejamientos[0][k];
					}else if(k>0 && k<numeroPartidos-1) {
						auxEmp[0][k+1] = emparejamientos[0][k];
					}else {
						auxEmp[1][k] = emparejamientos[0][k];
					}
				}

				for(int k = 0; k < numeroPartidos; k++) {
					if(k>0 && k < numeroPartidos) {
						auxEmp[1][k-1] = emparejamientos[1][k];
					}else {
						auxEmp[0][1] = emparejamientos[1][k];
					}
				}
				emparejamientos = auxEmp;

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
					Equipo local = new Equipo();
					local = partidos[j].getLocal();
					Equipo visitante = new Equipo();
					visitante = partidos[j].getVisitante();
					System.out.println(local.getNombre() + " VS " + visitante.getNombre() +" " + partidos[j].getHorario());

				}
				System.out.println();
			}
		}
		private static void jugarPratidos(Calendario calendario) {
			Jornada[] jornadas = calendario.getJornadas();
			for(int i = 0; i< calendario.getJornadas().length;i++) {
				System.out.println("Jornada " + i + ": ");
				for(int j = 0; j < jornadas[i].partidos.length;j++) {
					Partido[] partidos = jornadas[i].getPartidos();
					Equipo local = new Equipo();
					local =partidos[j].getLocal();
					Equipo visitante = new Equipo();
					visitante =partidos[j].getVisitante();
					jornadas[i].generarResultado(partidos[j]);
					int[] k = partidos[j].getResultado();
					partidos[j].ganador(k);	
					System.out.println(partidos[j].getHorario() + " " + local.getNombre() +" "+ k[0] 
							+ " - "  + k[1]+" "+ visitante.getNombre() + " Campo: " + local.getCampo().getNombre());
					System.out.println();
				}
			}

		}
}
