package modelo.interfaces;

import modelo.Turnos;
import modelo.empleados;

public interface Ejecutiva<Ctrl,T> {

	public T emplear(String tipo, String nombre, String apellidoRaza, int edad, int id);
	public Turnos tratar(Ctrl controlador,String tipo);
	public empleados getFreeTipo(Ctrl Controlador,String tipo);
}
