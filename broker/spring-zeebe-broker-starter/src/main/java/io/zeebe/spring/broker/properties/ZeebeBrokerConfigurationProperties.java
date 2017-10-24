package io.zeebe.spring.broker.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@ConfigurationProperties(prefix = "zeebe.broker")
public class ZeebeBrokerConfigurationProperties implements ZeebeBrokerProperties {

    @NestedConfigurationProperty
    private GlobalPropertyPojo global = new GlobalPropertyPojo();

    @NestedConfigurationProperty
    private TransportComponentPropertyPojo network = new TransportComponentPropertyPojo();

    @NestedConfigurationProperty
    private ThreadingPropertyPojo threading = new ThreadingPropertyPojo();

    @NestedConfigurationProperty
    private LogStreamsPropertyPojo logs = new LogStreamsPropertyPojo();

    @NestedConfigurationProperty
    private WorkflowPropertyPojo workflow = new WorkflowPropertyPojo();

}
