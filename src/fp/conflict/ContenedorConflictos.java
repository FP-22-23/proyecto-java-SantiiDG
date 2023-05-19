package fp.conflict;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContenedorConflictos implements Conflictos{
	
	//Una propiedad de tipo Collection
	private List<Conflicto> conflictos;
	
	
	//C1 
	//Uno con todas las propiedades básicas (excepto la colección), 
	//que cree un objeto de tipo contenedor sin ningún elemento en la colección
	
	public ContenedorConflictos() {
		conflictos = new ArrayList<Conflicto>();
		
	}
	
	//C2 
	//Otro con todas las propiedades básicas y una colección de objetos del 
	//tipo base, que cree un objeto de tipo contenedor con todos los elementos 
	//de la colección.
	
	public ContenedorConflictos(Collection<Conflicto> conflictos) {
		this.conflictos = new ArrayList<Conflicto>(conflictos);
	}
	
	//C3
	//Añadir al tipo contenedor un tercer constructor con todas las propiedades básicas (excepto la colección) y un stream
	//de objetos del tipo base, que cree un objeto del tipo contenedor con todos los elementos del stream.
	
	public ContenedorConflictos(Stream<Conflicto> strm) {
		this.conflictos = strm.collect(Collectors.toList());
		
	}
	
	
	//METODO AUXILIAR QUE HE CREADO PARA LA LECTURA DEL FICHERO//
	 public Conflictos of (String nombreFichero) {
		 List<Conflicto> conflictos= FactoriaConflicto.leerConflicto(nombreFichero);
		 return new ContenedorConflictos(conflictos);
	 }
	


	//Equals, Hashcode y toString
	
	@Override
	public int hashCode() {
		return Objects.hash(conflictos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContenedorConflictos other = (ContenedorConflictos) obj;
		return Objects.equals(conflictos, other.conflictos);
	}

	@Override
	public String toString() {
		return "ConflictosBuclesImpl [conflictos=" + conflictos + "]";
	}
	
//	Obtener el número de elementos.
//	Añadir un elemento.
//	Añadir una colección de elementos.
//	Eliminar un elemento.
	
	public Integer getNumeroConflictos() {
		return conflictos.size();
	}
	
	public void añadirConflictos(Conflicto c) {
		conflictos.add(c);
	}
	
	public void añadirCollectionConflictos(Collection<Conflicto> c) {
		conflictos.addAll(c);
	}
	
	public void eliminarConflicto(Conflicto c) {
		conflictos.remove(c);
	}
	
	//1º A escoger uno de los dos siguientes: existe / para todo.
	
	//existe
	
	public Boolean existeConflictoConNFatalities(Integer n) {
		Boolean res = false;
		for (Conflicto c: conflictos) { //this.confictos?
			if(c.getFatalities().equals(n)) {
				res=true;
			}
		}
		return res;
	}
	
	//2º A escoger uno de los tres siguientes: contador / suma / media.
	//suma

	public Integer getSumaFatalities() {
		Integer suma =0;
		for (Conflicto p: conflictos) {
				suma+= p.getFatalities();
		}
		return suma;
		
	}

	//3º Una selección con filtrado.
	//Nos devuelve los conflictos ocurridos en el lugar que pasamos como parámetro
	public List<Conflicto> getConflictosSitio(String location){
		List<Conflicto> filtradas = new ArrayList<Conflicto>();
		for (Conflicto p : conflictos) {
			if(p.getLocation().equals(location)) {
				filtradas.add(p);
			}
				
		}
		return filtradas;
		
	}
	
	//4º Un método de agrupación que devuelva un Map en el que las claves sean
	//	una propiedad del tipo base, y los valores una colección (List, Set, 
	//	SortedSet) de objetos del tipo base.

	//	Devuelve un Map en el que las claves son el event type y los valores una listas de tipo Conflicto
	//	los cuales deben tener un id mayor al que entramos por parámetro
	
	public Map<String, List<Conflicto>> ConflictosId(Integer id) {
		Map<String, List<Conflicto>> res = new HashMap<String, List<Conflicto>>();
		for(Conflicto p:this.conflictos) {
			String clave = p.getType();
			if(p.getDataId() > id){
				if(!res.containsKey(clave)) {
					List<Conflicto> listaAux = new ArrayList<Conflicto>();
					listaAux.add(p);
					res.put(clave, listaAux);
				}else {
					res.get(clave).add(p);
				}
				
				
			}
		}
		return res;
	}

	//5º Un método de acumulación que devuelva un Map en el que las claves sean 
	//	una propiedad del tipo base, y los valores el conteo o la suma de los 
	//	objetos del tipo base almacenados en el contenedor que tienen como valor
	//	esa propiedad.
	
	
	//	Devuelve un Map en el que las claves son las localiciones y los valores el número de conflictos
	//  ocurridos en esa dicha localizacion
	
	public Map<String, Integer> ConteoConflictosPorLocalizacion(){
		Map<String, Integer> res= new HashMap<String, Integer>();
		for(Conflicto p: conflictos) {
			String clave = p.getLocation();
			if(res.containsKey(clave)) {
				
			Integer valor = res.get(clave);
			valor++;
			res.put(clave, valor);
			}else {
				res.put(clave, 1);
			}
		}
		return res;
	}
	
	//ENTREGA 3 bloque I
	
	
	 //1º A escoger uno de los dos siguientes: existe / para todo. 
	
	//existe
	//Nos devuelve true o false dependiendo de si existe un conflicto con el numero de 
	//fatalities que le pasemos por parametro o no 
	
	//	public Boolean existeConflictoConNFatalities(Integer n) {
	//		Boolean res = false;
	//		for (Conflicto c: conflictos) { //this.confictos?
	//			if(c.getFatalities().equals(n)) {
	//				res=true;
	//			}
	//		}
	//		return res;
	//	}
	
	public Boolean existeConflictoConNFatalitiesStreams(Integer n) {
		return conflictos.stream().anyMatch(x->x.getFatalities().equals(n));
	}
	
	
	
	
	//2º A escoger uno de los tres siguientes: contador / suma / media.
	//suma
	//Nos devuelve la suma de las todas las muertes 

	//	public Integer getSumaFatalities() {
	//		Integer suma =0;
	//		for (Conflicto p: conflictos) {
	//				suma+= p.getFatalities();
	//		}
	//		return suma;
	//		
	//	}
	
	public Integer getSumaFatalitiesStreams() {
		return conflictos.stream().mapToInt(Conflicto::getFatalities).sum();	}
	
	//3º Una selección con filtrado.
	//Nos devuelve los conflictos ocurridos en el lugar que pasamos como parámetro
	
	//	public List<Conflicto> getConflictosSitio(String location){
	//		List<Conflicto> filtradas = new ArrayList<Conflicto>();
	//		for (Conflicto p : conflictos) {
	//			if(p.getLocation().equals(location)) {
	//				filtradas.add(p);
	//			}
	//				
	//		}
	//		return filtradas;
	//		
	//	}
	
	public List<Conflicto> getConflictosSitioStreams(String location){
		return conflictos.stream().filter(x->x.getLocation().equals(location)).collect(Collectors.toList());
				
	}
	
	//4º Un máximo/mínimo con filtrado
	//Devuelve el conflicto con mayor numero de muertes de la localizacion pasada por parametro
	
	public Conflicto getMaxMuertesSitio(String location) {
		return conflictos.stream().filter(x->x.getLocation().equals(location)).max(Comparator.comparing(Conflicto::getFatalities)).get();
	}
	
	//5º Una selección, con filtrado y ordenación
	//Esta funcion devuelve una lista con los conflictos de la localizacion que pasamos
	//por parametro ordenados segun el numero de muertes de mayor a menor
	
	public List<Conflicto> getConflictosSitioOrdenadosPorMuertes(String location){
		return conflictos.stream().filter(x->x.getLocation().equals(location)).sorted(Comparator.comparing(Conflicto::getFatalities).reversed()).toList();
	}
	
	//BLOQUE 2 
	
	//6º Uno de los métodos (4) o (5) implementados en la entrega 2, pero con streams
	//5
	
	//	public Map<String, Integer> ConteoConflictosPorLocalizacion(){
	//		Map<String, Integer> res= new HashMap<String, Integer>();
	//		for(Conflicto p: conflictos) {
	//			String clave = p.getLocation();
	//			if(res.containsKey(clave)) {
	//				
	//			Integer valor = res.get(clave);
	//			valor++;
	//			res.put(clave, valor);
	//			}else {
	//				res.put(clave, 1);
	//			}
	//		}
	//		return res;
	//	}
	
	//	Devuelve un Map en el que las claves son las localiciones y los valores el número de conflictos
	//  ocurridos en esa dicha localizacion
	
	public Map<String,Integer> ConteoConflictosPorLocalizacionStreams(){
		return conflictos.stream().collect(Collectors.groupingBy(Conflicto::getLocation, Collectors.summingInt(e -> 1)));
	}
	
	
	//7º Un método en cuya implementación se use, o bien el Collector collectingAndThen, o bien el Collector mapping.
	//Collector mapping
	//Esta funcion devuelve una lista con las ubicaciones de los conflictos haciendo uso del Collector mapping
	
	public List<String> ConflictosSitios(){
		return conflictos.stream().collect(Collectors.mapping(Conflicto::getLocation, Collectors.toList()));
	}
	
	
	//8º Un método que devuelva un Map en el que las claves sean un atributo o una función sobre un atributo, y los valores 
	//son máximos/mínimos de los elementos que tienen ese valor
	
	//Nos devuelve un map en el que las claves son el tipo de conflicto y las claves el maximo numero de fatalities en dicho tipo de conflicto

	public Map<String, Integer> tipoConflictoMaxMuertes(){
	    return conflictos.stream().collect(Collectors.toMap(Conflicto::getType, Conflicto::getFatalities, Integer::max) 
	    );	//La función Integer::max se utiliza como tercer argumento para resolver las colisiones de claves, es decir, cuando hay 
			//dos o más elementos en el Stream con la misma clave. En ese caso, la función max() elige el valor máximo de las colisiones para esa clave.
	}
	
	//9ºUn método que devuelva un SortedMap en el que las claves sean un atributo o una función sobre un atributo, 
	//y los valores sean listas con los n mejores o peores elementos que comparten el valor de ese atributo (o función sobre el atributo)

	//Esta funcion nos devuelve un sortedMap en el que los valores son las localizaciones y las claves son una lista de los 
	//N mayores numeros de Fatalities en ese lugar

	public SortedMap<String, List<Integer>> localizacionesNMayorNumeroFatalities(Integer N) {
	    return conflictos.stream()
	            .collect(Collectors.groupingBy(Conflicto::getLocation, TreeMap::new,
	                    Collectors.collectingAndThen(Collectors.toList(),
	                            x -> x.stream()
	                                    .map(Conflicto::getFatalities)
	                                    .sorted(Comparator.reverseOrder())
	                                    .limit(N)
	                                    .collect(Collectors.toList()))));
	}

	//10º Un método que calcule un Map y devuelva la clave con el valor asociado (mayor o menor) de todo el Map
	
	//Esta funcion devuelve la localizacion con mayor numero de Fatalities

	public String mayorConflicto() {
	    return conflictos.stream()
	            .collect(Collectors.groupingBy(Conflicto::getLocation,
	                    Collectors.summingInt(Conflicto::getFatalities)))
	            .entrySet().stream()
	            .max(Map.Entry.comparingByValue())
	            .map(Map.Entry::getKey)
	            .orElse(null); // o algún valor por defecto en caso de que no haya ubicaciones disponibles
	    
	}






	
	
	
}
