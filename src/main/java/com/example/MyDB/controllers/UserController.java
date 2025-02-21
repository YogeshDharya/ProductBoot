package com.example.MyDB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyDB.dto.UserRequest;
import com.example.MyDB.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
//@Validated
@Tag(name = "User Controller", description = "Controller for managing user APIs")
//@RequestMapping("/api")
public class UserController {

	private final UserService serviceInterface;

	@Autowired
	public UserController(UserService serviceImplObject) {
		this.serviceInterface = serviceImplObject;
	}

	@Operation(summary = "Get all Users", description = "Retrieve the list of Users")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved All Users ", content = @Content(schema = @Schema(implementation = UserRequest.class))),
			@ApiResponse(responseCode = "404", description = "No Users found", content = @Content) })
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers() {
		return serviceInterface.getAllUsers();
	}

	@Operation(summary = "Get the user by ID", description = "Retrieve a user from its ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved a user", content = @Content(schema = @Schema(implementation = UserRequest.class))),
			@ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
	@GetMapping("/users/{id}")
	//(@Valid 
	public ResponseEntity<?> getUser(@RequestParam Long userId) {
		return serviceInterface.getUserById(userId);
	}

	@Operation(summary = "Save a User", description = "Save a new user into the database")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "User successfully saved", content = @Content(schema = @Schema(implementation = UserRequest.class))),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content) })
	@PostMapping("/users")
	//@Valid
	public ResponseEntity<?> saveUser(@RequestBody UserRequest requestEntity) {
		return serviceInterface.saveUser(requestEntity);
	}

}