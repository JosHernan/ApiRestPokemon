package backend.service.apirest.pokemon.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bitacora")
public class Bitacora implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "ip")
	private String ipOrigin;
	@Column(name = "createAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRequest;
	@Column(nullable = true)
	private String metodo;
	
	private String request;
	
	@PrePersist
	public void createDate() {
		this.fechaRequest= new Date();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIpOrigin() {
		return ipOrigin;
	}
	public void setIpOrigin(String ipOrigin) {
		this.ipOrigin = ipOrigin;
	}
	public Date getFechaRequest() {
		return fechaRequest;
	}
	public void setFechaRequest(Date fechaRequest) {
		this.fechaRequest = fechaRequest;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	

}
