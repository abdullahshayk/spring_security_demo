package com.tuts.spring_security.service;

import com.tuts.spring_security.dao.UserDao;
import com.tuts.spring_security.model.User;
import com.tuts.spring_security.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class JpaUserDetailService implements UserDetailsService {
    @Autowired
    UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userDetails=userDao.findStudentByUsername(username);
        return userDetails.map(SecurityUser::new)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}
