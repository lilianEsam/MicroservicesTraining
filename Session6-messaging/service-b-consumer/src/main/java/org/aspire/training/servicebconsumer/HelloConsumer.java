package org.aspire.training.servicebconsumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface HelloConsumer {

    String INPUT_CHANNEL = "hello-input-ch";

    @Input(INPUT_CHANNEL)
    SubscribableChannel input();
}
