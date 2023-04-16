package fp.conflict;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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

	
	
}
