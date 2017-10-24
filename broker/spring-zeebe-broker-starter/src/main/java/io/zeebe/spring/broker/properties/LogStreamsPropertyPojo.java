package io.zeebe.spring.broker.properties;

import lombok.Data;

@Data
public class LogStreamsPropertyPojo implements LogStreamsProperty {

    private int defaultLogSegmentSize;

    private String[] directories;
}
