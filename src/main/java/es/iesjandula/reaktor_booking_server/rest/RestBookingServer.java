package es.iesjandula.reaktor_booking_server.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.iesjandula.reaktor_booking_server.models.Recurso;
import es.iesjandula.reaktor_booking_server.models.Reserva;
import es.iesjandula.reaktor_booking_server.models.TramoHorario;
import es.iesjandula.reaktor_booking_server.models.TramoHorarioId;
import es.iesjandula.reaktor_booking_server.repositories.DiasSemanaRepository;
import es.iesjandula.reaktor_booking_server.repositories.ProfesorRepository;
import es.iesjandula.reaktor_booking_server.repositories.RecursoRepository;
import es.iesjandula.reaktor_booking_server.repositories.ReservaRepository;
import es.iesjandula.reaktor_booking_server.repositories.TramoHorarioRepository;
import es.iesjandula.reaktor_booking_server.utils.BookingServerException;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/bookings")
@Slf4j
public class RestBookingServer
{
	@Autowired
	private RecursoRepository recursoRepository;

	@Autowired
	private DiasSemanaRepository diasSemanaRepository;

	@Autowired
	private ProfesorRepository profesorRepository;

	@Autowired
	private ReservaRepository reservaRepository;

	@Autowired
	private TramoHorarioRepository tramoHorarioRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/reserva")
	public ResponseEntity<?> getReserva()
	{
		try
		{
			if (!(this.reservaRepository.count() > 0))
			{
				throw new BookingServerException(0, "No se ha encontrado recursos");
			}
			return ResponseEntity.ok().body(this.reservaRepository.findAll());
		}
		catch (Exception ex)
		{
			String message = "Fallo en la lectura de la base de datos";
			BookingServerException bookingServerException = new BookingServerException(1, message);
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(bookingServerException.getMapError());
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/recursos")
	public ResponseEntity<?> getRecusos()
	{
		try
		{
			if (!(this.recursoRepository.count() > 0))
			{
				throw new BookingServerException(0, "No se ha encontrado recursos");
			}
			return ResponseEntity.ok().body(this.recursoRepository.findAll());
		}
		catch (Exception ex)
		{
			String message = "Fallo en la lectura de la base de datos";
			BookingServerException bookingServerException = new BookingServerException(1, message);
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(bookingServerException.getMapError());
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reservas")
	public ResponseEntity<?> getReservaByRecurso(@RequestBody(required = true) Recurso recurso)
	{
		try
		{
			if (this.reservaRepository.findByRecurso(recurso.getNombre_recurso()).isEmpty())
			{
				throw new BookingServerException(100, "EL recurso no se ha encontrado");
			}

			return ResponseEntity.ok().body(this.reservaRepository.findByRecurso(recurso.getNombre_recurso()));
		}
		catch (Exception exception)
		{
			String message = "Fallo en la lectura de la base de datos";
			BookingServerException bookingServerException = new BookingServerException(1, message);
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(bookingServerException.getMapError());
		}
	}

	// Endpoint para obtener un TramoHorario por su ID
	@RequestMapping(method = RequestMethod.GET, value = "/tramo_horario")
	public ResponseEntity<?> getTramoHorario(@RequestParam("horaInicio") String horaInicio,
			@RequestParam("horaFin") String horaFin)
	{

		try
		{
			// Construir el ID embebido
			TramoHorarioId tramoHorarioId = new TramoHorarioId(horaInicio, horaFin);

			// Buscar el TramoHorario en la base de datos
			Optional<TramoHorario> tramoHorario = this.tramoHorarioRepository.findById(tramoHorarioId);

			// Verificar si el TramoHorario está presente
			if (tramoHorario.isPresent())
			{
				log.info("TramoHorario encontrado: {}", tramoHorario.get());
				return ResponseEntity.ok().body(tramoHorario);
			}
			else
			{
				// Si no se encuentra, lanzar una excepción personalizada
				throw new BookingServerException(404, "TramoHorario con hora de inicio " + horaInicio
						+ " y hora de fin " + horaFin + " no encontrado.");
			}
		}
		catch (BookingServerException ex)
		{
			// Manejo de la excepción personalizada y retorno de respuesta
			log.error("Error al obtener TramoHorario: {}", ex.getMessage());
			return ResponseEntity.status(ex.getBookingErrorId()).body(ex.getMapError());
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dias_semana")
	public ResponseEntity<?> getDiasSemana()
	{
		try
		{
			// Comprueba que dias de la semana no este vacio
			if (!(this.diasSemanaRepository.count() > 0))
			{
				// Lanza una excepción si no encuentra los dias de la semana
				throw new BookingServerException(0, "No se ha encontrado dias de la semanarecursos");
			}
			return ResponseEntity.ok().body(this.diasSemanaRepository.findAll());
		}
		catch (Exception exception)
		{

			// Manejo de la excepción personalizada y retorno de respuesta
			String message = "Fallo en la lectura de la base de datos";
			BookingServerException bookingServerException = new BookingServerException(1, message);
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(bookingServerException.getMapError());
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/reserva")
	public ResponseEntity<?> crearReserva(@RequestBody Reserva nuevaReserva)
	{
		try
		{
			// Validar que el recurso existe
			Optional<Recurso> recurso = recursoRepository.findById(nuevaReserva.getRecurso().getNombre_recurso());
			if (!recurso.isPresent())
			{
				throw new BookingServerException(404,
						"Recurso con ID " + nuevaReserva.getRecurso().getNombre_recurso() + " no encontrado.");
			}

			// Validar si ya existe una reserva en ese día y tramo horario
			Optional<Reserva> reservaExistente = reservaRepository.findByRecursoAndDiaSemanaAndTramoHorario(
					nuevaReserva.getRecurso(), nuevaReserva.getDiaSemana(), nuevaReserva.getTramoHorario());

			if (reservaExistente.isPresent())
			{
				throw new BookingServerException(409,
						"Ya existe una reserva para este recurso en el día " + nuevaReserva.getDiaSemana()
								+ " y tramo horario "
								+ nuevaReserva.getTramoHorario().getTramo_horario_id().getHora_inicio() + "-"
								+ nuevaReserva.getTramoHorario().getTramo_horario_id().getHora_fin());
			}

			// Guardar la nueva reserva en la base de datos
			reservaRepository.save(nuevaReserva);
			log.info("Reserva creada con éxito: {}", nuevaReserva);
			return ResponseEntity.ok().body("Reserva creada con éxito.");

		}
		catch (BookingServerException ex)
		{
			// Manejo de la excepción personalizada y retorno de la respuesta
			log.error("Error al crear reserva: {}", ex.getMessage());
			return ResponseEntity.status(ex.getBookingErrorId()).body(ex.getMapError());
		}
	}

	// Endpoint para cancelar un Recurso por su ID
	@RequestMapping(method = RequestMethod.DELETE, value = "/recurso")
	public ResponseEntity<?> cancelarRecurso(@RequestParam("id") String nombre_recurso)
	{

		try
		{
			// Buscar el Recurso en la base de datos por su ID
			Optional<Recurso> recurso = this.recursoRepository.findById(nombre_recurso);

			// Si el Recurso existe, proceder con la eliminación
			if (recurso.isPresent())
			{
				recursoRepository.deleteById(nombre_recurso);
				log.info("Recurso con ID: {} cancelado exitosamente.", nombre_recurso);
				return ResponseEntity.ok().body("Recurso cancelado exitosamente.");
			}
			else
			{
				// Si no se encuentra, lanzar una excepción personalizada
				throw new BookingServerException(404, "Recurso con ID " + nombre_recurso + " no encontrado.");
			}
		}
		catch (BookingServerException ex)
		{
			// Manejo de la excepción personalizada y retorno de respuesta
			log.error("Error al cancelar Recurso: {}", ex.getMessage());
			return ResponseEntity.status(ex.getBookingErrorId()).body(ex.getMapError());
		}
	}
}