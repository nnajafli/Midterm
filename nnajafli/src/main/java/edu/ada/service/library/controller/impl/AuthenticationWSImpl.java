package edu.ada.service.library.controller.impl;

import edu.ada.service.library.controller.AuthenticationWS;
import edu.ada.service.library.model.dto.RegistrationModel;
import edu.ada.service.library.model.entity.UserEntity;
import edu.ada.service.library.model.service.AuthenticationService;
import edu.ada.service.library.utils.MD5Encryption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping("/auth")
public class AuthenticationWSImpl implements AuthenticationWS {

    protected static Logger logger = LoggerFactory.getLogger(AuthenticationWSImpl.class);


    @Autowired
    private AuthenticationService authenticationService;

    @Override
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity login(
            @RequestHeader("email") String email,
            @RequestHeader("password") String password
    ) {

        UserEntity userEntity = authenticationService.findUser(email, MD5Encryption.encryption(password));
        if (userEntity != null) {
            Random random = new Random();
            int token = random.nextInt(1000);
            return ResponseEntity.ok().header("token", String.valueOf(token))
                    .body("You Have Been Successfully Authorized");
        }
        logger.info("User Not Founded");
        return ResponseEntity.ok("User Not Founded");


    }


    @Override
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(
            @RequestBody RegistrationModel formData
    ) {

        if (authenticationService.registration(formData)) {
            logger.info("User Registered");
            return ResponseEntity.created(null).build();
        } else {
            return ResponseEntity.unprocessableEntity().build();
        }

    }
}
