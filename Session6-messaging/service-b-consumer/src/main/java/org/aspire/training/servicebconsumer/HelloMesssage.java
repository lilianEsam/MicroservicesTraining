package org.aspire.training.servicebconsumer;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder(toBuilder = true)
@ToString
public class HelloMesssage {

    private String id;
    private String msg;
}
