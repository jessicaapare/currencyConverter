package com.jessica.currencyConverter.entity;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "conversion" )
public class ConversionEntity  implements Serializable {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	
	//@ManyToOne(fetch = FetchType.LAZY, optional = false)
	
	private UserEntity user;


	  private String sourceCurrency;


	  private String targetCurrency;


	  private float sourceValue;


	  private float targetValue;


	  private float rate;


	  private String dateTime;
	  
	 

	  public ConversionEntity() {}

	/*  public ConversionEntity(Long id, String sourceCurrency, String targetCurrency, float sourceValue, float targetValue, String rate,UserEntity user) {
		  this.id = id;
		  this.sourceCurrency = sourceCurrency;
		  this.sourceValue = sourceValue;
		  this.targetCurrency = targetCurrency;
		  this.targetValue = targetValue;
		  this.rate = rate;
		  this.dateTime = Instant.now().toString();
		  this.setUser(user);
				  
	  }*/

	  public String getSourceCurrency() {
			return sourceCurrency;
		}

		public void setSourceCurrency(String sourceCurrency) {
			this.sourceCurrency = sourceCurrency;
		}

		public float getSourceValue() {
			return sourceValue;
		}

		public void setSourceValue(float sourceValue) {
			this.sourceValue = sourceValue;
		}

		public String getTargetCurrency() {
			return targetCurrency;
		}

		public void setTargetCurrency(String outputCurrency) {
			this.targetCurrency = outputCurrency;
		}
		
		public float getTargetValue() {
			return targetValue;
		}

		public void setTargetValue(float Value) {
			this.targetValue = Value;
		}

		public float getRate() {
			return rate;
		}

		public void setRate(float exchangeRate) {
			this.rate = exchangeRate;
		}

		public String getDateTime() {
			return dateTime;
		}

		public void setDateTime(String dateTime) {
			this.dateTime = dateTime;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		@ManyToOne(targetEntity=UserEntity.class)
	    @JoinColumn(name="user_id")
		public UserEntity getUser() {
			return user;
		}

		public void setUser(UserEntity user) {
			this.user = user;
		}

		public void conversionCalculation() {
			// TODO Auto-generated method stub
			
			this.targetValue = rate * sourceValue;
			
			
		}
		
		public String toString() {
			// TODO Auto-generated method stub
			
			return this.getSourceCurrency() + "  " + this.getSourceValue() + "\n " + this.getTargetCurrency() + "  " + this.getTargetValue() + " \n " + this.getRate(); 
			
			
		}
		
		
}
