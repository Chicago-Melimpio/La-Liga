
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
			this.fecha = "Sábado";
			this.hora = hora;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha() {
			fecha = "Sabado";
		}
		
		
}
