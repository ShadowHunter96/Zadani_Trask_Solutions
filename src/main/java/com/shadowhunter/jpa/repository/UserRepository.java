package com.shadowhunter.jpa.repository;

import com.shadowhunter.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select avg(technologylevel) FROM User ")
    public double avg();
}
