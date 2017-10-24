package io.zeebe.spring.broker.properties;

import lombok.Data;

@Data
public class GossipPropertyPojo implements GossipProperty {

    private String[] initialContactPoints;

    private int peerCapacity;

    private int peersStorageInterval;

    private int disseminatorCapacity;
    private int disseminationInterval;
    private int disseminationTimeout;

    private int failureDetectionCapacity;
    private int failureDetectionProbeCapacity;
    private int failureDetectorTimeout;

    private int probeCapacity;
    private int probeTimeout;

    private int suspicionTimeout;
}
