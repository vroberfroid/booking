package be.bo.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.bo.booking.UserRepository;
import be.bo.user.User;

@RestController
public class BookingController {

	@Autowired
	private UserRepository userRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable long id) throws UserNotFoundException {
		Optional<User> student = userRepository.findById(id);

		System.out.println("==== in getUser (" + id + ") ====");
		if (!student.isPresent())
			throw new UserNotFoundException(Long.toString(id));

		return student.get();
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/users")
	public List<User> getAllUsers() {
        System.out.println("==== in getUsers ====");
        return userRepository.findAll();
    }
}
