
public class Jornada {
	public Partido[] partidos;
	public Equipo[] equipos;
	public Horario horario;
	
	public Jornada() {}
	
	public Partido[] getPartidos() {
		return partidos;
	}

	public void setPartidos(Partido[] partidos) {
		this.partidos = partidos;
	}
	
	public void generarResultado(Partido partido) {
		int[] i = new int[2];
		i[0] = (int)Math.floor(Math.random()*10);
		i[1] = (int)Math.floor(Math.random()*10);
		partido.setResultado(i);
	}

	public Equipo[] getEquipos() {
		return equipos;
	}

	public void setEquipos(Equipo[] equipos) {
		this.equipos = equipos;
	}
	
	public void ganadores() {
		
	}
	public void setHorario(String  hora) {
		this.horario  = new Horario(hora);
	}
}
