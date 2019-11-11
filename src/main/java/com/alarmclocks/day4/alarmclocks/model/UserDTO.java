package com.alarmclocks.day4.alarmclocks.model;

import org.springframework.security.core.userdetails.User;

public class UserDTO extends User {
    private static final long serialVersionUID = 1L;

    public UserDTO(UserDAO user) {
        super(user.getUserName(), user.getPassword(), user.getGrantedAuthoritiesList());
    }
}
