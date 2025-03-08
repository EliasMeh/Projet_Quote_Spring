package com.exampro.front.controller;

import com.exampro.front.service.ConversationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.exampro.front.entity.Conversation;
import com.exampro.front.entity.Quote;

@Controller
public class ConversationController {
	@Autowired
    private RestTemplate restTemplate;


    @Autowired
    private ConversationService conversationService;
    
    @GetMapping("/")
    public String showIndexPage(Model model) {
        return "index";
    }

    @GetMapping("/conversations")
    public String showConversationPage(Model model) {
        model.addAttribute("conversations", conversationService.getAllConversations());
        return "vueadmin";
    }

    @PostMapping("/conversation")
    public String postConversation(@RequestParam String username, @RequestParam String demande, Model model) {
        conversationService.saveConversation(username, demande);

        Quote quote = restTemplate.getForObject("http://localhost:8080/api/getQuote", Quote.class);

        model.addAttribute("quote", quote.getQuote());

        return "index";
    }

}

