package es.iesjandula.reaktor_booking_server.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
	private Integer id;
	
	@ManyToOne
	private Aula aula;
	
	@Column
	private String componentes_informaticos;
}