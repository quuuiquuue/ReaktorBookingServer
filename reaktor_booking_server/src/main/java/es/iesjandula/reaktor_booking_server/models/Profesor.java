package es.iesjandula.reaktor_booking_server.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profesor")
@Entity
public class Profesor {
	
	@Id
	@Column(name = "dni")
	private String dni ;
	
	@Column(name = "nombre")
	private String nombre ;
	
	@Column(name = "apellidos")
	private String apellidos ;
	
	@Column(name = "correo")
	private String correo ;
	
	@OneToMany
	private List<Reserva> reservas ;

}
