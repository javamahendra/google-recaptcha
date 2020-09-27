package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.consumer.ConsumerService;
import com.app.domain.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.exceptions.UnirestException;

@Component
public class Validator {
	
	@Autowired
	private ConsumerService consumerService;
	
	public boolean validateRecaptcha(String captcha) throws JsonMappingException, JsonProcessingException, UnirestException {
		
		Response response = consumerService.readRecaptcha(captcha);
		
		return response.isSuccess();
	}
}
