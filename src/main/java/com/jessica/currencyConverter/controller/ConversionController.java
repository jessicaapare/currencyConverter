package com.jessica.currencyConverter.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jessica.currencyConverter.Repository.*;
import com.jessica.currencyConverter.entity.ConversionEntity;
import com.jessica.currencyConverter.model.ConversionModelAssembler;

@RestController
public
class ConversionController {
	
	private final ConversionRepository conversionRepository;
	private final ConversionModelAssembler assembler;
	
	public ConversionController(ConversionRepository conversionRepository,
			ConversionModelAssembler assembler) {
		this.conversionRepository = conversionRepository;
		this.assembler = assembler;
	}

//Get user id
	@GetMapping("/conversions/{id}")
	public
	EntityModel<ConversionEntity> one(@PathVariable Long id) {
		ConversionEntity conversion = conversionRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Conversion id '" + id + "' does no exist"));
		return assembler.toModel(conversion);
	}
	
	//get all conversions

	@GetMapping("/conversions")
	public
	CollectionModel<EntityModel<ConversionEntity>> all() {
		List<EntityModel<ConversionEntity>> conversions = conversionRepository.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		return CollectionModel.of(conversions,
				linkTo(methodOn(ConversionController.class).all()).withSelfRel());
	}


// create conversion
	@PostMapping("/conversions")
	ResponseEntity<?> newConversion(@RequestBody ConversionEntity newConversion) {
	 	EntityModel<ConversionEntity> entityModel =
					assembler.toModel(conversionRepository.save(newConversion));
			return ResponseEntity
					.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
					.body(entityModel);
		}

	
	


	/*  @PutMapping("/conversion/{id}")
	  ConversionEntity replaceConversion(@RequestBody ConversionEntity newConversion, @PathVariable Long id) {
	    
	    return convertionRepository.findById(id)
	      .map(conversion -> {
	    	  conversion.setUserId(newConversion.getuserId());
	    	  
	    	  
	        return convertionRepository.save(conversion);
	      })
	      .orElseGet(() -> {
	    	  newConversion.setId(id);
	        return convertionRepository.save(newConversion);
	      });
	  }*/

	  @DeleteMapping("/conversion/{id}")
	  void deleteConversion(@PathVariable Long id) {
		  conversionRepository.deleteById(id);
	  }
	

}
