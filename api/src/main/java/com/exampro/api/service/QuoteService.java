package com.exampro.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampro.api.entity.Quote;
import com.exampro.api.repository.QuoteRepository;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService {

    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }
    
    public Quote getRandomQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        if (!quotes.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(quotes.size());
            return quotes.get(randomIndex); 
        }
        return null; 
    }
}
