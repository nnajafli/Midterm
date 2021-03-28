package edu.ada.service.library.controller.impl;

import edu.ada.service.library.controller.AuthenticationWS;
import edu.ada.service.library.model.dto.RegistrationModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationWSLDAPImpl implements AuthenticationWS {

    @Override
    public ResponseEntity login(String email, String password) {
        return null;
    }

    @Override
    public ResponseEntity register(RegistrationModel formData) {
        return null;
    }
}
