package be.bo.booking.service;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -404879219930483731L;

	String message;
	
	UserNotFoundException(String id) {		
		message="Error: the user with id=" + id + " does not exist.";
	}
	
	
	@Override
	public String getMessage() {
		return message;
	}
}
