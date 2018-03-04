package py.edu.ucsa.rest.api.web.controllers;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import py.edu.ucsa.rest.api.core.model.TipoEnvio;
import py.edu.ucsa.rest.api.core.services.TipoEnvioServices;
import py.edu.ucsa.rest.api.web.dto.ErrorDto;

@CrossOrigin
@RestController
@RequestMapping("/TipoEnvio")

public class TipoEnvioController {
	@Autowired
	private TipoEnvioServices service;
	
	public static final Logger logger = LoggerFactory.getLogger(OficinaController.class);
	private ObjectMapper mapper = new ObjectMapper();
		
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<?> listar(){
		List<TipoEnvio> listaTipoEnvio= service.listar();
		if (listaTipoEnvio.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity <List<TipoEnvio>>(listaTipoEnvio, HttpStatus.OK);
		}
		
	@RequestMapping (value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getById (@PathVariable("id")Integer id){
		TipoEnvio tipoEnvio = service.getById(id);
		if (tipoEnvio==null) {
			return new ResponseEntity<ErrorDto>(new ErrorDto("no existe registro de un tipo de envio con el siguiente ID: "+id), HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<TipoEnvio>(tipoEnvio, HttpStatus.OK);
		}
		
	@RequestMapping (value="/", method=RequestMethod.POST)
	public ResponseEntity<?> guardarTipoEnvio (@RequestBody TipoEnvio teinserta, UriComponentsBuilder uri){
		try {
			System.out.println("Llego esto: "+mapper.writeValueAsString(teinserta));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (service.isExisteCodigo(teinserta)) {
			return new ResponseEntity<ErrorDto>(new ErrorDto("ya existe el tipo de envio"), HttpStatus.CONFLICT);
		} else {
			service.insertar(teinserta);
			teinserta = service.getByCodigo(teinserta.getCodigo());
			HttpHeaders headers = new HttpHeaders ();
			headers.setLocation(uri.path("/tipoEnvio/{id}").buildAndExpand(teinserta.getId()).toUri());
			
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}
			
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> actualizarTipoEnvio(@RequestBody TipoEnvio teactualiza, @PathVariable("id") Integer id){
		TipoEnvio tipoEnvio = service.getById(id);
		if(tipoEnvio == null) {
			logger.error("Actualizacion Fallida. No existe el tipo de envio con id {}.", id);
			return new ResponseEntity<ErrorDto>(new ErrorDto("Actualizacion Fallida. No existe la oficina con id " +id), HttpStatus.NOT_FOUND);
		}
		if(!("A".equals(teactualiza.getEstado()) || "I".equals(teactualiza.getEstado()))) {
			logger.error("Actualizacion Fallida. Valor no valido para el campo Estado {}. ", teactualiza.getEstado());
			return new ResponseEntity<ErrorDto>(new ErrorDto("Actualizacion Fallida. Valor no valido para el campo Estado {}. "+ teactualiza.getEstado()), HttpStatus.CONFLICT);
		}
		tipoEnvio.setDescripcion(teactualiza.getDescripcion());
		tipoEnvio.setEstado(teactualiza.getEstado());
		service.insertar(tipoEnvio);
		return new ResponseEntity<TipoEnvio>(tipoEnvio, HttpStatus.OK);
	}
		
}

