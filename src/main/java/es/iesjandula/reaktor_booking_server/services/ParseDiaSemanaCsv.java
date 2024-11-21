package es.iesjandula.reaktor_booking_server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.reaktor_booking_server.models.DiasSemana;
import es.iesjandula.reaktor_booking_server.repositories.DiasSemanaRepository;
import es.iesjandula.reaktor_booking_server.services.interfaz.IParseDiaSemanaCsv;
import es.iesjandula.reaktor_booking_server.utils.BookingServerException;

@Service
public class ParseDiaSemanaCsv implements IParseDiaSemanaCsv
{
	@Autowired
	DiasSemanaRepository iDiasSemanaRepository;

	@Override
	public void parseoDiaSemanaCsv(Scanner scanner) throws BookingServerException
	{
		if (scanner.hasNextLine())
		{
			scanner.nextLine();
		}

		List<DiasSemana> dias = new ArrayList<>();

		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			String[] columna = line.split(",");

			DiasSemana dia = new DiasSemana(columna[0]);

			dias.add(dia);
		}
		this.iDiasSemanaRepository.saveAllAndFlush(dias);
	}

}
