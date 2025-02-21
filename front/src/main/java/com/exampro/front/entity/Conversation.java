package com.exampro.front.entity;
import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name = "conversations")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String demande;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "quote_id", nullable = false)
    private Quote quote;
    
    private LocalDateTime date;
    
    public Conversation() {}

	public Conversation(Long id, String demande, Users user, Quote quote) {
		super();
		this.id = id;
		this.demande = demande;
		this.user = user;
		this.quote = quote;
		this.date = java.time.LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDemande() {
		return demande;
	}

	public void setDemande(String demande) {
		this.demande = demande;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
    
}
