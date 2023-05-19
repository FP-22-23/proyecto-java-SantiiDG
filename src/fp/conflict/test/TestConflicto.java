	package fp.conflict.test;

import java.time.LocalDate;

import fp.common.Victima;
import fp.conflict.Conflicto;

public class TestConflicto {

	public static void main(String[] args) {
		//test constructor 1
		Conflicto c= new Conflicto(-90000,"DRC18042",LocalDate.of(2020,8,1),"Protests","Gemena",19.76,0, false, null,null, new Victima("Manuel", "Jimenez", "arquitecto"));
		
		c.añadeGruposArmados("Mazembe");
		c.añadeGruposArmados("Mazembow");

		System.out.println(c);
		
		
		//test constructor 2
		Conflicto c1= new Conflicto(7173389,"DRC18042",LocalDate.of(2020,8,1),"Gemena",19.76,0);
		System.out.println(c1);
	
		//test getters
		System.out.println("getter dataId " + c.getDataId());
		System.out.println("getter eventId " + c.getEventId());
		System.out.println("getter date " + c.getDate());
		System.out.println("getter type " + c.getType());
		System.out.println("getter location " + c.getLocation());
		System.out.println("getter longitude " + c.getLongitude());
		System.out.println("getter fatalities " + c.getFatalities() );
		System.out.println("getter firearm " + c.getFirearm());
		System.out.println("getter importanciaDerivada " + c.importanciaDerivada());
		System.out.println("getter gruposArmados" + c.getGruposArmados());
		System.out.println("getter victima " + c.getVictima());
		
	
		//try catch para las restricciones
		try {
			c.setDataId(-90000);
		}
		catch(Exception e) {
			System.out.println("dataId no puede ser negativo");
			c.setDataId(7173389);
		}
	
		try {
			c.setType(" ");
		}
		catch(Exception e) {
			System.out.println("el tipo de conflicto no pude estar vacio");
			c.setType("Protests");
		}
		
	}
}