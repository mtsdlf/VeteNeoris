package modelo;

public abstract class Mascota {
	private String raza,nombre;
	private int edad;
	private boolean salud;
	private boolean bonito;
	
	public Mascota(String raza, String nombre, int edad) {
		this.raza = raza;
		this.nombre = nombre;
		this.edad = edad;
		salud = false;
		bonito=false;
	}
	public boolean isBonito() {
		return bonito;
	}
	public void setBonito(boolean bonito) {
		this.bonito = bonito;
	}
	public boolean isSalud() {
		return salud;
	}
	public void setSalud(boolean salud) {
		this.salud = salud;
	}
	public String getRaza() {
		return raza;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
}
