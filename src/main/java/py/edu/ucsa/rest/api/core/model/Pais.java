package py.edu.ucsa.rest.api.core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name="paises")
@NamedQuery (name="Pais.findAll", query= "SELECT p FROM Pais p")

public class Pais implements Serializable{
	public static final long serialVersionUID=1;
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(length=10)
	private String codigo;
	@Column(length=200)
	private String descripcion;
	@Column(length=1)
	private String estado;	

	public Pais(){}	/*es necesario para poder instanciar*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}; 
		
}