package com.app.consumer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.app.domain.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Component
public class ConsumerService {
	
	
	@Value("${google.recaptcha.secretkey}")
	private String recpatchaSecretKey;

	@Value("${google.recaptcha.url}")
	private String recpatchaUrl;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	public Response readRecaptcha(String captcha) throws UnirestException, JsonMappingException, JsonProcessingException {
		
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("secret",recpatchaSecretKey);
		queryMap.put("response",captcha);
		
		HttpResponse<JsonNode> httpResponse = Unirest.post(recpatchaUrl).queryString(queryMap).asJson();
		
		Response response = objectMapper.readValue(httpResponse.getBody().toString(), Response.class);
		
		return response;
	}

}
