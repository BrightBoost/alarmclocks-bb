package com.alarmclocks.day4.alarmclocks.service;

import com.alarmclocks.day4.alarmclocks.model.UserDAO;
import com.alarmclocks.day4.alarmclocks.model.UserDTO;
import com.alarmclocks.day4.alarmclocks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDTODetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserDAO userDAO = null;
        try {
            userDAO = userRepository.getUserDetails(username);
            UserDTO userDTO = new UserDTO(userDAO);
            return userDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User " + username + "was not found in the database");
        }
    }
}
