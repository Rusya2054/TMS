package com.task.Rusya2054.services;

import com.task.Rusya2054.models.User;
import com.task.Rusya2054.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Spring Security тут будет знать как подгружать User-ов
 * Адаптер между вашей собственной БД пользователей и тем что требуется Spring Security внутри SecurityContextHolder
 */
@Data
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails user = userRepository.findByEmail(email).orElse(new User());
        System.out.println("user: " + user);
        return user;
    }
}
