package com.jessica.currencyConverter.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jessica.currencyConverter.Repository.UserRepository;
import com.jessica.currencyConverter.entity.UserEntity;
import com.jessica.currencyConverter.model.UserModelAssembler;

@RestController
public class UserController {
	private final UserRepository userRepository;
	private final UserModelAssembler assembler;

	public UserController(UserRepository userRepository,
			UserModelAssembler assembler) {
		this.userRepository = userRepository;
		this.assembler = assembler;
	}

	// Get User Id
	@GetMapping("/users/{id}")
	public
	EntityModel<UserEntity> one(@PathVariable Long id) {
		UserEntity user = userRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("User id '" + id + "' does no exist"));
		return assembler.toModel(user);
	}
// All Users
	@GetMapping("/users")
	public
	CollectionModel<EntityModel<UserEntity>> all() {
		List<EntityModel<UserEntity>> users = userRepository.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		return CollectionModel.of(users,
				linkTo(methodOn(UserController.class).all()).withSelfRel());
	}

	
	//new User
	@PostMapping("/users")
	ResponseEntity<?> newUser(@Valid @RequestBody UserEntity newUser) {
		EntityModel<UserEntity> entityModel =
				assembler.toModel(userRepository.save(newUser));
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}
}