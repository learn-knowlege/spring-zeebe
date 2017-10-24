package io.zeebe.spring.broker.config;

import io.zeebe.broker.system.ConfigurationManager;
import io.zeebe.broker.system.GlobalConfiguration;
import io.zeebe.spring.broker.properties.ZeebeBrokerProperties;

import java.util.List;

public class SpringConfigurationManager implements ConfigurationManager {

    private final ZeebeBrokerProperties properties;

    public SpringConfigurationManager(final ZeebeBrokerProperties properties) {
        this.properties = properties;
    }


    @Override
    public <T> T readEntry(String componentName, Class<T> configObjectType) {
        return null;
    }

    @Override
    public <T> List<T> readList(String s, Class<T> aClass) {
        throw new UnsupportedOperationException("readList is not supported (nor used)");
    }

    @Override
    public GlobalConfiguration getGlobalConfiguration() {
        return null;
    }
}
