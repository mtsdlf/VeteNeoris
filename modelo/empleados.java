package modelo;

import java.util.ArrayList;

public abstract class empleados {
	private String nombre, apellido,tipo;
	private int edad, idLegajo;
	private ArrayList<Mascota> atendidos;	
	private ArrayList<Turnos> turnos;
	
	public empleados(String nombre, String apellido, int edad, int idLegajo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.idLegajo = idLegajo;
		tipo = this.getClass().getSimpleName(); //Se determina su funcion de negocio a traves del nombre de su clase/*
		atendidos=new ArrayList<Mascota>();
	}

	public String getTipo() {
		return tipo;
	}

	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getEdad() {
		return edad;
	}
	public int getIdLegajo() {
		return idLegajo;
	}
	
	public ArrayList<Turnos> getTurnos() {
		return turnos;
	}

	public void setTurnos(ArrayList<Turnos> turnos) {
		this.turnos = turnos;
	}
	public ArrayList<Mascota> getAtendidos() {
		return atendidos;
	}
	
	public void setAtendidos(ArrayList<Mascota> atendidos) {
		this.atendidos = atendidos;
	}	
}
