package es.iesjandula.reaktor_booking_server.utils;

import java.io.File;

public class Constants
{
	private Constants()
	{
	}

	public static final String CSV_TRAMOS = "src" + File.separator + "main" + File.separator + "resources"
			+ File.separator + "csv" + File.separator + "tramos.csv";
	public static final String CSV_RECURSOS = "src" + File.separator + "main" + File.separator + "resources"
			+ File.separator + "csv" + File.separator + "recursos.csv";
	public static final String CSV_DIASEMANA = "src" + File.separator + "main" + File.separator + "resources"
			+ File.separator + "csv" + File.separator + "dias_de_la_semana.csv";
	public static final String CSV_PROFESORES = "src" + File.separator + "main" + File.separator + "resources"
			+ File.separator + "csv" + File.separator + "profesores.csv";
}
