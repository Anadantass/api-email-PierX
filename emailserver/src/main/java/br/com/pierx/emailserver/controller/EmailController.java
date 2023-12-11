package br.com.pierx.emailserver.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pierx.emailserver.email.EmailComponents;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@PostMapping
	public void email(@RequestBody EmailComponents components) {
		System.out.println(components);
		
	}
	
}
