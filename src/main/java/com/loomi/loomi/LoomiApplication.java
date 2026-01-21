package com.loomi.loomi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.loomi.loomi.domain.usuario.Usuario;

@SpringBootApplication
public class LoomiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoomiApplication.class, args);
		System.out.println("Hello!");

	}

}
