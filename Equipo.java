
public class Equipo {
	private String nombre;
	private String club;
	private Campo campo;
	private Entrenador entrenador;
	private String equipacionCasa;
	private String equipacionFuera;
	private Jugador[] jugadores;
	private int partidos = 0;
	private int partidosGanados = 0;
	private int partidosPerdidos = 0;
	private int partidosEmpatados = 0;
	private int golesFavor;
	private int golesContra;
	private int puntos;
	
	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}
	public void setPartidosEmpatados(int partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}
	public int getPartidosGanados() {
		return partidosGanados;
	}
	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}
	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}
	
	public int getPartidos() {
		return partidos;
	}
	public void setPartidos(int partidos) {
		this.partidos = partidos;
	}
	
	public int getGolesFavor() {
		return golesFavor;
	}
	public void setGolesFavor(int golesFavor) {
		this.golesFavor = this.golesFavor + golesFavor;
	}
	public int getGolesContra() {
		return golesContra;
	}
	public void setGolesContra(int golesContra) {
		this.golesContra = this.golesContra + golesContra;
	}
	
	public Campo getCampo() {
		return campo;
	}
	public void setCampo(Campo campo) {
		this.campo = campo;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public Entrenador getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	public String getEquipacionCasa() {
		return equipacionCasa;
	}
	public void setEquipacionCasa(String equipacionCasa) {
		this.equipacionCasa = equipacionCasa;
	}
	public String getEquipacionFuera() {
		return equipacionFuera;
	}
	public void setEquipacionFuera(String equipacionFuera) {
		this.equipacionFuera = equipacionFuera;
	}
	public Jugador[] getJugadores() {
		return jugadores;
	}
	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}
	private String toStringJugadores(Jugador[] jugadores) {
		String listadoJugadores="";
		for (Jugador j: jugadores) {
			listadoJugadores+=j+"\n";
		}
		return listadoJugadores;
		
	}
	
	
	@Override
	public String toString() {
		return "Nombre del Equipo: "+this.nombre+"\n"+
				"Club: "+this.club+"\n"+
				"Entrenador"+"\n"+
				entrenador+"\n"+
				"Plantilla: "+"\n"+
				toStringJugadores(this.jugadores);
		
	}


}
