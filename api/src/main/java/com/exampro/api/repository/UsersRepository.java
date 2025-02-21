package com.exampro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampro.api.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
