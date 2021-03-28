package edu.ada.service.library.model.service;

import edu.ada.service.library.model.dto.RegistrationModel;
import edu.ada.service.library.model.entity.UserEntity;

public interface AuthenticationService {

    boolean registration(RegistrationModel registrationModel);


    UserEntity findUser(String email, String password);

    void updateToken(UserEntity userEntity);

    UserEntity findUserByID(long id);

}
