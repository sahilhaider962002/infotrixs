package org.back.end.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.back.end.model.Quote;
import org.back.end.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quoteOfTheDay")
public class QuoteOfTheDayRestController {

	@Autowired
	private QuoteService service;
	
	@GetMapping()
	public String quoteOfTheDay() {
		List<Quote> quoteList = service.findAll();
		if(quoteList.isEmpty()) {
			return "No message found";
		}
		long totalMessageCount = quoteList.size();
		Map<Integer, Integer> map = new HashMap<>();
		int i = 1;
		for (Quote quote: quoteList) {
			map.put(i++, quote.getId());
		}
		int random = 1 + (int)(Math.random() * ((totalMessageCount - 1) + 1));
		return service.findById(map.get(random));
	}
	
	@PostMapping("/create")
	public Quote create(@RequestBody Quote quote) {
		return service.create(quote);
	}
	
	@PutMapping("/update")
	public Quote update(@RequestBody Quote quote) {
		return service.create(quote);
	} 
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		service.delete(id);
	}

	@GetMapping("/messageByName")
	public List<Quote> messageByName(@RequestParam String name){
		List<Quote> quoteList = service.findByName(name);
		if (quoteList.isEmpty()) {
			return new ArrayList<>();
		}
		return quoteList;
	}

}

	
