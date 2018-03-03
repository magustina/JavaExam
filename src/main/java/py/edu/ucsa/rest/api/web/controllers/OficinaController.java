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
import py.edu.ucsa.rest.api.core.model.Oficina;
import py.edu.ucsa.rest.api.core.services.OficinaService;
import py.edu.ucsa.rest.api.web.dto.ErrorDto;

@RestController	/*le dice al spring que esta clase contiene web services*/
@RequestMapping ("/oficina")
public class OficinaController {
	@Autowired
	private OficinaService service;
		
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<?> listar(){
		List<Oficina> listaOficina=service.listar();
		if (listaOficina.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity <List<Oficina>>(listaOficina, HttpStatus.OK);
		}
		
	@RequestMapping (value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getById (@PathVariable("id")Integer id){
		Oficina oficina = service.getById(id);
		if (oficina==null) {
			return new ResponseEntity<ErrorDto>(new ErrorDto("No hay oficina con el siguiente ID: "+id), HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<Oficina>(oficina, HttpStatus.OK);
		}
		
	@RequestMapping (value="/", method=RequestMethod.POST)
	public ResponseEntity<?> guardarOficina (Oficina oinserta, UriComponentsBuilder uri){
		if (service.isExisteOficina(oinserta)) {
			return new ResponseEntity<ErrorDto>(new ErrorDto("ya existe la oficina"), HttpStatus.CONFLICT);
		} else {
			service.insertar(oinserta);
			oinserta = service.getByCodigo(oinserta.getCodigo());
			HttpHeaders headers = new HttpHeaders ();
			headers.setLocation(uri.path("/oficina/{id}").buildAndExpand(oinserta.getId()).toUri());
			
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}
			
	}
		
}


