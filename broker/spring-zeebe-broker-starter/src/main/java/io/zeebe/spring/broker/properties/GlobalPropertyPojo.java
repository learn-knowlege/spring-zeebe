package io.zeebe.spring.broker.properties;

import lombok.Data;

@Data
public class GlobalPropertyPojo implements GlobalProperty {

    private boolean tempDirectory;

}
