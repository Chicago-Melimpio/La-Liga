
public class Horario {
		private String fecha;
		private String hora;
		
		public String getHora() {
			return hora;
		}

		public void setHora(String hora) {
			this.hora = hora;
		}

		public Horario(String hora) {
			this.fecha = "S�bado";
			this.hora = hora;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha() {
			fecha = "Sabado";
		}
		
		
}
