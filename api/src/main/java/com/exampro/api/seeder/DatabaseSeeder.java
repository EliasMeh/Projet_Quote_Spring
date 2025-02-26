package com.exampro.api.seeder;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.exampro.api.entity.Quote;
import com.exampro.api.service.QuoteService;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private QuoteService quotesService;

    @Override
    public void run(String... args) throws Exception {
            quotesService.createQuote(new Quote("Optimism is the faith that leads to achievement. Nothing can be done without hope and confidence."));
            quotesService.createQuote(new Quote("Optimism is the madness of insisting that all is well when we are miserable."));
            quotesService.createQuote(new Quote("Optimism is essential to achievement and it is also the foundation of courage and true progress."));
            quotesService.createQuote(new Quote("My optimism wears heavy boots and is loud."));
            quotesService.createQuote(new Quote("If women ran the world we wouldn't have wars, just intense negotiations every 28 days."));
            quotesService.createQuote(new Quote("Spring is nature's way of saying, 'Let's party!'"));
            quotesService.createQuote(new Quote("People say satire is dead. It's not dead; it's alive and living in the White House."));
            quotesService.createQuote(new Quote("We had gay burglars the other night. They broke in and rearranged the furniture."));
            quotesService.createQuote(new Quote("Gentiles are people who eat mayonnaise for no reason."));

//Source : https://www.brainyquote.com/quotes/robin_williams_378504

    }
}
