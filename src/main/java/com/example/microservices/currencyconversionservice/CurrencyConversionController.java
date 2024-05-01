package com.example.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Configuration(proxyBeanMethods = false)
class RestTemplateConfiguration {
    
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}

@RestController
public class CurrencyConversionController {
	
	@Autowired
	CurrencyExchangeServiceProxy proxy;
	
	@Autowired
    private RestTemplate restTemplate;

	
	
	@GetMapping("/currency-converter"
			+ "/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String,String> urivariables = new HashMap<>();
		urivariables.put("from", from);
		urivariables.put("to", to);
		/**
		 * adding rest template so that it can show up in zipking tracing
		 * before it was not showing because it was calling new RestTemplate()
		 */
		//ResponseEntity<CurrencyConversionBean> responseEntity=  new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,urivariables);
		ResponseEntity<CurrencyConversionBean> responseEntity= restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,urivariables);

		CurrencyConversionBean response = responseEntity.getBody();
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());

	}
	
	@GetMapping("/currency-converter-feign"
			+ "/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
	CurrencyConversionBean response = proxy.retreiveExchangeValue(from, to);
	return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());

	}

}
