package com.jessica.currencyConverter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jessica.currencyConverter.Repository.*;
import com.jessica.currencyConverter.entity.ConversionEntity;

@RestController
class ConversionController {
	
	private final ConversionRepository convertionRepository;
	
	ConversionController(ConversionRepository repository) {
	    this.convertionRepository = repository;
	  }


	  // Aggregate root
	  // tag::get-aggregate-root[]
	  @GetMapping("/conversion")
	  List<ConversionEntity> all() {
	    return convertionRepository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping("/conversion")
	  ConversionEntity newEmployee(@RequestBody ConversionEntity newConversion) {
	    return convertionRepository.save(newConversion);
	  }

	  // Single item
	  
	  @GetMapping("/conversion/{id}")
	  ConversionEntity one(@PathVariable Long id) {
	    
	    return convertionRepository.findById(id)
	      .orElseThrow(() -> new ConversionNotFoundException(id));
	  }

	  @PutMapping("/conversion/{id}")
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
	  }

	  @DeleteMapping("/conversion/{id}")
	  void deleteEmployee(@PathVariable Long id) {
		  convertionRepository.deleteById(id);
	  }
	

}
