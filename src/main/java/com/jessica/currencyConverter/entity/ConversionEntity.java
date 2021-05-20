package com.jessica.currencyConverter.entity;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "conversion" )
public class ConversionEntity {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	
	/*@ManyToOne(fetch = FetchType.LAZY, optional = false)
	  private UserEntity user;
*/

	  private String sourceCurrency;


	  private String targetCurrency;


	  private String sourceValue;


	  private String targetValue;


	  private String rate;


	  private String dateTime;
	  
	  

	  public ConversionEntity() {}

	  public ConversionEntity(Long id, String sourceCurrency, String targetCurrency, String sourceValue, String targetValue, String rate) {
		  this.id = id;
		  this.sourceCurrency = sourceCurrency;
		  this.sourceValue = sourceValue;
		  this.targetCurrency = targetCurrency;
		  this.targetValue = targetValue;
		  this.rate = rate;
		  this.dateTime = Instant.now().toString();
				  
	  }

	  public String getSourceCurrency() {
			return sourceCurrency;
		}

		public void setSourceCurrency(String sourceCurrency) {
			this.sourceCurrency = sourceCurrency;
		}

		public String getSourceValue() {
			return sourceValue;
		}

		public void setSourceValue(String sourceValue) {
			this.sourceValue = sourceValue;
		}

		public String getTargetCurrency() {
			return targetCurrency;
		}

		public void setTargetCurrency(String outputCurrency) {
			this.targetCurrency = outputCurrency;
		}
		
		public String getTargetValue() {
			return targetValue;
		}

		public void setTargetValue(String Value) {
			this.targetValue = Value;
		}

		public String getRate() {
			return rate;
		}

		public void setRate(String exchangeRate) {
			this.rate = exchangeRate;
		}

		public String getDateTime() {
			return dateTime;
		}

		public void setConvertedOnUTC(String dateTime) {
			this.dateTime = dateTime;
		}

		/*public UserEntity getUser() {
			return user;
		}

		public void setUser(UserEntity user) {
			this.user = user;
		}*/
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
}
