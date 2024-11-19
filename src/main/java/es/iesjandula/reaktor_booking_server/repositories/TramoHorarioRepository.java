package es.iesjandula.reaktor_booking_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.reaktor_booking_server.models.TramoHorario;
import es.iesjandula.reaktor_booking_server.models.TramoHorarioId;

public interface TramoHorarioRepository extends JpaRepository<TramoHorario, TramoHorarioId>{

}
