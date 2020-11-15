package org.aspire.training.servicebconsumer;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.time.Clock;

@EnableBinding(HelloConsumer.class)
public class HelloListener {

    @StreamListener(HelloConsumer.INPUT_CHANNEL)
    public void recievingHelloMsg(HelloMesssage msg){
        System.out.println("Hello " + msg);

    }
}
