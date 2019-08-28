package vista;
import java.util.ArrayList;

import controlador.PetControl;
import controlador.VeteControl;
import modelo.Mascota;
import modelo.empleados;
import modelo.implementa.MascoImp;
import modelo.implementa.VeteImp;

public class test {

	public static void main(String[] args) {
		VeteControl v = new VeteControl(new VeteImp(new ArrayList<empleados>()));
		PetControl p= new PetControl(new MascoImp(new ArrayList<Mascota>()));
		empleados t = v.emplear("estilista", "matias", "de la fuente", 23, 01);
		p.atender("pez", "raul", "payaso", 1, 2);
		v.tratar(p,t);

	}
}
