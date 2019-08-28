package controlador;


import java.util.ArrayList;

import modelo.empleados;
import modelo.implementa.VeteImp;

public class VeteControl {
	public VeteImp ejecutiva;
	public VeteControl(VeteImp fabrica) {
		this.ejecutiva=fabrica;
		}
	
	public empleados emplear(String empleado,String nombre,String apellido,int edad,int idLegajo) {
		return this.ejecutiva.emplear(empleado, nombre, apellido, edad, idLegajo);
	}
	public ArrayList<empleados> getEmpleados() {
		return this.ejecutiva.getEmpleados();	
	}

	public void tratar(PetControl pC, empleados emp) {
		this.ejecutiva.tratar(pC, emp);
	}
	public void tratar(PetControl pC, String tipo) {
		this.ejecutiva.tratar(pC, tipo);
	}
	
	public empleados getFreeTipo(PetControl pC,String tipo) {
		return this.ejecutiva.getFreeTipo( null, tipo);
	}
	
}