package fp.conflict.test;

import fp.conflict.Conflictos;
import fp.conflict.ContenedorConflictos;

public class TestConflictos {

	public static void main(String[] args) {
		Conflictos c = new ContenedorConflictos();
		Conflictos cf = c.of("data/conflict_data_cod.csv");
		
		
//Test metodos tratamientos secuenciales
		
System.out.println("existeConflictoConNFatalities: " + cf.existeConflictoConNFatalities(0));
System.out.println("getSumaFatalities: " + cf.getSumaFatalities());
System.out.println("getConflictosSitio: " + cf.getConflictosSitio("Kabakaba"));
System.out.println("ConflictosId: " + cf.ConflictosId(7173385));
System.out.println("ConteoConflictosPorLocalizacion: " + cf.ConteoConflictosPorLocalizacion());
		
	
//Test de metodos de Streams
System.out.println("existeConflictoConNFatalitiesStreams: " + cf.existeConflictoConNFatalitiesStreams(0));
System.out.println("getSumaFatalitiesStreams:  " + cf.getSumaFatalitiesStreams());
System.out.println("getConflictosSitioStreams: " + cf.getConflictosSitioStreams("Kabakaba"));
System.out.println("getMaxMuertesSitio: " + cf.getMaxMuertesSitio("Kabakaba"));
System.out.println("getConflictosSitioOrdenadosPorMuertes: " + cf.getConflictosSitioOrdenadosPorMuertes("Kabakaba"));
System.out.println("ConteoConflictosPorLocalizacionStreams:  " + cf.ConteoConflictosPorLocalizacionStreams());
System.out.println("ConflictosSitios: "+ cf.ConflictosSitios());
System.out.println("tipoConflictoMaxMuertes: " + cf.tipoConflictoMaxMuertes());
System.out.println("localizacionesNMayorNumeroFatalities: "+ cf.localizacionesNMayorNumeroFatalities(5));
System.out.println("mayorConflicto: "  + cf.mayorConflicto());







		
}
	
}
