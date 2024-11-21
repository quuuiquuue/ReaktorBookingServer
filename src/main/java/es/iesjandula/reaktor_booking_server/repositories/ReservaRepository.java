package es.iesjandula.reaktor_booking_server.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.iesjandula.reaktor_booking_server.models.DiasSemana;
import es.iesjandula.reaktor_booking_server.models.Recurso;
import es.iesjandula.reaktor_booking_server.models.Reserva;
import es.iesjandula.reaktor_booking_server.models.TramoHorario;

<<<<<<< HEAD
public interface ReservaRepository extends JpaRepository<Reserva, Integer>
{
=======
public interface ReservaRepository extends JpaRepository<Reserva, String>{
	
>>>>>>> 1395ab93cede9a5ae21626be8c2e993255544c31

	Optional<Reserva> findByRecursoAndDiaSemanaAndTramoHorario(Recurso recurso, DiasSemana diaSemana,
			TramoHorario tramoHorario);

	@Query("SELECT r FROM Reserva r WHERE "
			+ "(LOWER(r.recurso.nombre_recurso) LIKE LOWER(CONCAT('%', :recurso, '%')) OR :recurso IS NULL)")
	List<Reserva> findByRecurso(@Param("recurso") String recurso);

}
