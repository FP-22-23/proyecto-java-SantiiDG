package fp.conflict;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import fp.common.Importancia;
import fp.common.Victima;
import fp.utiles.Checkers;

public class Conflicto {
	private Integer dataId;
	private String eventId;
	private LocalDate date;
	private String type;
	private String location;
	private Double longitude;
	private Integer fatalities;
	private Boolean firearm;
	private Importancia importanciaDerivada;
	private List<String> gruposArmados;
	private Victima victima;
	
	
	//Propiedad derivada
	public Importancia importanciaDerivada() {
		Importancia res = null; {
			if(this.getFatalities()<=0) {
				res=Importancia.PEQUEÑA;
			}else if(this.getFatalities()>0 && this.getFatalities()<2) {
				res=Importancia.MEDIA;
			}else {
				res=Importancia.GRANDE;
			}
			return res;
		}
	}
	
	//C1
	
	

	public Conflicto(Integer dataId, String eventId, LocalDate date, String type, String location,
			Double longitude, Integer fatalities, Boolean firearm, Importancia importanciaDerivada,List<String> gruposArmados,Victima victima) {
		//Restriccion1
		Checkers.check("dataId no puede ser mayor de 8000000", dataId<=8000000);
		
		//Restriccion2
		Checkers.checkNoNull("el tipo del conflicto no puede estar vacio", type== " ");
		this.dataId=dataId;
		this.eventId=eventId;
		this.date = date; 
        this.type = type;
        this.location = location;
        this.longitude = longitude;
        this.fatalities = fatalities;
        this.firearm = firearm;
		this.importanciaDerivada= importanciaDerivada;
		this.gruposArmados= new LinkedList <String>();
		this.victima = victima;
		
	}
	
	//C2
	
	public Conflicto(Integer dataId, String eventId, LocalDate date, String location,
			Double longitude, Integer fatalities) {
		//Restriccion
		Checkers.check("dataId no puede ser mayor de 8000000", dataId<=8000000);
		this.dataId=dataId;
		this.eventId=eventId;
		this.date = date; 
        this.location = location;
        this.longitude = longitude;
        this.fatalities = fatalities;
  
		
	}
	
	
	
	//Representación como cadena
	
	@Override
	public String toString() {
		return "Conflicto [dataId=" + dataId + ", eventId=" + eventId + ", date=" + date + ", type=" + type
				+ ", location=" + location + ", longitude=" + longitude + ", fatalities=" + fatalities + ", firearm="
				+ firearm + ", importanciaDerivada=" + importanciaDerivada + ", gruposArmados=" + gruposArmados
				+ ", victima=" + victima + "]";
	}
	
	
	//Criterio de igualdad

	@Override
	public int hashCode() {
		return Objects.hash(dataId, eventId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conflicto other = (Conflicto) obj;
		return Objects.equals(dataId, other.dataId) && Objects.equals(eventId, other.eventId);
	}

	
	//Criterio de orden natural
	
	public int compareTo(Conflicto p) {
		int res = 0;  
		if (res!=0) {
		   res = getEventId().compareTo(p.getEventId());
		}
		if (res == 0) {
			res= getFirearm().compareTo(p.getFirearm());
		}
		
		return res;
		
	}
	
	
	
	//Getters y Setters

	public Integer getDataId() {
		return dataId;
	}
	
	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Integer getFatalities() {
		return fatalities;
	}
	public void setFatalities(Integer fatalities) {
		this.fatalities = fatalities;
	}
	public Boolean getFirearm() {
		return firearm;
	}
	public void setFirearm(Boolean firearm) {
		this.firearm = firearm;
	}

	public Importancia getImportanciaDerivada() {
		return importanciaDerivada;
	}

	public void setImportanciaDerivada(Importancia importanciaDerivada) {
		this.importanciaDerivada = importanciaDerivada;
	}
	public List<String> getGruposArmados() {
		return gruposArmados;
	}

	public void setGruposArmados(List<String> gruposArmados) {
		this.gruposArmados = gruposArmados;
	}

	public Victima getVictima() {
		return victima;
	}

	public void setVictima(Victima victima) {
		this.victima = victima;
	}
	
	//metodo para añadir grupos armados a la propiedad tipo lista
	public void añadeGruposArmados(String nombre) {
		gruposArmados.add(nombre);
	}
	
}
