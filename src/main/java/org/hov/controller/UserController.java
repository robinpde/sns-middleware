package org.hov.controller;

import java.util.UUID;

import org.hov.model.User;
import org.hov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/user")
@CrossOrigin(value = "")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/byemail/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email){
		return new ResponseEntity<User>(userService.getUserByEmail(email), HttpStatus.OK);
	}
	
	@GetMapping("/byphone/{phone}")
	public ResponseEntity<User> getUserByPhone(@PathVariable("phone") String phone){
		return new ResponseEntity<User>(userService.getUserByPhone(phone), HttpStatus.OK);
	}
	
	@GetMapping("/byid/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") String id){
		return new ResponseEntity<User>(userService.getUserById(UUID.fromString(id)), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Void> addUser(@RequestBody User user){
		if(userService.addUser(user)){
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Void> updateUser(@RequestBody User user){
		if(userService.updateUser(user)){
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") String id){
		if(userService.removeUser(UUID.fromString(id))){
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
}
