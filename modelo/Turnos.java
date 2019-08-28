package modelo;

public class Turnos {
	@SuppressWarnings("unused")
	private Mascota paciente;
	private empleados empleado;
	public Turnos(Mascota pet, empleados emp) {
		this.paciente = pet;
		this.empleado = emp;
	}
	
	public empleados getPaciente() {
		return empleado;
	}
	
	public empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(empleados empleado) {
		this.empleado = empleado;
	}

	public void setPaciente(Mascota paciente) {
		this.paciente = paciente;
	}
}
