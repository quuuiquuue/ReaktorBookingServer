package es.iesjandula.reaktor_booking_server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.reaktor_booking_server.models.Aula;
import es.iesjandula.reaktor_booking_server.models.AulaId;
import es.iesjandula.reaktor_booking_server.repositories.AulaRepository;
import es.iesjandula.reaktor_booking_server.services.interfaz.IParseAulaCsv;
import es.iesjandula.reaktor_booking_server.utils.BookingServerException;

@Service
public class ParseAulaCsv implements IParseAulaCsv{
	
	@Autowired
	AulaRepository aulaRepository ;

	@Override
	public void parseoAulaCsv(Scanner scanner) throws BookingServerException 
	{
		if (scanner.hasNextLine())
		{
			scanner.nextLine();
		}

		List<Aula> aulas = new ArrayList<>();

		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			String[] columna = line.split(",");
			
			AulaId aulaId = new AulaId(columna[0], columna[1]);
			Aula aula = new Aula(aulaId) ;
			
			aulas.add(aula);
		}
		this.aulaRepository.saveAllAndFlush(aulas);	
	}

}
