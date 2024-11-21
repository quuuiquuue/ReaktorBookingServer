package es.iesjandula.reaktor_booking_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.reaktor_booking_server.models.Recurso;

public interface RecursoRepository extends JpaRepository<Recurso, String>
{

}
