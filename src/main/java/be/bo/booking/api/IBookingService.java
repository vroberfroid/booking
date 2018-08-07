package be.bo.booking.api;

import be.bo.booking.Reservation;

public interface IBookingService {

	void addReservation(Reservation reservation);
	Reservation getReservation(Reservation reservation);
	void deleteReservation();
	void updateReservation(Reservation reservation);
}
