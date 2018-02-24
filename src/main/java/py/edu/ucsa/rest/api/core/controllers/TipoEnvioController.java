package py.edu.ucsa.rest.api.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import py.edu.ucsa.rest.api.core.model.TipoEnvio;
import py.edu.ucsa.rest.api.core.services.TipoEnvioServices;
import py.edu.ucsa.rest.api.web.dto.ErrorDto;

@RestController
@RequestMapping("/TipoEnvio")

public class TipoEnvioController {
	@Autowired
	private TipoEnvioServices service;
		
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
	public ResponseEntity<?> guardarTipoEnvio (TipoEnvio teinserta, UriComponentsBuilder uri){
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
		
}

