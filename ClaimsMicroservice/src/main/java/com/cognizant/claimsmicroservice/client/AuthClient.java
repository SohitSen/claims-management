package com.cognizant.claimsmicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.claimsmicroservice.model.AuthenticationResponse;

@FeignClient(name = "authenticationFeignClient",url = "http://localhost:8089/authorization")
public interface AuthClient {

	@GetMapping("/validate") 
	  public AuthenticationResponse getValidity(@RequestHeader("Authorization") final String token);
}