package com.exampro.api.entity;
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
    
    public Conversation() {}

	public Conversation(Long id, String demande, Users user, Quote quote) {
		super();
		this.id = id;
		this.demande = demande;
		this.user = user;
		this.quote = quote;
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
    
}
