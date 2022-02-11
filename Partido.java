
public class Partido {
	private Equipo Local;
	private Equipo Visitante;
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

	public String getHorario() {
		return horario.getFecha() + " " + horario.getHora();
	}

	public void setHorario(Horario horario) {
		this.horario = new Horario(horario.getHora());
		
	}

	public int[] getResultado() {
		return resultado;
	}

	public void setResultado(int[] resultado) {
		this.resultado = resultado;
	}

	

	public void setEquipos(Equipo equipo1, Equipo equipo2) {
		this.Local = equipo1;
		this.Visitante = equipo2;
	}

	public Equipo getGanador() {
		return ganador;
	}

	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}
	
	public void ganador(int[] resultado) {
		if(resultado[0] < resultado[1]) {
			this.Local.setPuntos(this.Local.getPuntos() + 3);
			
		}else if (resultado[0] > resultado[1] ){
			this.Visitante.setPuntos(this.Visitante.getPuntos() + 3);
		}else {
			this.Local.setPuntos(this.Local.getPuntos() + 1);
			this.Visitante.setPuntos(this.Visitante.getPuntos() + 1);
		}
		this.Local.setGolesFavor(resultado[0]);
		this.Local.setGolesContra(resultado[1]);
		this.Visitante.setGolesFavor(resultado[1]);
		this.Visitante.setGolesContra(resultado[0]);
	}
	
	public void setEquipos() {
		this.Local = this.Local;
		this.Visitante = this.Visitante;
	}

	public void setLocal(Equipo local) {
		
		this.Local = local;
	}

	public void setVisitante(Equipo visitante) {
		
		this.Visitante = visitante;
	}

	public Equipo getLocal() {
		return this.Local;
	}

	public Equipo getVisitante() {
		return Visitante;
	}
}
