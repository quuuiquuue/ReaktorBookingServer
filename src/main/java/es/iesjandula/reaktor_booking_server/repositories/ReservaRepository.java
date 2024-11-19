package es.iesjandula.reaktor_booking_server.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.reaktor_booking_server.models.DiasSemana;
import es.iesjandula.reaktor_booking_server.models.Recurso;
import es.iesjandula.reaktor_booking_server.models.Reserva;
import es.iesjandula.reaktor_booking_server.models.TramoHorario;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	

	Optional<Reserva> findByRecursoAndDiaSemanaAndTramoHorario(Recurso recurso, DiasSemana diaSemana, TramoHorario tramoHorario);
}
