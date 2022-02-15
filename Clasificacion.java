
public class Clasificacion {
	Equipo[] equipos;

	void ordenar() {
		Equipo[] equipo = this.equipos;
		equipos =bubbleSort(equipo);

	}

	public Equipo[] getEquipos() {
		return equipos;
	}

	public void setEquipos(Equipo[] equipos) {
		this.equipos = equipos;
	}

	private static Equipo[] bubbleSort(Equipo[] listaElementos) {
		Equipo temp = new Equipo();
		int n=listaElementos.length;
		boolean ordenado=true;



		for(int i=0;i<n;i++) {
			ordenado=true;
			for (int j=1;j<(n-i);j++) {
				if(listaElementos[j-1].getPuntos()<listaElementos[j].getPuntos()) {
					// Si el que está arriba es más grande que el que está abajo, se intercambian
					temp=listaElementos[j-1];
					listaElementos[j-1]=listaElementos[j];
					listaElementos[j]=temp;
					ordenado=false;
				}else if (listaElementos[j-1].getPuntos()==listaElementos[j].getPuntos()) {
					if(listaElementos[j-1].getGolesFavor()<listaElementos[j].getGolesFavor()) {
						temp=listaElementos[j-1];
						listaElementos[j-1]=listaElementos[j];
						listaElementos[j]=temp;
					}
				}else if((listaElementos[j-1].getPuntos()==listaElementos[j].getPuntos()) && (listaElementos[j-1].getGolesFavor()<listaElementos[j].getGolesFavor())) {
					if(listaElementos[j-1].getGolesContra()<listaElementos[j].getGolesContra()) {
						temp=listaElementos[j-1];
						listaElementos[j-1]=listaElementos[j];
						listaElementos[j]=temp;
					}
				}
			}
			if (ordenado) return listaElementos;
		}
		return listaElementos;
	}

	private String espacios(Equipo equipo) {
		int espacios = 8 - (equipo.getNombre().length()/8);
		String solucion = "";
		for (int i = 0; i < espacios; i++) {
			solucion += '\t';
		}
		return solucion;
	}


	void mostrar() {
		ordenar();
		Equipo[] equipo = this.equipos;
		System.out.println();
		System.out.println("¡¡¡CLASIFICACION!!!");
		System.out.println("\t\t\t\t\t\t\t\t\t\tP\t\tGF\t\tGC\t\tPJ\t\tPG\t\tPP\t\tPE");
		for(int i = 0; i < equipo.length; i++) {
			if(equipo[i].getNombre().length() != 36) {
				while(equipo[i].getNombre().length() <36) {
					equipo[i].setNombre(equipo[i].getNombre()+" ");
				}
			}
			System.out.println((i+1) + "º posicon: " + equipo[i].getNombre() + espacios(equipo[i]) 
			+ equipo[i].getPuntos()+"\t\t" + equipo[i].getGolesFavor() + "\t\t" 
					+ equipo[i].getGolesContra() + "\t\t"+equipo[i].getPartidos()+ "\t\t"+equipo[i].getPartidosGanados()+"\t\t"+equipo[i].getPartidosPerdidos()+"\t\t"+equipo[i].getPartidosEmpatados());
		}
	}
}
