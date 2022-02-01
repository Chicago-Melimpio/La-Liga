
public class Partido {
	private  Equipo[] equipos;
	private Arbitro arbitro;
	private Horario horario;
	private int[] resultado;
	private  Equipo ganador;
	
	public Partido() {}
	
	public Arbitro getArbitro() {
		return arbitro;
	}

	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public int[] getResultado() {
		return resultado;
	}

	public void setResultado(int[] resultado) {
		this.resultado = resultado;
	}

	public Equipo[] getEquipos() {
		return equipos;
	}

	public void setEquipos(Equipo equipo1, Equipo equipo2) {
		this.equipos[0] = equipo1;
		this.equipos[1] = equipo2;
	}

	public Equipo getGanador() {
		return ganador;
	}

	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}
	
	public void ganador(int[] resultado) {
		if(resultado[0] < resultado[1]) {
			equipos[0].setPuntos(equipos[0].getPuntos() + 3);
		}else if (resultado[0] > resultado[1] ){
			equipos[1].setPuntos(equipos[1].getPuntos() + 3);
		}else {
			equipos[0].setPuntos(equipos[0].getPuntos() + 1);
			equipos[1].setPuntos(equipos[1].getPuntos() + 1);
		}
	}
	
	
}
