package com.example.demo.models;


import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.NotNull;

public enum Role implements GrantedAuthority {
    USER, DOCTOR, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }



}

