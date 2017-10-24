package io.zeebe.spring.broker.properties;

import lombok.Data;

@Data
public class WorkflowPropertyPojo implements WorkflowProperty {

    private int deploymentCacheSize;

    private int payloadCacheSize;
}
