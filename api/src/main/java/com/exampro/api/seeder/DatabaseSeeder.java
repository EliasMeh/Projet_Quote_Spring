package com.exampro.api.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.exampro.api.entity.Conversation;
import com.exampro.api.entity.Quote;
import com.exampro.api.entity.Users;
import com.exampro.api.repository.ConversationRepository;
import com.exampro.api.repository.QuoteRepository;
import com.exampro.api.repository.UsersRepository;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private ConversationRepository conversationRepository;

    @Override
    public void run(String... args) {
        Users user1 = userRepository.save(new Users(null, "JohnDoe"));
        Users user2 = userRepository.save(new Users(null, "JaneDoe"));

        Quote quote1 = quoteRepository.save(new Quote(null, "The only limit to our realization of tomorrow is our doubts of today."));
        Quote quote2 = quoteRepository.save(new Quote(null, "Life is what happens when you're busy making other plans."));

        conversationRepository.save(new Conversation(null, "What is your philosophy?", user1, quote1));
        conversationRepository.save(new Conversation(null, "Give me an inspirational quote.", user2, quote2));
    }
}
