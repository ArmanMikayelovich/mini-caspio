package com.mikayelovich.mini.caspio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@SpringBootApplication
@RestController
@RequestMapping
public class CaspioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaspioApplication.class, args);
	}

	@GetMapping("/caspio")
	public void test(HttpServletResponse response) {
		int i = new Random().nextInt(9);
		if (i < 4) {
			response.setStatus(503);
		}else {
			response.setStatus(200);
		}
	}
}
