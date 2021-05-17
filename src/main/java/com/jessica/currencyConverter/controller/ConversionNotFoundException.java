package com.jessica.currencyConverter.controller;

public class ConversionNotFoundException  extends RuntimeException{
	
	
	ConversionNotFoundException(Long id){
		super("could not find conversion" + id);
	}

}
