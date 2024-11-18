package es.iesjandula.reaktor_booking_server.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
	
	@EmbeddedId
	private ReservaId reservaId ;
	
	@ManyToOne
	private Profesor profesor ;
	
	@Column
	private LocalDate fecha ;


}
