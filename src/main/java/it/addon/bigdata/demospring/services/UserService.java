package it.addon.bigdata.demospring.services;

import it.addon.bigdata.demospring.entities.User;
import it.addon.bigdata.demospring.repositories.UserRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepoInjection) {
        this.userRepo = userRepoInjection;
    }

    public User add(User user) {
        // if User. exsist => throw Exception // msg
        this.log.info("ADD USER: User doesn't exist => allow to proceed");
        User createdUser = this.userRepo.save(user);
        this.log.info("ADD USER: User created => send email");
        // if user created => send mail => MaiManager.send(....)
        this.log.info("ADD USER: email sent => account creation done");
        return createdUser;
    }
}
