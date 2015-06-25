package ru.vkondrat.experimental.config;

import java.util.Map;

/**
 */
public class ScoringGB extends ScoringModule {
    @Override
    protected void fillParamTypes() {
        configurationParamTypes.put("gbDir", String.class);
        configurationParamTypes.put("item", String.class);
        configurationParamTypes.put("order", Integer.class);
    }

    @Override
    public void process() {
        System.out.println("Processing ScoringGB. Config:");
        for (Map.Entry<String, Object> e : configurationParams.entrySet()) {
            System.out.printf("%s = %s%n", e.getKey(), e.getValue());
        }
    }
}
