package com.exampro.front.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exampro.front.entity.Conversation;
import com.exampro.front.entity.Users;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    List<Conversation> findByUserOrderByDateDesc(Users user);
}
