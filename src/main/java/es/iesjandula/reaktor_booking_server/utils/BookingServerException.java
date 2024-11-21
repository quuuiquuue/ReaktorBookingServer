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

	private Integer bookingErrorId;

	private String message;

	private Exception exception;

	/**
	 * @param movieErrorId
	 * @param message
	 */
	public BookingServerException(Integer bookingErrorId, String message)
	{
		super(message);
		this.bookingErrorId = bookingErrorId;
		this.message = message;
	}

	/**
	 * @param movieErrorId
	 * @param message
	 * @param exception
	 */
	public BookingServerException(Integer bookingErrorId, String message, Exception exception)
	{
		super(message, exception);
		this.bookingErrorId = bookingErrorId;
		this.message = message;
		this.exception = exception;
	}

	public Map<String, String> getMapError()
	{
		Map<String, String> mapError = new TreeMap<String, String>();

		mapError.put("id", "" + this.bookingErrorId);
		mapError.put("message", "" + this.message);

		if (this.exception != null)
		{
			String stacktrace = ExceptionUtils.getStackTrace(this.exception);
			mapError.put("exception", stacktrace);
		}
		return mapError;
	}

}
