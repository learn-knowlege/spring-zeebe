package io.zeebe.spring.broker.properties;

import lombok.Data;

public interface WorkflowProperty extends ZeebeBrokerProperty {

    int getDeploymentCacheSize();

    int getPayloadCacheSize();
}
