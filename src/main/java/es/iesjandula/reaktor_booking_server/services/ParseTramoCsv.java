package es.iesjandula.reaktor_booking_server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.reaktor_booking_server.models.TramoHorario;
import es.iesjandula.reaktor_booking_server.models.TramoHorarioId;
import es.iesjandula.reaktor_booking_server.repositories.TramoHorarioRepository;
import es.iesjandula.reaktor_booking_server.services.interfaz.IParseTramoCsv;
import es.iesjandula.reaktor_booking_server.utils.BookingServerException;

@Service
public class ParseTramoCsv implements IParseTramoCsv
{
	@Autowired
	TramoHorarioRepository iTramoHorarioRepository;

	@Override
	public void parseoTramoCsv(Scanner scanner) throws BookingServerException
	{
		if (scanner.hasNextLine())
		{
			scanner.nextLine();
		}

		List<TramoHorario> tramos = new ArrayList<>();

		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			String[] columna = line.split(",");
			
			TramoHorarioId tramoHorarioId = new TramoHorarioId(columna[0], columna[1]);
			
			TramoHorario tramoHorario = new TramoHorario(tramoHorarioId);
			tramos.add(tramoHorario);
		}
		this.iTramoHorarioRepository.saveAllAndFlush(tramos);	
	}

}
