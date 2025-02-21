package com.exampro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.exampro.api.entity.Quote;
import com.exampro.api.service.QuoteService;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping
    public List<Quote> getAllQuotes() {
        return quoteService.getAllQuotes();
    }

    @GetMapping("/{id}")
    public Quote getQuoteById(@PathVariable Long id) {
        return quoteService.getQuoteById(id);
    }

    @PostMapping
    public Quote createQuote(@RequestBody Quote quote) {
        return quoteService.createQuote(quote);
    }

    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuote(id);
    }
}
