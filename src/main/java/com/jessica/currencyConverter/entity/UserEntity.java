package com.jessica.currencyConverter.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "`user`")
public class UserEntity {
	
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	
	  private String name;


	  private String CPF;
	  
	  /*@OneToMany(mappedBy = "user")
		private List<ConversionEntity> conversion = new ArrayList<>();
*/

	  public UserEntity() {}


	  
/*	  public void addConversionEntry(ConversionEntity conversionEntry) {
			conversion.add(conversionEntry);
			conversionEntry.setUser(this);
		}

		public void removeConversion(ConversionEntity conversionEntry) {
			conversion.remove(conversionEntry);
			conversionEntry.setUser(null);
		}
*/
	  public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		public String getCPF() {
			return CPF;
		}

		public void setCPF(String cpf) {
			this.CPF = cpf;
		}
	
	

}
