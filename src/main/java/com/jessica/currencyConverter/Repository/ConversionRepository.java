package com.jessica.currencyConverter.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jessica.currencyConverter.entity.ConversionEntity;
import com.jessica.currencyConverter.entity.UserEntity;

import lombok.Getter;
import lombok.Setter;

public interface ConversionRepository  extends JpaRepository<ConversionEntity, Long>{
	
	List<ConversionEntity> findByUserId(UserEntity userId);

	

}
