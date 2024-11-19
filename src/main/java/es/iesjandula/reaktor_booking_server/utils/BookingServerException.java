package es.iesjandula.reaktor_booking_server.utils;

import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.exception.ExceptionUtils;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class BookingServerException extends Exception
{

	/**
	 * This is generated Serial ID of Exception
	 */
	private static final long serialVersionUID = -6626056670072611679L;

	private Integer movieErrorId;
	
	private String message;
	
	private Exception exception;

	/**
	 * @param movieErrorId
	 * @param message
	 */
	public BookingServerException(Integer movieErrorId, String message)
	{
		super(message);
		this.movieErrorId = movieErrorId;
		this.message = message;
	}

	/**
	 * @param movieErrorId
	 * @param message
	 * @param exception
	 */
	public BookingServerException(Integer movieErrorId, String message, Exception exception)
	{
		super(message, exception);
		this.movieErrorId = movieErrorId;
		this.message = message;
		this.exception = exception;
	}
	
	public Map<String, String> getMapError()
	{
		Map<String, String> mapError = new TreeMap<String, String>();
		
		mapError.put("id", "" + this.movieErrorId);
		mapError.put("message", "" + this.message);
		
		if(this.exception != null)
		{
			String stacktrace = ExceptionUtils.getStackTrace(this.exception);
			mapError.put("exception", stacktrace);
		}
		return mapError;
	}
	
}
