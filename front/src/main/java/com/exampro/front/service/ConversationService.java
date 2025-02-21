package com.exampro.front.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exampro.front.entity.Conversation;
import com.exampro.front.entity.Users;
import com.exampro.front.entity.Quote;

@Service
public class ConversationService {
	
    @Autowired
    private RestTemplate restTemplate;

    public List<Conversation> fetchConversations() {
        String apiURL = "http://localhost:8080/api/conversations";
        
        ResponseEntity<List<Conversation>> response = restTemplate.exchange(
            apiURL,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Conversation>>() {}
        );

        return response.getBody();
    }


	
    public String postConversation(String demande, Long userId, Long quoteId) {
        String apiURL = "http://localhost:8080/api/conversations";

        // Création de l'objet Conversation avec les informations nécessaires
        Users user = new Users(userId, null); // Juste l'ID suffisant
        Quote quote = new Quote(quoteId, null);
        Conversation conversation = new Conversation(null, demande, user, quote);

        // Envoi de la requête
        ResponseEntity<String> response = restTemplate.postForEntity(apiURL, conversation, String.class);

        return response.getBody();
    }
}
