package es.iesjandula.reaktor_booking_server.services.interfaz;

import java.util.Scanner;

import es.iesjandula.reaktor_booking_server.utils.BookingServerException;

public interface IParseRecursosCsv
{
	public void parseoRecursosCsv(Scanner scanner) throws BookingServerException;
}
