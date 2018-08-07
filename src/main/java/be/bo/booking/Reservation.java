package be.bo.booking;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Reservation {

	public enum Type {
		INSTALLATION, MAINTENANCE;
	}

	/**
	 * The date of the reservation
	 */
	private Date date;

	/**
	 * Some details of the reservation
	 */
	@Size(max=100, message="The maximum size of a message is 100 characters")
	private String details;

	/**
	 * The duration of the reservation
	 */
	@NotEmpty
	private int duration;

	@Id
	@GeneratedValue
	private Long id;

	private Type type;

	Reservation() {
	}

	Reservation(Date date, int duration, Type type, String details) {
		setDate(date);
		setDuration(duration);
		setType(type);
		setDetails(details);
	}

	public Date getDate() {
		return date;
	}

	public String getDetails() {
		return details;
	}

	public int getDuration() {
		return duration;
	}

	public Type getType() {
		return type;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
