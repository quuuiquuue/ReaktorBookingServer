package es.iesjandula.reaktor_booking_server.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recurso
{
	@Id
	private String nombre_recurso;
	
	@Column
	private String componentes_informaticos;
}
