package com.exampro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.exampro.api.entity.Conversation;
import com.exampro.api.service.ConversationService;

import java.util.List;

@RestController
@RequestMapping("/api/conversations")
public class ConversationController {

    private final ConversationService conversationService;

    @Autowired
    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @GetMapping
    public List<Conversation> getAllConversations() {
        return conversationService.getAllConversations();
    }

    @GetMapping("/{id}")
    public Conversation getConversationById(@PathVariable Long id) {
        return conversationService.getConversationById(id);
    }

    @PostMapping
    public Conversation createConversation(@RequestBody Conversation conversation) {
        return conversationService.createConversation(conversation);
    }

    @DeleteMapping("/{id}")
    public void deleteConversation(@PathVariable Long id) {
        conversationService.deleteConversation(id);
    }
}
