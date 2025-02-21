package com.exampro.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampro.api.entity.Quote;
import com.exampro.api.repository.QuoteRepository;

import java.util.List;

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

    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    public Quote getQuoteById(Long id) {
        return quoteRepository.findById(id).orElse(null);
    }

    public void deleteQuote(Long id) {
        quoteRepository.deleteById(id);
    }
}
