package com.exampro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;

import com.exampro.api.entity.Conversation;
import com.exampro.api.entity.Quote;
import com.exampro.api.entity.Users;
import com.exampro.api.service.ConversationService;
import com.exampro.api.service.QuoteService;
import com.exampro.api.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api/conversations")
public class ConversationController {

    private final ConversationService conversationService;
    private final QuoteService quoteService;
    private final UsersService usersService;

    @Autowired
    public ConversationController(ConversationService conversationService, 
                                  QuoteService quoteService, 
                                  UsersService usersService) {
        this.conversationService = conversationService;
        this.quoteService = quoteService;
        this.usersService = usersService;
    }

    @GetMapping
    public List<Conversation> getAllConversations() {
        return conversationService.getAllConversations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getConversationById(@PathVariable Long id) {
        Conversation conversation = conversationService.getConversationById(id);
        if (conversation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(conversation);
    }

    @PostMapping
    public ResponseEntity<?> createConversation(@RequestBody Conversation conversation) {
        try {
            if (conversation.getQuote() == null || conversation.getQuote().getId() == null) {
                return ResponseEntity.badRequest().body("Quote is required");
            }
            if (conversation.getUser() == null || conversation.getUser().getId() == null) {
                return ResponseEntity.badRequest().body("User is required");
            }

            Quote quote = quoteService.getQuoteById(conversation.getQuote().getId());
            if (quote == null) {
                return ResponseEntity.badRequest().body("Invalid quote ID");
            }

            Users user = usersService.getUserById(conversation.getUser().getId());
            if (user == null) {
                return ResponseEntity.badRequest().body("Invalid user ID");
            }

            conversation.setQuote(quote);
            conversation.setUser(user);

            Conversation savedConversation = conversationService.createConversation(conversation);
            return ResponseEntity.ok(savedConversation);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("Data integrity violation: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConversation(@PathVariable Long id) {
        try {
            conversationService.deleteConversation(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An error occurred while deleting: " + e.getMessage());
        }
    }
}
