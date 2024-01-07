package org.back.end.service;

import java.util.List;

import org.back.end.model.Quote;
import org.back.end.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

	@Autowired
	private QuoteRepository repository;
	
	public List<Quote> findByName(String name) {
		return repository.findByName(name);
	}
	
	public List<Quote> findAll() {
		return repository.findAll();
	}
	
	public String findById(Integer id) {
		return repository.getReferenceById(id).getQuote();
	}
	
	public Quote create(Quote quote) {
		return repository.save(quote);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public long getTotalMessageCount(){
        return repository.count();
    }
	
	public Quote update(Quote quote) {
		return repository.save(quote);
	}
	
}
