package com.azadkaya.ticketapp.repository;

import com.azadkaya.ticketapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String azad);

    Optional<User> findOneWithRolesByUsername(String login);

    Optional<User> findOneByUsername(String username);
}
