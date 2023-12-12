package br.com.pierx.emailserver.email;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

import br.com.pierx.emailserver.controller.EmailController;




@Service
@RequestMapping("/send")
public class SendEmails {
	
	@GetMapping
	private static void sendEmail(EmailComponents[] payload) {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIA5R7XGHT2BXG6Z22C", "A1fSmsSnTHZtg8Rg+9WHHPrcb2DRlnYyz4BWpUms");

        AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion(Regions.CA_CENTRAL_1) 
                .build();
        
        
        for(int i=0; i<payload.length;i++) {
        	SendEmailRequest request = new SendEmailRequest()
                    .withDestination(new Destination().withToAddresses(payload[i].to()))
                    .withMessage(new Message()
                            .withBody(new Body()
                                    .withHtml(new Content().withCharset("UTF-8").withData(payload[i].body())))
                            .withSubject(new Content().withCharset("UTF-8").withData(payload[i].subject())))
        			.withSource("pierx@pierxinovacao.com.br");

            client.sendEmail(request);
            System.out.println(payload[i]);
        }
        
    }

}
