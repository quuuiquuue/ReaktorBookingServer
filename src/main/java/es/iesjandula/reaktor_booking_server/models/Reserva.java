package es.iesjandula.reaktor_booking_server.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String correo_profesor;

	@ManyToOne
	@JoinColumn(referencedColumnName = "nombre_recurso")
	private Recurso recurso;

	@ManyToOne
	@JoinColumn( referencedColumnName = "dia")
	private DiasSemana diaSemana;

	@ManyToOne
	private TramoHorario tramoHorario;

	@ManyToOne
	@JoinColumn(referencedColumnName = "dni")
	private Profesor profesor;

	@Column
	private Integer numero_alumnos;

}
