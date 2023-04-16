# Proyecto del Segundo Cuatrimestre Fundamentos de Programacion (Curso  \<22\>/\<23\>)
Autor/a: \<Santiago Diestro Gallego\>   uvus:\<sandiegal\>

Este proyecto tiene como objetivo es escoger y manipular un dataset e implementar, documentar y probar un tipo base.

## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. 
  * **fp.\<conflict\>**: Paquete que contiene los tipos del proyecto.
  * **fp.\<conflict.test\>**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **\<conflict_data_cod.csv\>**: Este dataset recoge diferentes conflictos en la República Democrática del Congo 

    
## Estructura del *dataset*

URL del dataset: https://www.kaggle.com/manassengudia/drc-conflicts-19972020

El dataset estan compuesto por \<8\> columnas, con la siguiente descripcion:

* **\<columna 1>**: de tipo \<Int\>, representa el numero de identificación de los datos.
* **\<columna 2>**: de tipo \<String\>, representa el id del evento.
* **\<columna 3>**: de tipo \<LocalDate\>, representa la decha del evento.
* **\<columna 4>**: de tipo \<String\>, representa tipo del evento.
* **\<columna 5>**: de tipo \<String\>, representa la localización del evento.
* **\<columna 6>**: de tipo \<Double\>, representa la longitud de la localizacion.
* **\<columna 7>**: de tipo \<Integer\>, representa el numero de víctimas.
* **\<columna 8>**: de tipo \<Boolean\>, representa el uso o no de armas de fuego.


## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - Conflicto
Representa un conflicto concreto.
**Propiedades**:
- _dataId_, de tipo _Integer_, consultable. Indica el id de los datos. 
- _eventId_, de tipo _String_, consultable. Indica el id del evento.
- _date_, de tipo _LocalDate_, consultable. Indica la fecha del evento.
- _type_, de tipo _String_, consultable. Indica el tipo del evento.
- _location_, de tipo _String_, consultable. Indica la localización del evento.
- _longitude_, de tipo _Double_, consultable. Indica la longitud de la localización del evento.
- _fatalities_, de tipo _Integer_, consultable. Indica el número de victimas.
- _firearm_, de tipo _List\<Boolean\>_, consultable. Indica si han sido usadas armas de fuego o no.
- _importanciaDerivada_, de tipo _Imporatancia_, consultable. Indica la importancia del evento. Puede tomar los valores	GRANDE,MEDIA,PEQUEÑA
- _gruposArmados_, de tipo _List<String>_, consultable. Son los diferentes grupos armados que han actuado en el conflicto.
- _victima_, de tipo _Victima_, consultable. Indica los datos de las víctimas del conflicto.


**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Crea un objeto de tipo Conflicto a partir de los siguientes parámetros: Integer dataId, String eventId, LocalDate date, String location, Double longitude, Integer fatalities

**Restricciones**:
 
- R1: dataId no puede ser mayor de 8000000.
- R2: el tipo del conflicto no puede estar vacio.
***Criterio de igualdad**: Dos partidas son iguales si todas sus dataId y eventId coinciden.

**Criterio de ordenación**: Por eventId y firearm.

**Otras operaciones**: añadeGruposArmados, función la cual nos permite añadir los nombres de los grupos armados a la lista gruposArmados.

#### Tipos auxiliares

- Importancia, ENUMERADO. Puede tomar los valores GRANDE,MEDIA,PEQUEÑA.
- Victima. Representa los datos de la víctimas.


## FactoriaConflicto

- leerConflicto: recibe como parámetro una cadena con el formato de las líneas del fichero CSV, y devuelve un objeto del tipo a partir de esa cadena.

- parsearConflicto: recibe como parámetro una cadena que contiene el nombre y ruta del fichero CSV, y devuelve una lista de objetos del tipo.

## Conflictos (Interfaz)

- En esta interfaz se encuentran todos los metodos utilizados en los tipos contenedores.

## Tipo ContenedorBuclesImpl

**Propiedades**:
	
- conflictos de tipo _List\<Partida\>_, consultable. 

**Constructores**:

-C1: tiene todas las propiedades básicas excepto conflicto, y crea un objeto de tipo contenedor sin ningún elemento en la colección.

-C2: otro con todas las propiedades básicas y una colección de objetos del tipo base, que crea un objeto de tipo contenedor con todos los elementos 
de la colección.

**Criterio de igualdad**: comprueba la igualdad entre dos propiedades.

**Otras operaciones**:
-getNumeroConflictos: permite obtener el numero de elementos de conflictos

-añadirConflictos: permite añadir un elemento a conflictos

-añadirCollectionConflictos: permite añadir una colección a conflictos

-eliminarConflicto: permite eliminar un elemento de conflictos

-existeConflictoConNFatalities: comprueba si existe algún conflicto que tenga el numero de muertes que le pasamos como parámetro.

-getSumaFatalities: calcula la suma de todos las muertes de los conflictos.

-getConflictosSitio: devuelve los conflictos ocurridos en el lugar que pasamos como parámetro.

-ConflictoId: Devuelve un Map en el que las claves son el event type y los valores una listas de tipo Conflicto los cuales deben tener un id mayor al que entramos por parámetro
 
-ConteoConflictosPorLocalizacion: Devuelve un Map en el que las claves son las localiciones y los valores el número de conflictos
ocurridos en esa dicha localizacion

 