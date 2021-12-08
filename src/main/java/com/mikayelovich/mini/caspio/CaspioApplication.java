package com.mikayelovich.mini.caspio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@RestController
@RequestMapping
public class CaspioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaspioApplication.class, args);
	}

	@PostMapping("/caspio")
	public ResponseEntity<ResponseModel> test() {
		int i = new Random(10).nextInt();
		if (i < 5) {
			return ResponseEntity.status(503).body(new ResponseModel(503));
		}else {
			return ResponseEntity.status(200).build();
		}
	}

	public static class ResponseModel {
		public ResponseModel(int code) {
			this.code = code;
		}
		private final int code;
	}
}
