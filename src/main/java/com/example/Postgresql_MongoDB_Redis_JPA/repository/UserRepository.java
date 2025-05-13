package com.example.Postgresql_MongoDB_Redis_JPA.repository;

import com.example.Postgresql_MongoDB_Redis_JPA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}