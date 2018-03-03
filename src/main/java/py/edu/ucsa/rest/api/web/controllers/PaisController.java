package py.edu.ucsa.rest.api.web.controllers;

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
import py.edu.ucsa.rest.api.core.model.Pais;
import py.edu.ucsa.rest.api.core.services.PaisService;
import py.edu.ucsa.rest.api.web.dto.ErrorDto;

@RestController
@RequestMapping("/pais")
public class PaisController {
	@Autowired
	private PaisService service;
		
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<?> listar(){
		List<Pais> listaPais= service.listar();
		if (listaPais.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity <List<Pais>>(listaPais, HttpStatus.OK);
		}
		
	@RequestMapping (value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getById (@PathVariable("id")Integer id){
		Pais pais = service.getById(id);
		if (pais==null) {
			return new ResponseEntity<ErrorDto>(new ErrorDto("no existe registro de un pais con el siguiente ID: "+id), HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<Pais>(pais, HttpStatus.OK);
		}
		
	@RequestMapping (value="/", method=RequestMethod.POST)
	public ResponseEntity<?> guardarPais (Pais pinserta, UriComponentsBuilder uri){
		if (service.isExisteCodigo(pinserta)) {
			return new ResponseEntity<ErrorDto>(new ErrorDto("ya existe el usuario"), HttpStatus.CONFLICT);
		} else {
			service.insertar(pinserta);
			pinserta = service.getByCodigo(pinserta.getCodigo());
			HttpHeaders headers = new HttpHeaders ();
			headers.setLocation(uri.path("/pais/{id}").buildAndExpand(pinserta.getId()).toUri());
			
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}
			
	}
		
}

