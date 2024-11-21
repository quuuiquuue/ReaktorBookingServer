package es.iesjandula.reaktor_booking_server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.reaktor_booking_server.models.Recurso;
import es.iesjandula.reaktor_booking_server.repositories.RecursoRepository;
import es.iesjandula.reaktor_booking_server.services.interfaz.IParseRecursosCsv;
import es.iesjandula.reaktor_booking_server.utils.BookingServerException;

@Service
public class ParseRecursosCsv implements IParseRecursosCsv
{
	@Autowired
	RecursoRepository iRecursoRepository;
	
	@Override
	public void parseoRecursosCsv(Scanner scanner) throws BookingServerException
	{
		if (scanner.hasNextLine())
		{
			scanner.nextLine();
		}

		List<Recurso> recursos = new ArrayList<>();

		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			String[] columna = line.split(",");
			
			Recurso recurso = new Recurso();
			recurso.setNombre_recurso(columna[0]);
			recurso.setComponentes_informaticos(columna[1]);
			
			recursos.add(recurso);
		}
		this.iRecursoRepository.saveAllAndFlush(recursos);
	}
}
