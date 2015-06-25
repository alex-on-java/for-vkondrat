package ru.vkondrat.experimental.config;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class App {
    private static final Map<String, ScoringModule> modules = new HashMap<String, ScoringModule>();

    static {
        ScoringLP LP = new ScoringLP();
        LP.loadConfiguration(new HashMap<String, Object>() {{
            put("lpDir", "LP dir");
            put("item", "LP item");
            put("order", 1);
        }});
        ScoringGB GB = new ScoringGB();
        GB.loadConfiguration(new HashMap<String, Object>() {{
            put("gbDir", "GB dir");
            put("item", "GB item");
            put("order", 2);
        }});
        modules.put("LP", LP);
        modules.put("GB", GB);
    }

    public static void main(String[] args) {
        if (args.length != 1)
            throw new RuntimeException("Should be at least and only one argument");
        String scoringType = args[0];
        ScoringModule scoringModule = modules.get(scoringType);
        if (scoringModule == null)
            throw new RuntimeException(String.format("There is no module with name '%s'", scoringType));
        scoringModule.process();
    }
}
