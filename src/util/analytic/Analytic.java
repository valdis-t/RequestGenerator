package util.analytic;

import util.file.FilePathLoader;
import util.file.FileManager;

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Analytic {
    private final List<AnalyticsContainer> containerList = new LinkedList<>();
    private File monthAnalyticFile;
    private File currentAnalyticFile;

    public void add(AnalyticsContainer container) {
        containerList.add(container);
    }

    public void saveAllAnalytic() {
        currentAnalyticFile = FilePathLoader.getInstance().getAnalyticFile("analytic_" + LocalDate.now());
        currentAnalyticFile.delete();
        FileManager.getManager().write(currentAnalyticFile, "Повна аналітика на дату " + LocalDate.now() + ':' + '\n' + '\n', true);
        for (AnalyticsContainer container : containerList) {
            container.backup();
            FileManager.getManager().write(currentAnalyticFile, container.toString() + '\n' + '\n', true);
        }
        generateMonthAnalytic(LocalDate.now().getYear(), LocalDate.now().getMonthValue());
    }

    public File getMonthAnalyticFile(){
        saveAllAnalytic();
        return monthAnalyticFile;
    }

    public File getCurrentAnalyticFile(){
        saveAllAnalytic();
        return currentAnalyticFile;
    }

    public void generateMonthAnalytic(int year, int month) {
        HashMap<String, AnalyticsContainer> collector = new HashMap<>();
        File rootDirect = FilePathLoader.getInstance().getHistoryDirection(year, month);
        for (File currentFile : rootDirect.listFiles()) {
            if (Character.isDigit(currentFile.getName().charAt(0))) {
                String name = currentFile.getName().substring(LocalDate.now().toString().length(), currentFile.getName().indexOf('.'));
                AnalyticsContainer container;
                if (collector.containsKey(name)) {
                    container = collector.get(name);
                } else {
                    container = new AnalyticsContainer(name);
                    collector.put(name, container);
                }
                String source = FileManager.getManager().read(currentFile);
                while (source.length() > 0) {
                    String key = source.substring(0, source.indexOf(" = "));
                    int value = Integer.parseInt(source.substring(source.indexOf(" = ") + 3, source.indexOf('\n')));
                    for (; value < 0; value--) {
                        container.collect(key);
                    }
                    source = source.substring(source.indexOf('\n') + 1);
                }
            }
        }
        StringBuilder builder = new StringBuilder("Місячна аналітика на " + year + "-0" + month + '\n');
        collector.forEach((key, value) -> {
            builder
                    .append('\n')
                    .append(value.toString())
                    .append('\n');
        });
        monthAnalyticFile = FilePathLoader.getInstance().createFile(rootDirect, "analytic_" + year + "-0" + month + FilePathLoader.textFileExtension);
        FileManager.getManager().write(monthAnalyticFile, builder.toString(), false);
    }

    public AnalyticsContainer getAnalyticContainer(String name) {
        for (AnalyticsContainer current : containerList) if (current.getName().equals(name)) return current;
        AnalyticsContainer container = new AnalyticsContainer(name);
        containerList.add(container);
        return container;
    }
}
