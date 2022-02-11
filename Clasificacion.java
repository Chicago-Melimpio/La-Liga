
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

		
		 void mostrar() {
			ordenar();
			Equipo[] equipo = this.equipos;
			System.out.println("CLASIFICACION! \n");
			for(int i = 0; i < equipo.length; i++) {
				System.out.println((i+1) + "º posicon: " + equipo[i].getNombre() + " " + equipo[i].getPuntos()+" Puntos " + equipo[i].getGolesFavor() + " Goles a favor" + " " + equipo[i].getGolesContra() + " Goles en contra");
			}
		}
}
