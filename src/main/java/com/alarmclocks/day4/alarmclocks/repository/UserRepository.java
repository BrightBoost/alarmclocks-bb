package com.alarmclocks.day4.alarmclocks.repository;

import com.alarmclocks.day4.alarmclocks.model.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDAO getUserDetails(String userName) {
        Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
        String userSQLQuery = "SELECT * FROM USERS WHERE USERNAME=?";
        List<UserDAO> list = jdbcTemplate.query(userSQLQuery, new String[] {userName},
            (ResultSet rs, int rowNum) -> {
                    UserDAO user = new UserDAO();
                    user.setUserName(userName);
                    user.setPassword(rs.getString("PASSWORD"));
                    return user;
            });
        if(list.size() > 0) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
            grantedAuthoritiesList.add(grantedAuthority);
            list.get(0).setGrantedAuthoritiesList(grantedAuthoritiesList);
            return list.get(0);
        }
        return null;
    }
}
