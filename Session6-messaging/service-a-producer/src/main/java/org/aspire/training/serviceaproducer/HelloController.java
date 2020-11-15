package org.aspire.training.serviceaproducer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/hello")
@EnableBinding(HelloProducer.class)
public class HelloController {

	private final HelloProducer helloProducer; 
	
	public HelloController(HelloProducer helloProducer) {
		this.helloProducer = helloProducer;
	}


	@PostMapping("/{name}")
	public void sendingHello(@PathVariable String name) {
		HelloMesssage msg = HelloMesssage.builder()
				.id(UUID.randomUUID().toString())
				.msg("Hello Consumer!")
				.build();


		helloProducer.output()
			.send(MessageBuilder
					.withPayload(msg)
					.build()); 
	}
	
	
}
