package com.tuts.spring_security.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCon {

    @GetMapping("test")
    public String test(){

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        authentication.getAuthorities().forEach(a-> System.out.println(a.getAuthority()));
        return "Test";
    }

}
