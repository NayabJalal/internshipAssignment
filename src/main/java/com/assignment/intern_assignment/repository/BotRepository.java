package com.assignment.intern_assignment.repository;

import com.assignment.intern_assignment.entity.Bot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BotRepository extends JpaRepository<Bot , Long> {
}
