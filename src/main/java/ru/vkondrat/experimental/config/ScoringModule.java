package ru.vkondrat.experimental.config;

import java.util.HashMap;
import java.util.Map;

/**
 */
public abstract class ScoringModule extends ProcessingModule {
    // Maybe we should move configurationParamTypes and configurationParams to ProcessingModule
    protected final Map<String, Class> configurationParamTypes = new HashMap<String, Class>();
    protected final Map<String, Object> configurationParams = new HashMap<String, Object>();

    public void loadConfiguration(Map<String, Object> configurationParams) {
        for (Map.Entry<String, Object> e : configurationParams.entrySet()) {
            if (e.getValue() == null)
                throw new RuntimeException(String.format("Configuration parameter '%s' is null", e.getKey()));
            if (!configurationParamTypes.get(e.getKey()).isInstance(e.getValue()))
                throw new RuntimeException(String.format("Configuration parameter '%s' has type of '%s', and should be '%s'",
                        e.getKey(), e.getValue().getClass().getSimpleName(), configurationParamTypes.get(e.getKey()).getSimpleName()));

            this.configurationParams.put(e.getKey(), e.getValue());
        }
    }

    protected abstract void fillParamTypes();

    public ScoringModule() {
        fillParamTypes();
    }
}
