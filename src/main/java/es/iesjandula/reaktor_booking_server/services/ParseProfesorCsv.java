package es.iesjandula.reaktor_booking_server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.reaktor_booking_server.models.Profesor;
import es.iesjandula.reaktor_booking_server.repositories.ProfesorRepository;
import es.iesjandula.reaktor_booking_server.services.interfaz.IParseProfesorCsv;
import es.iesjandula.reaktor_booking_server.utils.BookingServerException;

@Service
public class ParseProfesorCsv implements IParseProfesorCsv
{

	@Autowired
	private ProfesorRepository profesorRepository;

	@Override
	public void parseoProfesorCsv(Scanner scanner) throws BookingServerException
	{

		if (scanner.hasNextLine())
		{
			scanner.nextLine();
		}

		List<Profesor> profesores = new ArrayList<>();

		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			String[] columnas = line.split(",");

			Profesor profesor = new Profesor();
			profesor.setDni(columnas[0]);
			profesor.setNombre(columnas[1]);
			profesor.setApellidos(columnas[2]);
			profesor.setCorreo(columnas[3]);

			profesores.add(profesor);
		}

		this.profesorRepository.saveAllAndFlush(profesores);
	}
}
