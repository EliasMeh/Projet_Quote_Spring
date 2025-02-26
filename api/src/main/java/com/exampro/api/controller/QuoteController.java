package com.exampro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.exampro.api.entity.Quote;
import com.exampro.api.service.QuoteService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }
    
    @GetMapping("/getQuote")
    public Quote getRandomQuote() {
    	return quoteService.getRandomQuote();
    }
}
