package es.iesjandula.reaktor_booking_server.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TramoHorario
{
	@EmbeddedId
	private TramoHorarioId tramoHorarioId;
}
