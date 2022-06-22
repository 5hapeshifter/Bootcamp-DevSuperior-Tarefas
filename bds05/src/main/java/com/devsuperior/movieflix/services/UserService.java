package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;
//
//    @Autowired
//    private AuthService authService;
//
//    // metodo responsavel por buscar o usuario
//    @Transactional(readOnly = true)
//    public UserDTO findById(Long id) {
//        authService.validateSelfOrAdmin(id);
//        Optional<User> obj = repository.findById(id);
//        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found")); // se tiver um erro na consulta, o objeto não existir, a msg será enviada
//        return new UserDTO(entity);
//    }
//
    //Método da interface UserDetailService que busca o usuario por email
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username);
        if (user == null) {
            logger.error("User not found: " + username);
            throw new UsernameNotFoundException("Email not found.");
        }
        logger.info("User found: " + username);
        return user;
    }
}
