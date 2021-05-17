package com.jessica.currencyConverter.entity;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table( name = "conversion" )
public class ConversionEntity {
	
	@Getter @Setter
	  private Long id;
	
	@Getter @Setter
	  private Long userId;

	@Getter @Setter
	  private String sourceCurrency;

	@Getter @Setter
	  private String targetCurrency;

	@Getter @Setter
	  private String sourceValue;

	@Getter @Setter
	  private String targetValue;

	@Getter @Setter
	  private String rate;

	@Getter @Setter
	  private Date dateTime;
	  
	  

	  public ConversionEntity() {}

	  public ConversionEntity(Long id, Long userId, String sourceCurrency, String targetCurrency, String sourceValue, String targetValue, String rate, Date datetime) {
		  this.id = id;
		  this.userId = userId;
		  this.sourceCurrency = sourceCurrency;
		  this.sourceValue = sourceValue;
		  this.targetCurrency = targetCurrency;
		  this.targetValue = targetValue;
		  this.rate = rate;
		  this.dateTime = datetime;
				  
	  }

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}


	public void setUserId(Object getuserId) {
		// TODO Auto-generated method stub
		
	}

	public Long getuserId() {
		// TODO Auto-generated method stub
		return this.userId;
	}
}