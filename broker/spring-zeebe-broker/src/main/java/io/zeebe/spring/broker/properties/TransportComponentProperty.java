package io.zeebe.spring.broker.properties;

public interface TransportComponentProperty extends ZeebeBrokerProperty {

    String getHost();

    int getSendBufferSize();

    int getDefaultReceiveBufferSize();

    SocketBindingProperty getClientApi();

    SocketBindingProperty getManagementApi();

    SocketBindingProperty getReplicationApi();

    GossipProperty getGossip();

    ClusterManagementProperty getManagement();

}
