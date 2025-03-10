package com.exampro.api.entity;

import jakarta.persistence.*;

@Entity

public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String quote;

    public Quote() {}
    
	public Quote(String quote) {
		super();
		this.quote = quote;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
    
}
