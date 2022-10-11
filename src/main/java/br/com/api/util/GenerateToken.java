package br.com.api.util;

import br.com.api.model.UserModel;
import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.HashSet;

@ApplicationScoped
public class GenerateToken {

    @ConfigProperty(name = "https://levelup.com/issuer")
    String issuer;

    public String generateTokenJWT(UserModel userModel) {
    String token =
                Jwt.issuer(issuer)
                        .upn(userModel.getName())
                        .groups(new HashSet<>(Arrays.asList("user", "admin")))
                        .sign();
        return token;
    }
}
