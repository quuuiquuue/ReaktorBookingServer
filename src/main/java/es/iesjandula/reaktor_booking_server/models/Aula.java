package es.iesjandula.reaktor_booking_server.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aula {
	
	@EmbeddedId
	private AulaId AulaId;
	

}
