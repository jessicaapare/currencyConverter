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

import java.util.Date;
import java.util.List;

@Entity
@Table( name = "conversion" )
public class ConversionEntity {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	  private UserEntity user;


	  private String sourceCurrency;


	  private String targetCurrency;


	  private Long sourceValue;


	  private Long targetValue;


	  private float rate;


	  private Date dateTime;
	  
	  

	  public ConversionEntity() {}

	  public ConversionEntity(Long id, String sourceCurrency, String targetCurrency, Long sourceValue, Long targetValue, Float rate, Date datetime) {
		  this.id = id;
		  this.sourceCurrency = sourceCurrency;
		  this.sourceValue = sourceValue;
		  this.targetCurrency = targetCurrency;
		  this.targetValue = targetValue;
		  this.rate = rate;
		  this.dateTime = datetime;
				  
	  }

	  public String getSourceCurrency() {
			return sourceCurrency;
		}

		public void setSourceCurrency(String sourceCurrency) {
			this.sourceCurrency = sourceCurrency;
		}

		public Long getSourceValue() {
			return sourceValue;
		}

		public void setSourceValue(Long sourceValue) {
			this.sourceValue = sourceValue;
		}

		public String getTargetCurrency() {
			return targetCurrency;
		}

		public void setTargetCurrency(String outputCurrency) {
			this.targetCurrency = outputCurrency;
		}

		public Float getRate() {
			return rate;
		}

		public void setRate(Float exchangeRate) {
			this.rate = exchangeRate;
		}

		public Date getDateTime() {
			return dateTime;
		}

		public void setConvertedOnUTC(Date dateTime) {
			this.dateTime = dateTime;
		}

		public UserEntity getUser() {
			return user;
		}

		public void setUser(UserEntity user) {
			this.user = user;
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
}
