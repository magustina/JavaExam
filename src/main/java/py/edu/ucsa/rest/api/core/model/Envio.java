package py.edu.ucsa.rest.api.core.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name="envios")
@NamedQuery (name="Envio.findAll", query= "SELECT e FROM Envio e")
public class Envio implements Serializable{
	public static final long serialVersionUID=1;

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY) Integer id;
	@ManyToOne
	@JoinColumn(name="id_pais_origen")
	private Pais paisOrigen;
	@ManyToOne
	@JoinColumn(name="id_pais_destino")
	private Pais paisDestino;
	@Column(length=300)
	private String nombrePersonaOrigen;
	@Column(length=300)
	private String nombrePersonaDestino;
	@ManyToOne
	@JoinColumn(name="id_oficina_destino")
	private Oficina idOficinaEnvio;
	@Column(length=300)
	private String nombre_funcionario_despacho;
	private Date fecha_envio;
	@ManyToOne
	@JoinColumn(name="tipo_envio")
	private TipoEnvio	tipoEnvio;
	private boolean certificado;
	@Column(length=15)
	private String nro_rastreo;
	private Integer peso;
	private Integer costo_envio_sin_certif;
	private Integer costo_certificado;
	@Column(length=4)
	private String estado;
	
	public Envio(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pais getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(Pais paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public Pais getPaisDestino() {
		return paisDestino;
	}

	public void setPaisDestino(Pais paisDestino) {
		this.paisDestino = paisDestino;
	}

	public String getNombrePersonaOrigen() {
		return nombrePersonaOrigen;
	}

	public void setNombrePersonaOrigen(String nombrePersonaOrigen) {
		this.nombrePersonaOrigen = nombrePersonaOrigen;
	}

	public String getNombrePersonaDestino() {
		return nombrePersonaDestino;
	}

	public void setNombrePersonaDestino(String nombrePersonaDestino) {
		this.nombrePersonaDestino = nombrePersonaDestino;
	}

	public Oficina getIdOficinaEnvio() {
		return idOficinaEnvio;
	}

	public void setIdOficinaEnvio(Oficina idOficinaEnvio) {
		this.idOficinaEnvio = idOficinaEnvio;
	}

	public String getNombre_funcionario_despacho() {
		return nombre_funcionario_despacho;
	}

	public void setNombre_funcionario_despacho(String nombre_funcionario_despacho) {
		this.nombre_funcionario_despacho = nombre_funcionario_despacho;
	}

	public Date getFecha_envio() {
		return fecha_envio;
	}

	public void setFecha_envio(Date fecha_envio) {
		this.fecha_envio = fecha_envio;
	}

	public TipoEnvio getTipoEnvio() {
		return tipoEnvio;
	}

	public void setTipoEnvio(TipoEnvio tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}

	public boolean isCertificado() {
		return certificado;
	}

	public void setCertificado(boolean certificado) {
		this.certificado = certificado;
	}

	public String getNro_rastreo() {
		return nro_rastreo;
	}

	public void setNro_rastreo(String nro_rastreo) {
		this.nro_rastreo = nro_rastreo;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getCosto_envio_sin_certif() {
		return costo_envio_sin_certif;
	}

	public void setCosto_envio_sin_certif(Integer costo_envio_sin_certif) {
		this.costo_envio_sin_certif = costo_envio_sin_certif;
	}

	public Integer getCosto_certificado() {
		return costo_certificado;
	}

	public void setCosto_certificado(Integer costo_certificado) {
		this.costo_certificado = costo_certificado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
