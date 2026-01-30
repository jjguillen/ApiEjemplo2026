package com.jaroso.apiejemplo2026.services;

import com.jaroso.apiejemplo2026.dtos.AuthDto;
import com.jaroso.apiejemplo2026.dtos.UserCreateDto;
import com.jaroso.apiejemplo2026.dtos.UserDto;
import com.jaroso.apiejemplo2026.entities.User;
import com.jaroso.apiejemplo2026.repositories.UserRepository;
import com.jaroso.apiejemplo2026.security.PasswordConfig;
import com.jaroso.apiejemplo2026.security.UserAuthority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDto save(UserCreateDto userDTO) {
        User user = new User(
                null,
                userDTO.userName(),
                passwordEncoder.encode(userDTO.password()),
                userDTO.email(),
                List.of(UserAuthority.READ)
        );

        //Comprobar que el username no esté ya en BBDD
        if (this.repository.findByUserName(user.getUsername()).isPresent()) {
            log.error("El usuario ya existe");
            throw new RuntimeException("El usuario ya existe");
        }

        //Si no existe lo insertamos en BBDD y devolvemos un UserDto
        this.repository.save(user);

        return new UserDto(user.getId(), user.getUsername(), user.getEmail());
    }

}
