package py.edu.ucsa.rest.api.web.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.ucsa.rest.api.core.model.Envio;
import py.edu.ucsa.rest.api.core.services.EnvioService;
import py.edu.ucsa.rest.api.web.dto.ErrorDto;

@CrossOrigin
@RestController
@RequestMapping("/envio")
public class EnvioControllers {
	
	public static final Logger logger = LoggerFactory.getLogger(EnvioControllers.class);
	
	@Autowired
	private EnvioService service;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> crearEnvio(@RequestBody Envio envio){
		logger.info("Creando el Envio {}", envio);
		if(service.isExisteEnvio(envio)) {
			logger.error("Insercion Fallida. Ya existe un registro con esta combinacion {FechaEnvio, NroRastreo}. {"+envio.getFecha_envio()+", "+envio.getNro_rastreo()+"}");
			return new ResponseEntity<ErrorDto>(new ErrorDto("Insercion Fallida. Ya existe un registro con esta combinacion {FechaEnvio, NroRastreo}. {"+ envio.getFecha_envio()+", "+envio.getNro_rastreo()+"}"), HttpStatus.CONFLICT);
		}
		
		service.guardarEnvio(envio);
		return new ResponseEntity<Envio>(envio, HttpStatus.CREATED);	
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> listarEnvios(){
		List<Envio> envios = service.listarTodos();
		if(envios.isEmpty()) {
			return new ResponseEntity<ErrorDto>(new ErrorDto("No se encontraron registros ") ,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Envio>>(envios,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getEnvioById(@PathVariable("id") Integer id ){
		logger.info("Vamos obtener el Envio con id {}.", id);
		Envio env = service.getById(id);
		if(env == null) {
			logger.error("No se encontro ningun envio con id {}.",id);
			return new ResponseEntity<ErrorDto>(new ErrorDto("No se encontro ningun Envio con id " + id), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Envio>(env, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> actualizarEnvio(@RequestBody Envio env, @PathVariable("id") Integer id){
		logger.info("Actualizando el Envio con id {}", id);
		Envio envBD = service.getById(id);
		if(envBD == null) {
			logger.error("Actualizacion Fallida. No existe el Envio con id {}.", id);
			return new ResponseEntity<ErrorDto>(new ErrorDto("Actualizacion Fallida. No existe el Envio con id " +id), HttpStatus.NOT_FOUND);
		}
		envBD.setEstado(env.getEstado());
		service.guardarEnvio(envBD);
		return new ResponseEntity<Envio>(envBD, HttpStatus.OK);
		
		
	}
}
