package com.jessica.currencyConverter.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "user" )
public class UserEntity {
	
	@Getter @Setter
	  private Long id;
	
	@Getter @Setter
	  private String name;

	@Getter @Setter
	  private String CPF;


	  public UserEntity() {}

	  public UserEntity(Long id,  String name, String CPF) {
		  this.id = id;
		  this.name = name;
		  this.CPF = CPF;
	
				  
	  }

}
