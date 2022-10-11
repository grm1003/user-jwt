package br.com.api.util;

import br.com.api.model.UserModel;
import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.annotations.Signature;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.HashSet;


public class TesteToken {

    public static void main(String[] args) {

        String token =
                Jwt.issuer("https://levelup.com/issuer")
                        .upn("Gabriel")
                        .groups(new HashSet<>(Arrays.asList("admin")))
                        .sign();
        System.out.println(token);
    }


}
