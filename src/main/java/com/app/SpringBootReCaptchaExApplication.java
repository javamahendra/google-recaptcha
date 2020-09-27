package com.app;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mashape.unirest.http.Unirest;

@SpringBootApplication
public class SpringBootReCaptchaExApplication implements InitializingBean, DisposableBean{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReCaptchaExApplication.class, args);
	}

	private Integer connectionTimeout = 2000;
	private Integer requestTimeout = 6000;
	
	/*@PostConstruct
	public void init() {
		Unirest.setConcurrency(50, 40);
		Unirest.setTimeouts(connectionTimeout, requestTimeout);		
	}*/

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Unirest.setConcurrency(50, 40);
		Unirest.setTimeouts(connectionTimeout, requestTimeout);
	}
}
