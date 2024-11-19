package es.iesjandula.reaktor_booking_server.services.interfaz;

import java.util.Scanner;

import es.iesjandula.reaktor_booking_server.utils.BookingServerException;

public interface IParseProfesorCsv
{
	public void parseoProfesorCsv(Scanner scanner) throws BookingServerException;
}
