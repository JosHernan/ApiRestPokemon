package backend.service.apirest.pokemon.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import backend.service.apirest.pokemon.entity.Bitacora;
import backend.service.apirest.pokemon.services.IBitacoraService;

@RestController
@RequestMapping("/api")
public class PokemonController {
	private static final Logger log= LoggerFactory.getLogger(PokemonController.class);
	private RestTemplate restTemplate = new RestTemplate();
	@Autowired
	private IBitacoraService bitacoraService;
	
	@Value("${api.pokemon.ability}")
	private String api_ability;
	
	@Value("${api.pokemon.experience}")
	private String api_experience;
	
	
	
	@Value("${api.pokemon.helditem}")
	private String heldItem;
	
	@Value("${api.pokemon.location}")
	private String location;
	
	@Value("${api.pokemon.version}")
	private String version;
	
	@Value("${api.pokemon.move}")
	private String move;
	
	
	@GetMapping("/pokemon/abilities/{name}")
	public ResponseEntity<?>abilities(@PathVariable String name){
		
			String apisend=api_ability+name;
			Map<String, Object> response= new HashMap<>();
			ResponseEntity<?> responseTemplate=null;
		try {
			log.info("::Consultando el api de habilidades::");
			HttpHeaders headers = new HttpHeaders();
			headers.add("user-agent", "Application");
			HttpEntity<String> entity = new HttpEntity<>(headers);
			responseTemplate = restTemplate.exchange(apisend, HttpMethod.GET, entity, String.class);
			
		} catch (Exception e) {
			log.error("Exception: ocurrio una excepcion en la clase [PokemonController], metodo[abilities]"+ e.getMessage());
			e.printStackTrace();
			response.put("mensaje", "Ocurrio una excepcion al consultar el Api abilities");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			Bitacora obj= new Bitacora();
			obj.setIpOrigin(apisend);
			obj.setMetodo("Metodo Ejecutado: abilities");
			obj.setRequest(String.valueOf(responseTemplate.getStatusCodeValue()));
			bitacoraService.guardar(obj);
			
		} catch (DataAccessException e) {
			log.error("DataAccessException: Ocurrio un error al guardar en la bitacora:"+ e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			response.put("errorDatabase", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		
		return responseTemplate;

	}
	
	@GetMapping("/pokemon/experience/{name}")
	public ResponseEntity<?>baseExperience(@PathVariable String name){
		
			String apisend=api_experience+name;
			Map<String, Object> response= new HashMap<>();
			ResponseEntity<?> responseTemplate=null;
		try {
			log.info("::Consultando el api de experiencias::");
			HttpHeaders headers = new HttpHeaders();
			headers.add("user-agent", "Application");
			HttpEntity<String> entity = new HttpEntity<>(headers);
			responseTemplate = restTemplate.exchange(apisend, HttpMethod.GET, entity, String.class);
			
		} catch (Exception e) {
			log.error("Exception: ocurrio una excepcion en la clase [PokemonController], metodo[baseExperience]"+ e.getMessage());
			e.printStackTrace();
			response.put("mensaje", "Ocurrio una excepcion al consultar el Api base experience");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			Bitacora obj= new Bitacora();
			obj.setIpOrigin(apisend);
			obj.setMetodo("Metodo Ejecutado: baseExperience");
			obj.setRequest(String.valueOf(responseTemplate.getStatusCodeValue()));
			bitacoraService.guardar(obj);
		} catch (DataAccessException e) {
			log.error("DataAccessException: Ocurrio un error al guardar en la bitacora:"+ e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			response.put("errorDatabase", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		
		return responseTemplate;

	}
	
	@GetMapping("/pokemon/helditem/{name}")
	public ResponseEntity<?>heldItem(@PathVariable String name){
		
			String apisend=heldItem+name;
			Map<String, Object> response= new HashMap<>();
			ResponseEntity<?> responseTemplate=null;
		try {
			log.info("::Consultando el api de held item::");
			HttpHeaders headers = new HttpHeaders();
			headers.add("user-agent", "Application");
			HttpEntity<String> entity = new HttpEntity<>(headers);
			responseTemplate = restTemplate.exchange(apisend, HttpMethod.GET, entity, String.class);
			
		} catch (Exception e) {
			log.error("Exception: ocurrio una excepcion en la clase [PokemonController], metodo[heldItem]"+ e.getMessage());
			e.printStackTrace();
			response.put("mensaje", "Ocurrio una excepcion al consultar el Api heldItem");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			Bitacora obj= new Bitacora();
			obj.setIpOrigin(apisend);
			obj.setMetodo("Metodo Ejecutado: helditem");
			obj.setRequest(String.valueOf(responseTemplate.getStatusCodeValue()));
			bitacoraService.guardar(obj);
		} catch (DataAccessException e) {
			log.error("DataAccessException: Ocurrio un error al guardar en la bitacora:"+ e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			response.put("errorDatabase", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		
		return responseTemplate;

	}
	@GetMapping("/pokemon/location/{name}")
	public ResponseEntity<?>location(@PathVariable String name){
		
			String apisend=location+name+"/encounters";
			Map<String, Object> response= new HashMap<>();
			ResponseEntity<?> responseTemplate=null;
		try {
			log.info("::Consultando el api de location::");
			HttpHeaders headers = new HttpHeaders();
			headers.add("user-agent", "Application");
			HttpEntity<String> entity = new HttpEntity<>(headers);
			responseTemplate = restTemplate.exchange(apisend, HttpMethod.GET, entity, String.class);
			
		} catch (Exception e) {
			log.error("Exception: ocurrio una excepcion en la clase [PokemonController], metodo[location]"+ e.getMessage());
			e.printStackTrace();
			response.put("mensaje", "Ocurrio una excepcion al consultar el Api location");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			Bitacora obj= new Bitacora();
			obj.setIpOrigin(apisend);
			obj.setMetodo("Metodo Ejecutado: location");
			obj.setRequest(String.valueOf(responseTemplate.getStatusCodeValue()));
			bitacoraService.guardar(obj);
		} catch (DataAccessException e) {
			log.error("DataAccessException: Ocurrio un error al guardar en la bitacora:"+ e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			response.put("errorDatabase", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		
		return responseTemplate;

	}
	
	@GetMapping("/pokemon/version/{name}")
	public ResponseEntity<?>version(@PathVariable String name){
		
			String apisend=version+name;
			Map<String, Object> response= new HashMap<>();
			ResponseEntity<?> responseTemplate=null;
		try {
			log.info("::Consultando el api de version::");
			HttpHeaders headers = new HttpHeaders();
			headers.add("user-agent", "Application");
			HttpEntity<String> entity = new HttpEntity<>(headers);
			responseTemplate = restTemplate.exchange(apisend, HttpMethod.GET, entity, String.class);
			
		} catch (Exception e) {
			log.error("Exception: ocurrio una excepcion en la clase [PokemonController], metodo[version]"+ e.getMessage());
			e.printStackTrace();
			response.put("mensaje", "Ocurrio una excepcion al consultar el Api abilities");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			Bitacora obj= new Bitacora();
			obj.setIpOrigin(apisend);
			obj.setMetodo("Metodo Ejecutado: version");
			obj.setRequest(String.valueOf(responseTemplate.getStatusCodeValue()));
			bitacoraService.guardar(obj);
		} catch (DataAccessException e) {
			log.error("DataAccessException: Ocurrio un error al guardar en la bitacora:"+ e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			response.put("errorDatabase", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		
		return responseTemplate;

	}
	
	@GetMapping("/pokemon/move/{name}")
	public ResponseEntity<?>move(@PathVariable String name){
		
			String apisend=move+name;
			Map<String, Object> response= new HashMap<>();
			ResponseEntity<?> responseTemplate=null;
		try {
			log.info("::Consultando el api de move::");
			HttpHeaders headers = new HttpHeaders();
			headers.add("user-agent", "Application");
			HttpEntity<String> entity = new HttpEntity<>(headers);
			responseTemplate = restTemplate.exchange(apisend, HttpMethod.GET, entity, String.class);
			
		} catch (Exception e) {
			log.error("Exception: ocurrio una excepcion en la clase [PokemonController], metodo[move]"+ e.getMessage());
			e.printStackTrace();
			response.put("mensaje", "Ocurrio una excepcion al consultar el Api move");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			Bitacora obj= new Bitacora();
			obj.setIpOrigin(apisend);
			obj.setMetodo("Metodo Ejecutado:  move");
			obj.setRequest(String.valueOf(responseTemplate.getStatusCodeValue()));
			bitacoraService.guardar(obj);
		} catch (DataAccessException e) {
			log.error("DataAccessException: Ocurrio un error al guardar en la bitacora:"+ e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			response.put("errorDatabase", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		
		return responseTemplate;

	}
	
	
}
