package com.revature.lab.controllers;

import com.revature.lab.exceptions.UserNotFoundException;
import com.revature.lab.models.User;
import com.revature.lab.repo.AccountRepo;
import com.revature.lab.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    public final UserRepo userRepo;
    public final AccountRepo accountRepo;

    @Autowired
    public UserController(UserRepo userRepo, AccountRepo accountRepo) {
        this.userRepo = userRepo;
        this.accountRepo = accountRepo;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void newUser(@RequestBody User user) {
        userRepo.save(user);
    }

    @RequestMapping(value = "/{userId}")
    public User getUserById(@PathVariable Integer userId) throws UserNotFoundException {
        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UserNotFoundException("User not found!");
        }
    }
}
