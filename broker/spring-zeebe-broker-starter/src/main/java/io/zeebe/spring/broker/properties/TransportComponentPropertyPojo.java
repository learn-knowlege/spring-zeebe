package io.zeebe.spring.broker.properties;

import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
public class TransportComponentPropertyPojo implements TransportComponentProperty {

    private String host;
    private int sendBufferSize;
    private int defaultReceiveBufferSize;

    @NestedConfigurationProperty
    private SocketBindingProperty clientApi = new SocketBindingPropertyPojo();
    @NestedConfigurationProperty
    private SocketBindingProperty managementApi = new SocketBindingPropertyPojo();
    @NestedConfigurationProperty
    private SocketBindingProperty replicationApi = new SocketBindingPropertyPojo();

    @NestedConfigurationProperty
    private GossipProperty gossip = new GossipPropertyPojo();
    @NestedConfigurationProperty
    private ClusterManagementProperty management = new ClusterManagementPropertyPojo();


}
