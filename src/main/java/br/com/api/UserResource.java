package br.com.api;
import br.com.api.model.UserModel;
import br.com.api.service.LoginService;
import br.com.api.service.UserService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/auth")
public class UserResource {


    @Inject
    LoginService loginService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String login(int id) {
        return loginService.login(id);
    }

    @Inject
    private UserService userService;


    @Path("/user")
    @GET
    @RolesAllowed({"admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserModel> get() {
        return userService.mostra();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public UserModel post(UserModel userModel) {
        return userService.post(userModel);
    }






}

