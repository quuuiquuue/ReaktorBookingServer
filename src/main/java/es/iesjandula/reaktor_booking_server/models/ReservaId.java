package es.iesjandula.reaktor_booking_server.models;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ReservaId implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 8034212767817744325L;
	
	private String profesor ;
	private LocalDate fecha ;
	
	
}
