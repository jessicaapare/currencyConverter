package com.jessica.currencyConverter.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.jessica.currencyConverter.controller.UserController;
import com.jessica.currencyConverter.entity.UserEntity;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<UserEntity, EntityModel<UserEntity>> {
	@Override
	public EntityModel<UserEntity> toModel(UserEntity user) {
		return EntityModel.of(user,
				linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
				linkTo(methodOn(UserController.class).all()).withRel("users"));
	}
}