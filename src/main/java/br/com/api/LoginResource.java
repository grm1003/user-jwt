package br.com.api;

import br.com.api.service.LoginService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class LoginResource {
    @Inject
    LoginService loginService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String login(int id) {
        return loginService.login(id);
    }
}
