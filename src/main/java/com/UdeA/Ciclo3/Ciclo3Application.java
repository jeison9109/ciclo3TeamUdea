package com.UdeA.Ciclo3;

import com.UdeA.Ciclo3.modelos.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class Ciclo3Application {

	@GetMapping("/hello")
	public  String hello (){
		return "Bienvenidos cilo 3";
	}

	@GetMapping("/test")
	public  String test (){
		Empresa emp = new Empresa("churritos","av 20#2-32","762322","9002322-1");
		return emp.getNombre();
	}
	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
	}

}
