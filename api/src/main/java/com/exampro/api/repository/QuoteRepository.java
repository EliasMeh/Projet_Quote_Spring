package com.exampro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampro.api.entity.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
