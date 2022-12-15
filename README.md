# ApiRestPokemon
 A) [Objetivo](#objetivo-info) Crear un endpoint con JAVA (spring boot java) utilizando SOAP para consumir una API tipo rest ej. (https://pokeapi.co/api/v2/pokemon/


El desarrollo consiste en consumir la API rest de https://pokeapi.co/ y en base a lo que retorna crear un endpoint en SOAP con los siguientes métodos:
* [abilities](#abilities-info) 
* [base_experience](#base_experience-info)  
* [held_items](#held_items-info) 
* [id](#id-info) 
* [name](#name-info) 
* [location_area_encounters](#location_area_encounters-info)  

Todos los métodos tienen que aceptar como parámetro como String al pokemon ya que la búsqueda tiene ser en tiempo real de https://pokeapi.co/


B) Se tiene que guardar en una base de datos h2, mysql, etc. Los request de las peticiones guardando como variables:


* [ip de origin ](#iporigin-info)
* [fecha de request](#fecha-info)
* [método que se ejecuta](#metodo-info)
* [Se puede utilizar: mybatis, hibernate, spring jdbc, como extra se puede crear un pool de conexiones](#util-info)

# Endpoints consumo api

* [http://localhost:8080/api/pokemon/abilities/1](#api1-info)
* [http://localhost:8080/api/pokemon/experience/1](#api2-info)
* [http://localhost:8080/api/pokemon/helditem/1](#api3-info)
* [http://localhost:8080/api/pokemon/location/1](#api4-info)
* [http://localhost:8080/api/pokemon/version/1](#api5-info)
* [http://localhost:8080/api/pokemon/move/1](#api6-info)
