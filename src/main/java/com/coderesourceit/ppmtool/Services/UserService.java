package com.coderesourceit.ppmtool.Services;

import com.coderesourceit.ppmtool.Repositories.UserRepository;
import com.coderesourceit.ppmtool.domain.User;
import com.coderesourceit.ppmtool.exceptions.UsernameAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(User newUser) {
        try {
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

            // Username has to be unique(Exception)
            newUser.setUsername(newUser.getUsername());
            newUser.setConfirmPassword("");

            //Ensure that password and confirm password matches
            return userRepository.save(newUser);

        } catch (Exception e) {
            throw new UsernameAlreadyExistsException("Username '" + newUser.getUsername() + "' already exist");
        }
    }

}
