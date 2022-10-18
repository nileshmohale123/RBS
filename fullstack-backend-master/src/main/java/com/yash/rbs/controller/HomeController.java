package com.yash.rbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.rbs.exception.CustomerNotFoundException;
import com.yash.rbs.exception.RoomNotFoundException;
import com.yash.rbs.exception.UserNotFoundException;
import com.yash.rbs.model.Room;
import com.yash.rbs.model.User;
import com.yash.rbs.model.AdminManager;
import com.yash.rbs.repository.RoomRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class HomeController {

	@Autowired
	private RoomRepository roomrepository;

	@PostMapping("/room")
	Room addRoom(@RequestBody Room roomname) {
		return roomrepository.save(roomname);
	}

	@GetMapping("/rooms")
	List<Room> getAllRooms() {
		return roomrepository.findAll();

	}

	@PutMapping("/editroom/{id}")
    Room updateusersdata(@RequestBody Room cust, @PathVariable Long id) {
        return roomrepository.findById(id)
                .map(newcust -> {
                	
                	newcust.setCheckInDate(cust.getCheckInDate());
                	newcust.setEmail(cust.getEmail());
                	newcust.setCheckOutDate(cust.getCheckOutDate());
                	newcust.setName(cust.getName());
                	newcust.setNumberofadults(cust.getNumberofadults());
                	newcust.setNumberOfBeds(cust.getNumberOfBeds());
                	newcust.setNumberofchildren(cust.getNumberofchildren());
                	
                    return roomrepository.save(newcust);
                }).orElseThrow(() -> new CustomerNotFoundException(id));
    }
	
	@GetMapping("/room/{id}")
	Room getUserById(@PathVariable Long id) {
		return roomrepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
	}

	@DeleteMapping("/room/{id}")
	String deleteRoom(@PathVariable Long id) {
		if (!roomrepository.existsById(id)) {
			throw new RoomNotFoundException(id);
		}
		roomrepository.deleteById(id);
		return "Room with id " + id + " has been deleted success.";
	}
	
}
