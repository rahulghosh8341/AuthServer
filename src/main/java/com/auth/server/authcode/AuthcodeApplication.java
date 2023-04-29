package com.auth.server.authcode;

import com.auth.server.authcode.user.User;
import com.auth.server.authcode.user.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class AuthcodeApplication {


	public static void main(String[] args) {
		SpringApplication.run(AuthcodeApplication.class, args);
	}
	@Bean
	public ApplicationRunner dataLoader(UserRepository repo, PasswordEncoder encoder) {
			return args -> {
				repo.save(
						new User("habuma", encoder.encode("password"), "ROLE_ADMIN"));
				repo.save(
						new User("tacochef", encoder.encode("password"), "ROLE_ADMIN"));
			};
		}
}

