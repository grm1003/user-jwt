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
        String token;
        try {
            token = generateToken.generateTokenJWT(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return token;

    }

}
