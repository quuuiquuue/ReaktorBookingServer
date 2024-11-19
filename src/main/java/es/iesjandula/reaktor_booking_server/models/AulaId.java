package es.iesjandula.reaktor_booking_server.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AulaId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1897746110280166484L;

	@Column(name = "nombre")
	private String nombre ;
	
	@Column(name = "planta")
	private String planta ;
	
	
}
