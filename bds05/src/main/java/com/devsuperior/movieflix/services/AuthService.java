package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ForbiddenException;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // metodo responsavel por verificar se o usuario possui autorizacao
    @Transactional(readOnly = true) // como e uma operacao de leitura, podemos usar essa anotacao para nao fazer o loock no BD
    public User authenticated() {
        try {
            // chamada para pegar o usuario que ja foi reconhecido pelo spring security
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.findByEmail(userName);
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid User");
        }
    }

    // metodo responsavel por verificar se o usuario possui nivel de acesso
    public void validateSelfOrAdmin(Long userId) {
        User user = authenticated();
        if (!user.getId().equals(userId) && !user.hasHole("ROLE_ADMIN")) {
            throw new ForbiddenException("Access denied");
        }
    }
}
