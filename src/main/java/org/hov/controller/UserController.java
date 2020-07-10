package org.hov.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.hov.model.User;
import org.hov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//@CrossOrigin(value = "")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/add")
	public ResponseEntity<Void> addUser(@Valid @RequestBody User user){
		if(userService.addUser(user)){
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Void> updateUser(@Valid @RequestBody User user){
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
	
	@GetMapping("/byemail/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email){
		return new ResponseEntity<User>(userService.getUserByEmail(email), HttpStatus.OK);
	}
	
	@GetMapping("/byphone/{phone}")
	public ResponseEntity<User> getUserByPhone(@PathVariable("phone") String phone){
		return new ResponseEntity<User>(userService.getUserByPhone(phone), HttpStatus.OK);
	}
	
	// BELOW CODES ARE UNDER DEVELOPMENT
	@GetMapping("/profile")
	public ResponseEntity<User> getUserById(@PathVariable("id") String id){
		return new ResponseEntity<User>(userService.getUserById(UUID.fromString(id)), HttpStatus.OK);
	}
	
	@GetMapping("/wishlist")
	public ResponseEntity<User> getWishListById(@PathVariable("id") String id){
		return new ResponseEntity<User>(userService.getUserById(UUID.fromString(id)), HttpStatus.OK);
	}
	
	@GetMapping("/cartlist")
	public ResponseEntity<User> getCartListById(@PathVariable("id") String id){
		return new ResponseEntity<User>(userService.getUserById(UUID.fromString(id)), HttpStatus.OK);
	}
	
	@GetMapping("/orderlist")
	public ResponseEntity<User> getOrderListById(@PathVariable("id") String id){
		return new ResponseEntity<User>(userService.getUserById(UUID.fromString(id)), HttpStatus.OK);
	}
	
	/* Login */	
	@PostMapping("/login")
	public ResponseEntity<User> userLogin(@RequestBody User user){
		return new ResponseEntity<User>(userService.getUserById(UUID.fromString("")), HttpStatus.OK);
		//return new ResponseEntity<User>(new FieldError("user", "email", "already exists"), HttpStatus.BAD_REQUEST);;
	}
	
	/* Logout */	
	@PostMapping("/logout")
	public ResponseEntity<User> userLogoff(@RequestBody User user){
		return new ResponseEntity<User>(userService.getUserById(UUID.fromString("")), HttpStatus.OK);
	}
}
