package util.analytic;

import java.util.Map;

public class AnalyticsContainer {
    private final Map<String, Integer> analytics;
    private final String name;
    private double total = 0;

    public AnalyticsContainer(String name) {
        this.name = name;
        DataSaver dataSaver = new DataSaver(name);
        analytics = dataSaver.getPreviousData();
        total = dataSaver.getKeysFound();
    }

    public void collect(String key) {
        String trimmedKey = key.trim().toUpperCase().replaceAll("\\r|\\n", "");
        analytics.put(trimmedKey, analytics.get(trimmedKey) == null ? 1 : analytics.get(trimmedKey) + 1);
        total++;
    }

    public void backup() {
        new DataSaver(name).writeData(analytics);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(name + ':');
        analytics.forEach((key, value) -> {
            builder
                    .append('\n')
                    .append(key)
                    .append(" = ")
                    .append(value)
                    .append(" (")
                    .append(String.format("%.1f", value / total * 100))
                    .append("%)");
        });
        builder
                .append('\n')
                .append("ЗАГАЛЬНО: ")
                .append((int) total);
        return builder.toString();
    }
}
