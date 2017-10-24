package io.zeebe.spring.broker.properties;

public interface LogStreamsProperty extends ZeebeBrokerProperty {

    int getDefaultLogSegmentSize();

    String[] getDirectories();
}
