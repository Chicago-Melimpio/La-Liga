
public class Entrenador extends Persona {
		private int licencia;
		private Equipo equipo;
		public Equipo getEquipo() {
			return equipo;
		}

		public void setEquipo(Equipo equipo) {
			this.equipo = equipo;
		}


		public Entrenador() {}

		public int getLicencia() {
			return licencia;
		}

		public void setNumeroLicencia(int licencia2) {
			this.licencia = licencia2;
		}
}
