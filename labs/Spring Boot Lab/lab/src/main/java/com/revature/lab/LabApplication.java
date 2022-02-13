package com.revature.lab;

import com.revature.lab.models.Account;
import com.revature.lab.models.User;
import com.revature.lab.repo.AccountRepo;
import com.revature.lab.repo.UserRepo;
import com.revature.lab.utilities.ApplicationContextProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LabApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabApplication.class, args);

		ApplicationContext context = ApplicationContextProvider.getApplicationContext();
		AccountRepo accountRepo = context.getBean(AccountRepo.class);
		UserRepo userRepo = context.getBean(UserRepo.class);

		Account account = new Account(99.99, "checking");
		accountRepo.save(account);
		User user = new User("username", "password");
		user.addAccount(account);
		userRepo.save(user);
	}

}
