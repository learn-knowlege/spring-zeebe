package io.zeebe.spring.broker.properties;

public interface SocketBindingProperty extends ZeebeBrokerProperty {

    String getHost();
    int getPort();
    int getReceiveBufferSize();
    int getSendBufferSize();
    long getControlMessageRequestTimeoutInMillis();
}
