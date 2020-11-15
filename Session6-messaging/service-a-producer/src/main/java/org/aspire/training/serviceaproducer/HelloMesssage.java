package org.aspire.training.serviceaproducer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class HelloMesssage {

    private String id;
    private String msg;

}
