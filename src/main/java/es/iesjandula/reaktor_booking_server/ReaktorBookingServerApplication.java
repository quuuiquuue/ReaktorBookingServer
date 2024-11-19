package es.iesjandula.reaktor_booking_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import es.iesjandula.reaktor_booking_server.repositories.AulaRepository;
import es.iesjandula.reaktor_booking_server.repositories.DiasSemanaRepository;
import es.iesjandula.reaktor_booking_server.repositories.RecursoRepository;
import es.iesjandula.reaktor_booking_server.repositories.TramoHorarioRepository;
import es.iesjandula.reaktor_booking_server.services.interfaz.IParseAulaCsv;
import es.iesjandula.reaktor_booking_server.services.interfaz.IParseDiaSemanaCsv;
import es.iesjandula.reaktor_booking_server.services.interfaz.IParseRecursosCsv;
import es.iesjandula.reaktor_booking_server.services.interfaz.IParseTramoCsv;
import es.iesjandula.reaktor_booking_server.utils.Utiles;

@SpringBootApplication
@ComponentScan(basePackages = "es.iesjandula")
public class ReaktorBookingServerApplication implements CommandLineRunner
{
	@Autowired
	RecursoRepository iRecursoRepository;

	@Autowired
	IParseRecursosCsv iParseRecursosCsv;

	@Autowired
	TramoHorarioRepository iTramoHorarioRepository;

	@Autowired
	IParseTramoCsv iParseTramoCsv;

	@Autowired
	DiasSemanaRepository iDiasSemanaRepository;

	@Autowired
	IParseDiaSemanaCsv iParseDiaSemanaCsv;
	
	@Autowired
	IParseAulaCsv iParseAulaCsv;
	
	@Autowired
	AulaRepository iAulaRepository;

	public static void main(String[] args)
	{
		SpringApplication.run(ReaktorBookingServerApplication.class, args);
	}
	
	@Transactional(readOnly = false)
	public void run(String... args) throws Exception
	{
		this.iParseAulaCsv.parseoAulaCsv(Utiles.scannerAula());
		
		if (!(this.iRecursoRepository.count() > 0 && this.iTramoHorarioRepository.count() > 0
				&& this.iDiasSemanaRepository.count() > 0))
		{
			this.iParseRecursosCsv.parseoRecursosCsv(Utiles.scannerRecursos());
			this.iParseTramoCsv.parseoTramoCsv(Utiles.scannerTramos());
			this.iParseDiaSemanaCsv.parseoDiaSemanaCsv(Utiles.scannerDiasSemana());
		}
	}
}