package es.iesjandula.reaktor_booking_server.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utiles
{
	public static final File FILE_TRAMOS = new File(Constants.CSV_TRAMOS);
    public static final File FILE_RECURSOS = new File(Constants.CSV_RECURSOS);
    public static final File FILE_DIAS_SEMANA = new File(Constants.CSV_DIASEMANA);
    public static final File FILE_AULAS = new File(Constants.CSV_AULA);
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    
    public static Scanner scannerTramos()
    {
        return createScanner(FILE_TRAMOS);
    }
    
    public static Scanner scannerRecursos()
    {
        return createScanner(FILE_RECURSOS);
    }
    
    public static Scanner scannerDiasSemana()
    {
        return createScanner(FILE_DIAS_SEMANA);
    }
    
    public static Scanner scannerAula()
    {
        return createScanner(FILE_AULAS);
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    private static Scanner createScanner(File file)
    {
        try
        {
            return new Scanner(file);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Archivo no encontrado: " + file.getPath());
            return null;
        }
    }
}
