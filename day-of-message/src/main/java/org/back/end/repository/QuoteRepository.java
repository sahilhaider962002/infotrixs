package org.back.end.repository;

import java.util.List;

import org.back.end.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {

	List<Quote> findByName(String name);
	
}
