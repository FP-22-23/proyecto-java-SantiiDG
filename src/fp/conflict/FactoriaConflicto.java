package fp.conflict;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class FactoriaConflicto {
	//Lectura de fichero
	public static List<Conflicto> leerConflicto(String rutaFichero) { //lectura de fichero
		List<Conflicto> res = null;
		try {
			List<Conflicto> listaLectura =
					Files.lines(Paths.get(rutaFichero)).
					skip(1)
					.map(FactoriaConflicto::parsearConflicto)
					.collect(Collectors.toList());

			res = listaLectura ;
			
		}catch(IOException e) {
			System.out.println("no se encuentra el fichero " + rutaFichero);
			
		}
		return res;
	}
	
	//PARSING
	public static Conflicto parsearConflicto(String lineaCSV) {

		Conflicto res;

		String[] trozos = lineaCSV.split(";");
	    System.out.println(Arrays.toString(trozos)); // Imprimir los valores en trozos

		Checkers.check("error en el numero de elementos", trozos.length==8);
		Integer dataId= Integer.valueOf(trozos[0].trim());
		String eventId = trozos[1].trim();
		LocalDate date = LocalDate.parse(trozos[2].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String type = trozos[3].trim();
		String location = trozos[4].trim();
		Double longitude = Double.valueOf(trozos[5].trim());
		Integer fatalities = Integer.valueOf(trozos[6].trim());
		Boolean firearm = Boolean.valueOf(trozos[7].trim());
		
		res = new Conflicto(dataId, eventId, date, type, location, longitude, fatalities, firearm, null, null, null);
		return res;
	
	}
	//	Añadir a la factoría un método que recibe como parámetro una cadena que contiene el nombre y ruta del fichero CSV,
	//	y devuelve un objeto del tipo contenedor creado mediante el constructor anterior.

	public static ContenedorConflictos leerConflictoStrm(String rutaFichero) { 
		
	    try {
	        Stream<Conflicto> listaLectura =
	                Files.lines(Paths.get(rutaFichero)).
	                skip(1).
	                map(FactoriaConflicto::parsearConflicto);
	        
	        return new ContenedorConflictos(listaLectura);
	       
	        
	    } catch (IOException e) {
	        System.out.println("No se encuentra el fichero " + rutaFichero);
	        return null;
	        
	    }
	    
	}

	
	
	
	
	
	
	
	
	
}
