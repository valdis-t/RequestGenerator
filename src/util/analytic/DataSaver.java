package util.analytic;

import util.file.FilePathLoader;
import util.file.FileManager;

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DataSaver {
    private final File dataFile;
    private final FileManager fileManager;
    private final Map<String, Integer> data;
    private int keysFound = 0;

    public DataSaver(String name) {
        fileManager = FileManager.getManager();
        dataFile = FilePathLoader.getInstance().getBackupAnalyticFileByDate(LocalDate.now(), name);
        data = new HashMap<>();
        if (dataFile.exists()) {
            String source = fileManager.read(dataFile);
            while (source.length() > 0) {
                String key = source.substring(0, source.indexOf(" = "));
                int value = Integer.parseInt(source.substring(source.indexOf(" = ") + 3, source.indexOf('\n')));
                data.put(key, value);
                keysFound += value;
                source = source.substring(source.indexOf('\n') + 1);
            }
        }
    }

    public void writeData(Map<String, Integer> data) {
        StringBuilder builder = new StringBuilder();
        data.forEach((key, count) -> {
            builder
                    .append(key)
                    .append(" = ")
                    .append(count)
                    .append('\n');
        });
        fileManager.write(dataFile, builder.toString(), false);
    }

    public Map<String, Integer> getPreviousData() {
        return new HashMap<>(data);
    }

    public int getKeysFound() {
        return keysFound;
    }
}
