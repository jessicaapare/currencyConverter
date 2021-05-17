package com.jessica.currencyConverter.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jessica.currencyConverter.entity.ConversionEntity;

import lombok.Getter;
import lombok.Setter;

public interface ConversionRepository  extends JpaRepository<ConversionEntity, Long>{
	
	 
	@Query("select u from conversion u where u.id = ?1")
	Optional<ConversionEntity> findById(Long id);

 
	  
		public static final Long id = null;
		
		@Getter @Setter
		public static final Long userId = null;

		public static final String sourceCurrency = "";

		public static final String targetCurrency = "";

		public static final String sourceValue = "";

		public static final String targetValue = "";

		public static final String rate = "";

		public static final Date dateTime = new Date();
		  
	

}
