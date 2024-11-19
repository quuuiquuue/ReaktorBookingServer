package es.iesjandula.reaktor_booking_server.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.iesjandula.reaktor_booking_server.models.TramoHorario;
import es.iesjandula.reaktor_booking_server.models.TramoHorarioId;
import es.iesjandula.reaktor_booking_server.repositories.AulaRepository;
import es.iesjandula.reaktor_booking_server.repositories.DiasSemanaRepository;
import es.iesjandula.reaktor_booking_server.repositories.ProfesorRepository;
import es.iesjandula.reaktor_booking_server.repositories.RecursoRepository;
import es.iesjandula.reaktor_booking_server.repositories.ReservaRepository;
import es.iesjandula.reaktor_booking_server.repositories.TramoHorarioRepository;

@RestController
@RequestMapping("/bookings")
public class RestBookingServer
{
	@Autowired
	private RecursoRepository recursoRepository ;
	
	@Autowired
	private AulaRepository aulaRepository;
	
	@Autowired 
	private DiasSemanaRepository diasSemanaRepository ;
	
	@Autowired
	private ProfesorRepository profesorRepository ;
	
	@Autowired
	private ReservaRepository reservaRepository ;
	
	@Autowired
	private TramoHorarioRepository tramoHorarioRepository ;
	
	// Endpoint para obtener un TramoHorario por su ID
    @RequestMapping(method = RequestMethod.GET, value ="/tramo_horario")
    public ResponseEntity<?> getTramoHorario(
            @RequestParam("horaInicio") String horaInicio,
            @RequestParam("horaFin") String horaFin) {

        // Construir el ID embebido
        TramoHorarioId tramoHorarioId = new TramoHorarioId(horaInicio, horaFin);

        // Buscar el TramoHorario en la base de datos
        Optional<TramoHorario> tramoHorario = this.tramoHorarioRepository.findById(tramoHorarioId);

        // Retornar el TramoHorario si se encuentra o un estado Not Found si no
        return ResponseEntity.ok().body(tramoHorarioId);
    }
	
}
