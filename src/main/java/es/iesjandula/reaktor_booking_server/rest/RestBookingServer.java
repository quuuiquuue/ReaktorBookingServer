package es.iesjandula.reaktor_booking_server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
