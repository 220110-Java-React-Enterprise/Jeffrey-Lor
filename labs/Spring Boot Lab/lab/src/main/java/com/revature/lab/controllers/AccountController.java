package com.revature.lab.controllers;

import com.revature.lab.exceptions.UserNotFoundException;
import com.revature.lab.models.Account;
import com.revature.lab.models.User;
import com.revature.lab.repo.AccountRepo;
import com.revature.lab.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountRepo accountRepo;
    private final UserRepo userRepo;

    @Autowired
    public AccountController(AccountRepo accountRepo, UserRepo userRepo) {
        this.accountRepo = accountRepo;
        this.userRepo = userRepo;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void newAccountForUser(@RequestBody Account account, @PathVariable Integer userId) throws UserNotFoundException {
        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.addAccount(account);
            userRepo.save(user);
            accountRepo.save(account);
        } else {
            throw new UserNotFoundException("User not found!");
        }
    }
}
