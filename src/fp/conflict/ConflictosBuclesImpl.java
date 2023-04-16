package fp.conflict;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ConflictosBuclesImpl implements Conflictos{
	
	//una propiedad de tipo collection
	private List<Conflicto> conflictos;
	
	
	//c1 no con todas las propiedades básicas (excepto la colección), 
	//que cree un objeto de tipo contenedor sin ningún elemento en la colección
	
	public ConflictosBuclesImpl() {
		conflictos = new ArrayList<Conflicto>();
		
	}
	
	//c2 Otro con todas las propiedades básicas y una colección de objetos del 
	//tipo base, que cree un objeto de tipo contenedor con todos los elementos 
	//de la colección.
	
	public ConflictosBuclesImpl(Collection<Conflicto> conflictos) {
		this.conflictos = new ArrayList<Conflicto>(conflictos);
	}
	
	
	//METODO AUXILIAR QUE HE CREADO PARA LA LECTURA DEL FICHERO//
	 public Conflictos of (String nombreFichero) {
		 List<Conflicto> conflictos= FactoriaConflicto.leerConflicto(nombreFichero);
		 return new ConflictosBuclesImpl(conflictos);
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
		ConflictosBuclesImpl other = (ConflictosBuclesImpl) obj;
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
}
