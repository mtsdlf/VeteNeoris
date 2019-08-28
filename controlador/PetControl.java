package controlador;

import java.util.ArrayList;
import modelo.Mascota;
import modelo.empleados;
import modelo.implementa.MascoImp;

public class PetControl {
	public MascoImp veterinaria;
	public PetControl(MascoImp petImp) {
		this.veterinaria=petImp;
		}
	
	public void atender(String tipo,String nombre,String apellido,int edad,int idLegajo) {
		this.veterinaria.emplear(tipo, nombre, apellido, edad, idLegajo);	
	}

	public void emplear(String tipo,String nombre,String apellido,int edad,int idLegajo) {
		this.veterinaria.emplear(tipo, nombre, apellido, edad, idLegajo);	
	}

	public void tratar(VeteControl vT, empleados emp) {
		this.veterinaria.tratar(vT, emp);
	}

	public ArrayList<Mascota> getMascotas() {
		return this.veterinaria.getMascotas();
	}
	
}