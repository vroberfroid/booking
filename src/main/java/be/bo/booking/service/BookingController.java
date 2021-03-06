package be.bo.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import be.bo.booking.UserRepository;
import be.bo.user.User;

@RestController
public class BookingController {

	@Autowired
	private UserRepository userRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable long id) throws UserNotFoundException {
		Optional<User> student = userRepository.findById(id);

		System.out.println("==== in getUser (" + id + ") ====");
		if (!student.isPresent())
			throw new UserNotFoundException(Long.toString(id));

		return student.get();
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/users")
	public List<User> getAllUsers() {
        System.out.println("==== in getUsers ====");
        return userRepository.findAll();
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/users")
	public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder builder) {
        System.out.println("==== in addUser ====");
        User newUser = userRepository.save(user);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/user/{id}").buildAndExpand(newUser.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/users")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		System.out.println("==== in updateUser ====");
		boolean flag = userRepository.existsById(user.getId());
		if (flag == false) {
    	    return new ResponseEntity<User>(HttpStatus.CONFLICT);
        }
		userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Long> deleteUser(@PathVariable long id) {
		System.out.println("==== in deleteUser ====");
		boolean flag = userRepository.existsById(id);
		if (flag == false) {
    	    return new ResponseEntity<Long>(HttpStatus.CONFLICT);
        }		
		userRepository.deleteById(id);
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
}
