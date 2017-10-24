package io.zeebe.spring.broker.properties;

import lombok.Data;

@Data
public class SocketBindingPropertyPojo implements SocketBindingProperty {

    private String host;
    private int port;
    private int receiveBufferSize;
    private int sendBufferSize;
    private long controlMessageRequestTimeoutInMillis;
}
