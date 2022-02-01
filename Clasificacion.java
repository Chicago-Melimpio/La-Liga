
public class Clasificacion {
	Equipo[] equipos;
	
	 void ordenar() {
		Equipo[] equipo = this.equipos;
		
		
	}
	
	 private static void mergeSort(Equipo[] lista) {
		 	sort(lista,lista[0].getPuntos(),lista[lista.length-1].getPuntos());
			
			
		}



		private static void sort(Equipo[] lista, int izq, int der) {
			// TODO Auto-generated method stub
			if(izq < der) {
				//Encontramos el punto medio del array
				int mid = (izq+der)/2;
				//Dividimos las 2 mitades y las damos por ordenadas
				sort(lista,izq,mid);
				sort(lista,mid+1,der);
				//une las 2 mitades
				merge(lista,izq,mid,der);
			}
		}



		private static void merge(Equipo[] lista, int izq, int mid, int der) {
			// TODO Auto-generated method stub
			//calculamos el tamaño de las 2 sublistas a mergear
			int n1= mid - izq +1;
			int n2 = der - mid;
			//creamos 2 sublistas temporales
			Equipo[] listaIzq = new Equipo[n1];
			Equipo[] listaDer = new Equipo[n2];
			//copiamos los datos a la sublista
			for(int i = 0; i < n1; i++) {
				listaIzq[i] = lista[izq+1];
			}
			for(int j = 0; j < n2; j++) {
				listaDer[j] = lista[mid+j+1];
			}
			//fusionar las 2 sublistas en la lista original
			//creamos indices de utilidad
			int i=0,j=0,k=0;
			while(i<n1 && j < n2) {
				if(listaIzq[i].getPuntos() <= listaDer[j].getPuntos()) {
					lista[k] = listaIzq[i];
					i++;
				}else {
					lista[k] = listaDer[j];
					j++;
				}
				k++;
			}
			//terminamos de copiar los valores
			while(i < n1) {
				lista[k] = listaIzq[i];
				i++;
				k++;
			}
			
			while(j<n2) {
				lista[k] = listaDer[j];
				j++;
				k++;
			}
		}
		
		 void mostrar() {
			ordenar();
			Equipo[] equipo = this.equipos;
			System.out.println("CLASIFICACION! \n");
			for(int i = 0; i < equipo.length-1; i++) {
				System.out.println(i + "º posicon: " + equipo[i].getNombre() + " " + equipo[i].getPuntos()+" Puntos");
			}
		}
}
