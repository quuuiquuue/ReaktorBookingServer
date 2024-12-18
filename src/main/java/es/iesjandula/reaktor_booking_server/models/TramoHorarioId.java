package es.iesjandula.reaktor_booking_server.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class TramoHorarioId implements Serializable
{
	/**
	 * AutoGenerated
	 */
	private static final long serialVersionUID = -86643101492426938L;

	@Column
    private String horaInicio;

    @Column
    private String horaFin;
}
