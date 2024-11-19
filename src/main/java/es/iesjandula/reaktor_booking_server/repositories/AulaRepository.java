package es.iesjandula.reaktor_booking_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.reaktor_booking_server.models.Aula;
import es.iesjandula.reaktor_booking_server.models.AulaId;

public interface AulaRepository extends JpaRepository<Aula, AulaId>{

}
