package modelo.implementa;

import java.util.ArrayList;

import controlador.VeteControl;
import modelo.Mascota;
import modelo.Turnos;
import modelo.empleados;
import modelo.interfaces.Ejecutiva;
import modelo.mascotas.Gato;
import modelo.mascotas.Perro;
import modelo.mascotas.Pez;

public class MascoImp implements Ejecutiva<VeteControl,Mascota>{
	private ArrayList<Mascota> mascotas;
	
	public MascoImp(ArrayList<Mascota> mascotas) {
		this.mascotas=mascotas;	
	}

	@Override
	public Mascota emplear(String tipo, String nombre, String raza, int edad, int id) {
		Mascota newPet = null;
		if (tipo.toLowerCase()
				.equals("perro")) { 			   	 // Se elige a partir del parametro String
			newPet=new Perro(nombre, raza, edad);	//que objeto se va a crear 
			this.mascotas.add(newPet);
	    }
		if (tipo.toLowerCase()
				.equals("gato")) {
			newPet=new Gato(nombre, raza, edad);
			this.mascotas.add(newPet);
	    }
		if (tipo.toLowerCase()
				.equals("pez")) {
			newPet=new Pez(nombre, raza, edad);
			this.mascotas.add(newPet);
	    }
	    else {System.out.println("Eso no es una mascota");
	    }
		mascotas.add(newPet);
		return newPet;	
	}

	public Turnos tratar(VeteControl controlador, empleados emp ) {
		Turnos turno = new Turnos(null,null);
		for (int i=0; mascotas.size()>i && i<=20; i++) {
			if(mascotas.get(i).isSalud()==false)
			{	Mascota enferma = mascotas.get(i);	
				turno.setEmpleado(this.getFreeTipo(
						controlador,emp.getClass().getSimpleName().toLowerCase()));			 //Da turno con el primer especialista disponible	 	
				if (emp.getClass().getSimpleName().toLowerCase().equals("veterinario")) {	//a traves de un String que indica su clase	deseada
					enferma.setSalud(true);
				}
				if (emp.getClass().getSimpleName().toLowerCase().equals("estilista")) {			
					enferma.setBonito(true);
				}	
			}
		}return turno;	
	}


	public Turnos tratar(VeteControl controlador, String tipo) {
		Turnos turno = new Turnos(null,null);
			for (int i=0; mascotas.size()>i; i++) {
				if(mascotas.get(i).isSalud()==false)
				{	Mascota enferma = mascotas.get(i);
					turno.setPaciente(enferma);
					turno.setEmpleado(this.getFreeTipo(controlador,tipo));		/*Da turno con el primer especialista disponible
		 																	a traves de un String que indica su clase		*/												
				if (tipo == "veterinario".toLowerCase()) {					//deseada
					enferma.setSalud(true);
				}
				if (tipo == "estilistas".toLowerCase()) {			
					enferma.setBonito(true);
				}	
			}
		}return turno;
	}
					
	public empleados getFreeTipo(VeteControl controlador, String tipo) {
		ArrayList<empleados> empleados = controlador.getEmpleados();
		empleados empleado = null;
		if (empleados.size()<=4) 
		{
			for (int i=0; i<empleados.size(); i++) {
				if (((modelo.empleados) empleados.get(i)).getAtendidos().size()<=5 										 // Si el empleado la lista atendio hasta 5 mascotas
						&& tipo.toLowerCase().equals(((modelo.empleados) empleados.get(i)).getTipo().toLowerCase())) {   //&& su nombre simple de clase es igual al parametro tipo //
					empleado=(modelo.empleados) empleados.get(i);
					break;
				}else {System.out.println("No hay " +tipo+"s disponibles");}			
			}
		}
		return empleado;
	}

	public ArrayList<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(ArrayList<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
}
