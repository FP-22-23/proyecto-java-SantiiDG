package fp.conflict;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public interface Conflictos {
	
	Integer getNumeroConflictos();
	void añadirConflictos(Conflicto c);
	void añadirCollectionConflictos(Collection<Conflicto> c);
	void eliminarConflicto(Conflicto c);
	
	//Metodos tratamientos secuenciales

	Boolean existeConflictoConNFatalities(Integer n);
	Integer getSumaFatalities();
	List<Conflicto> getConflictosSitio(String location);
	Map<String, List<Conflicto>> ConflictosId(Integer id);
	Map<String, Integer> ConteoConflictosPorLocalizacion();
	
	Conflictos of (String nombreFichero) ; //METODO AUXILIAR LECTURA FICHERO BUCLES

	//Metodos Streams
	
	Boolean existeConflictoConNFatalitiesStreams(Integer n);	
	Integer getSumaFatalitiesStreams();
	List<Conflicto> getConflictosSitioStreams(String location);
	Conflicto getMaxMuertesSitio(String location);
	List<Conflicto> getConflictosSitioOrdenadosPorMuertes(String location);
	Map<String, Integer> ConteoConflictosPorLocalizacionStreams();
	public List<String> ConflictosSitios();
	Map<String, Integer> tipoConflictoMaxMuertes();
	SortedMap<String, List<Integer>> localizacionesNMayorNumeroFatalities(Integer N );
	String mayorConflicto();

}
