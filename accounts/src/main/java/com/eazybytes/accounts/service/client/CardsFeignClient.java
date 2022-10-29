package com.eazybytes.accounts.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eazybytes.accounts.model.Cards;
import com.eazybytes.accounts.model.Customer;
// by this you're able to fetch info from cards services
//("cards") app name 
@FeignClient("cards")
public interface CardsFeignClient {
// @PostMapping("/myCards")
	@RequestMapping(method = RequestMethod.POST, value = "myCards", consumes = "application/json")
	List<Cards> getCardDetails(@RequestHeader("eazybank-correlation-id") String correlationid,@RequestBody Customer customer);
}
