package edu.ada.service.library.controller;

import edu.ada.service.library.model.dto.RegistrationModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthenticationWS {
    ResponseEntity login(String email, String password);

    ResponseEntity register(RegistrationModel formData);


}
