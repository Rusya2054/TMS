package com.task.Rusya2054.services;

import com.task.Rusya2054.models.User;
import com.task.Rusya2054.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // для шифровки пароля


    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }

    /**
     * Получение текущего пользователя
     *
     * @return текущий пользователь
     */
    public User getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        var email = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(email);
        return getByEmail(email);
    }
}
