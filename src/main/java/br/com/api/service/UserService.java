package br.com.api.service;


import br.com.api.model.UserModel;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserService {


    public List<UserModel> mostra(){ return UserModel.listAll();}

    public UserModel procura(int id){ return UserModel.findById(id);}
    public String testeapi(){
        return "Abacate";
    }

    @Transactional
    public UserModel  post(UserModel userModel){
       userModel.persist();
       return userModel;
    }


}
