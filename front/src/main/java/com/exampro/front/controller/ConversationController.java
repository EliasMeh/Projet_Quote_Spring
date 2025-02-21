package com.exampro.front.controller;

import com.exampro.front.service.ConversationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.exampro.front.entity.Conversation;

@Controller
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @GetMapping("/conversations")
    public String getConversations(Model model) {
        List<Conversation> conversations = conversationService.fetchConversations(); // Liste bien définie
        model.addAttribute("conversations", conversations);
        return "vueadmin"; 
    }


}
