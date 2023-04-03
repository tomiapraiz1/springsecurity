package com.example.springcifrado;

import com.example.springcifrado.entitites.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.springcifrado.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringCifradoApplication {

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringCifradoApplication.class, args);
		UserRepository userRepository = applicationContext.getBean(UserRepository.class);

		PasswordEncoder encoder = applicationContext.getBean(PasswordEncoder.class);

		User user = new User(null, "usuario", encoder.encode("admin"));
		userRepository.save(user);
	}

}
