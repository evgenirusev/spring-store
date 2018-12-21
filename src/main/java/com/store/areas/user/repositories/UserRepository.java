package com.store.areas.user.repositories;

import com.store.areas.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findOneByUsername(String username);

    User findByEmail(String email);
}