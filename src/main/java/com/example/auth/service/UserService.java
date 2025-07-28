package com.example.auth.service;

import com.example.auth.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void registerUser(User user) {
        String sql = "BEGIN CREATE_USER_PROC(:username, :password, :role); END;";
        entityManager.createNativeQuery(sql)
                .setParameter("username", user.getUsername())
                .setParameter("password", passwordEncoder.encode(user.getPassword()))
                .setParameter("role", user.getRole())
                .executeUpdate();
    }
}
