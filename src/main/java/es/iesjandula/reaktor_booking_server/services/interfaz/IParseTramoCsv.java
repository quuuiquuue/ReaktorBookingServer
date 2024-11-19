package es.iesjandula.reaktor_booking_server.services.interfaz;

import java.util.Scanner;

import es.iesjandula.reaktor_booking_server.utils.BookingServerException;

public interface IParseTramoCsv
{
	public void parseoTramoCsv(Scanner scanner) throws BookingServerException;
}
