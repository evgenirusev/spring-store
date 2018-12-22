package com.store.areas.user.services;

import com.store.areas.user.models.service.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void create(UserServiceModel userServiceModele);

    boolean isUsernameTaken(String username);

    boolean isEmailTaken(String email);

    UserServiceModel findByUsername(String username);
}