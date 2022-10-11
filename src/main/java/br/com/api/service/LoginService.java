package br.com.api.service;

import br.com.api.model.UserModel;
import br.com.api.util.GenerateToken;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class LoginService {
    @Inject
    GenerateToken generateToken;

    @Inject
    UserService userService;

    public LoginService() {
    }

    public String login(int id){
        UserModel user = userService.procura(id);
        String token =  generateToken.generateTokenJWT(user);
        return token;

    }

}
