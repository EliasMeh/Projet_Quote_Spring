package com.exampro.front.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exampro.front.entity.Conversation;
import com.exampro.front.entity.Quote;
import com.exampro.front.entity.Users;
import com.exampro.front.repository.ConversationRepository;
import com.exampro.front.repository.UserRepository;


@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    public List<Conversation> getAllConversations() {
        return conversationRepository.findAll();
    }

    public void saveConversation(String username, String demande) {
        Users user = userRepository.findByUsername(username)
            .orElseGet(() -> {
                Users newUser = new Users();
                newUser.setUsername(username);
                return userRepository.save(newUser);
            });

        Conversation conversation = new Conversation();
        conversation.setUser(user);
        conversation.setDemande(demande);
        conversation.setDate(LocalDateTime.now());
        
        Quote quote = restTemplate.getForObject("http://localhost:8080/api/getQuote", Quote.class);
        conversation.setQuote(quote);
        
        conversationRepository.save(conversation);
    }
}
