package com.shadowhunter.jpa.repository;

import com.shadowhunter.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
