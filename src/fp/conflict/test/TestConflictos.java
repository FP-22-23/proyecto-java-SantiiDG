package fp.conflict.test;


import fp.conflict.Conflictos;
import fp.conflict.ConflictosBuclesImpl;

public class TestConflictos {

	public static void main(String[] args) {
		Conflictos c = new ConflictosBuclesImpl();
		Conflictos cf = c.of("data/conflict_data_cod.csv");
		
//Test metodos tratamientos secuenciales
		
System.out.println("existeConflictoConNFatalities " + cf.existeConflictoConNFatalities(0));
System.out.println("getSumaLongitud " + cf.getSumaFatalities());
System.out.println("getConflictosSitio " + cf.getConflictosSitio("Butembo"));
System.out.println("ConflictosId " + cf.ConflictosId(7173385));
System.out.println("ConteoConflictosPorLocalizacion " + cf.ConteoConflictosPorLocalizacion());
		
		
	

		
}
	
}
