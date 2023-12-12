package br.com.pierx.emailserver.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.pierx.emailserver.email.EmailComponents;

@RestController
@RequestMapping("")
public class EmailController {
	
	@PostMapping
	public void email(@RequestBody EmailComponents[] payload) {
		
		payload.getClass();
		
		System.out.println(""+payload.length);
	
		for(int i =0; i<payload.length; i++) {
			System.out.println("to: "+payload[i].to());
			System.out.println("subject: "+payload[i].subject());
			System.out.println("body: "+payload[i].body());
			System.out.println("------------");
		}
		

			
	}
	
	
}