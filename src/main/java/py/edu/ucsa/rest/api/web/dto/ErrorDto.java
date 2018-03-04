package py.edu.ucsa.rest.api.web.dto;

public class ErrorDto {
	private String mensajeError;
	
	public ErrorDto(String var) {
		super();
		
		this.mensajeError = var;
	}

	public String getMensajeError() {
		return mensajeError;
	}

}
