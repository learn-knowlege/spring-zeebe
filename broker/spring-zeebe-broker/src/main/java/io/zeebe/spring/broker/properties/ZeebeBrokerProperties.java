package io.zeebe.spring.broker.properties;

public interface ZeebeBrokerProperties extends ZeebeBrokerProperty {



    GlobalProperty getGlobal();

    TransportComponentProperty getNetwork();

    ThreadingProperty getThreading();

    LogStreamsProperty getLogs();

    WorkflowProperty getWorkflow();
}
