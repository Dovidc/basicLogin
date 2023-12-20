package com.simple.login.simple.form.maven.Service;

import com.simple.login.simple.form.maven.model.UsersModel;
import com.simple.login.simple.form.maven.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersModel registeredUser(String login, String password, String email) {
        if (login == null || password == null) {
            return null;
        } else {
            UsersModel usersModel = new UsersModel();
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            usersModel.setEmail(email);
            return usersRepository.save(usersModel);
        }
    }
    public UsersModel authenticate (String login, String password) {
        return usersRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
