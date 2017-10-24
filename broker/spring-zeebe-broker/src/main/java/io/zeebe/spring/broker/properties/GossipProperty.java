package io.zeebe.spring.broker.properties;

public interface GossipProperty extends ZeebeBrokerProperty {

    String[] getInitialContactPoints();

    int getPeerCapacity();

    int getPeersStorageInterval();

    int getDisseminatorCapacity();
    int getDisseminationInterval();
    int getDisseminationTimeout();

    int getFailureDetectionCapacity();
    int getFailureDetectionProbeCapacity();
    int getFailureDetectorTimeout();

    int getProbeCapacity();
    int getProbeTimeout();


    int getSuspicionTimeout();
}
