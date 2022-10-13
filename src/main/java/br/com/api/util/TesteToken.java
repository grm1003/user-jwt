package br.com.api.util;

import br.com.api.model.UserModel;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;
import io.smallrye.jwt.util.KeyUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.annotations.Signature;

import javax.enterprise.context.ApplicationScoped;
import javax.management.relation.Role;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;




public class TesteToken {

    public static void main(String[] args) throws Exception {

        String privateKeyLocation = "/privatekey.pem";
        PrivateKey privateKey = KeyUtils.readPrivateKey(privateKeyLocation);

        JwtClaimsBuilder claimsBuilder = Jwt.claims();


        claimsBuilder.issuer("https://levelup.com/issuer");
        claimsBuilder.subject("Gabriel");
        claimsBuilder.groups("admin");
        System.out.println(claimsBuilder.jws().signatureKeyId(privateKeyLocation).sign(privateKey));

    }


}
