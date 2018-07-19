package com.kinesis.demo.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableBinding(Processor.class)
@EnableAutoConfiguration
public class ProducerApplication {


  public static void main(String[] args) {
    SpringApplication.run(ProducerApplication.class, args);
  }


  @StreamListener(Sink.INPUT)
  public void listen(String message) {
    System.out.println("Message has been received: " + message);
  }
  
  @PostMapping(path = "/send")
  public void send(@RequestBody  String message) {
    processor.output().send(MessageBuilder.withPayload(message).build());
  }

}
