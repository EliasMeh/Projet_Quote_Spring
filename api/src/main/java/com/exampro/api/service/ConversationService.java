package com.exampro.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampro.api.entity.Conversation;
import com.exampro.api.repository.ConversationRepository;

import java.util.List;

@Service
public class ConversationService {

    private final ConversationRepository conversationRepository;

    @Autowired
    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public Conversation createConversation(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    public List<Conversation> getAllConversations() {
        return conversationRepository.findAll();
    }

    public Conversation getConversationById(Long id) {
        return conversationRepository.findById(id).orElse(null);
    }

    public void deleteConversation(Long id) {
        conversationRepository.deleteById(id);
    }
}
