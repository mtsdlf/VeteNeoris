package modelo.implementa;

import java.util.ArrayList;
import controlador.PetControl;
import modelo.Mascota;
import modelo.Turnos;
import modelo.empleados;
import modelo.empleado.Estilista;
import modelo.empleado.Veterinario;
import modelo.interfaces.Ejecutiva;

public class VeteImp implements Ejecutiva<PetControl,empleados> {
	private ArrayList<empleados> empleados;

	public VeteImp(ArrayList<empleados> empleados) {
		this.empleados=empleados;	
	}
	
	@Override
	public empleados emplear(String empleado, String nombre, String apellido, int edad, int idLegajo) {
		modelo.empleados newEmp = null;
		if (empleado.toLowerCase()   		/*Por alguna razon no entra en el if si el empleado es Veterinario*/
	    		.equals("veterinario")){	/*Si fue aplicado igualmente en estilistas*/
	    	newEmp = new Veterinario(nombre, apellido, edad, idLegajo);
			this.empleados.add(newEmp);  
	    }
	    if (empleado.toLowerCase()
	    		.equals("estilista")){
	    	newEmp = new Estilista(nombre, apellido, edad, idLegajo);
			this.empleados.add(newEmp);  
	    }
	    else {System.out.println("no es un empleado valido");}
		return newEmp;
	}

	@Override
	public Turnos tratar(PetControl pC, String tipo) {
		Mascota ultima= pC.getMascotas().get(0);
		Turnos turno = new Turnos(ultima,this.getFreeTipo(null,tipo)); /*Da turno con el primer especialista disponible
		 															a traves de un String que indica su clase		*/												
			if (tipo == "veterinario".toLowerCase()) {				//deseada
				ultima.setSalud(true);
			}
			if (tipo == "estilistas".toLowerCase()) {			
				ultima.setSalud(true);
			}	
		return turno;		
	}

	public Turnos tratar(PetControl controlador, modelo.empleados sujeto) {
		Mascota ultima= controlador.getMascotas().get(0);
		Turnos turno = new Turnos(ultima,sujeto);
			if (sujeto instanceof Veterinario) {			
				ultima.setSalud(true);
			}
			if (sujeto instanceof Estilista) {			
				ultima.setBonito(true);
			}	
		return turno;		
	}
	
	@Override
	public empleados getFreeTipo(PetControl pC,String tipo) {
		empleados empleado = null;
		if (empleados.size()>0 && 
				empleados.size()<=4) 
		{
			for (int i=0; i<empleados.size(); i++) {
				if (empleados.get(i).getAtendidos().size()<=5 										 // Si el empleado la lista atendio hasta 5 mascotas
						&& tipo.toLowerCase().equals(empleados.get(i).getTipo().toLowerCase())) {   //&& su nombre simple de clase es igual al parametro tipo //
					empleado=empleados.get(i);
					break;
				}else {System.out.println("No hay doctores disponibles");}			
			}
		}
		return empleado;
	}

	public ArrayList<empleados> getEmpleados() {
		return empleados;
	}	
}
	
	
	