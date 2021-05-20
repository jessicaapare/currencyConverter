package com.jessica.currencyConverter.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.jessica.currencyConverter.controller.ConversionController;
import com.jessica.currencyConverter.entity.ConversionEntity;

@Component
public class ConversionModelAssembler implements RepresentationModelAssembler<ConversionEntity, EntityModel<ConversionEntity>> {

	@Override
	public EntityModel<ConversionEntity> toModel(ConversionEntity conversion) {
		return EntityModel.of(conversion,
				linkTo(methodOn(ConversionController.class).one(conversion.getId())).withSelfRel(),
				linkTo(methodOn(ConversionController.class).all()).withRel("conversions"));
	}

}
