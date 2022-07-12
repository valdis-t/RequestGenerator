package util.file;

import boot.Boot;
import util.text.StringDefaultValue;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

public class FilePathLoader {
    public static final String textFileExtension = ".txt";
    private static final String toParentDirection = ".." + File.separator;
    public static final File analyticRootDirection = new File(toParentDirection + "analytics");
    private static FilePathLoader instance;
    private final String historyFilePath = "history" + textFileExtension;
    private final String savedFileName = "saved";
    private final String keyFilePath = "key" + textFileExtension;
    private final String userScriptsFilePath = "chat_scripts" + textFileExtension;
    private final String callButtonNamesPath = "call_button_names" + textFileExtension;
    private final File analyticDirection = new File(analyticRootDirection, File.separator + Boot.currentMonth);
    private final File historyDirection = new File(toParentDirection + "history" + File.separator + Boot.currentMonth);
    private final File savedDirection = new File(toParentDirection + "saved" + File.separator + Boot.currentMonth);
    private final File scriptsDirection = new File(toParentDirection + "scripts");
    private final HashMap<String, File> files = new HashMap<>();

    private FilePathLoader() {
        analyticDirection.mkdirs();
        analyticDirection.mkdirs();
        savedDirection.mkdirs();
        historyDirection.mkdirs();
        scriptsDirection.mkdirs();
    }

    public static FilePathLoader getInstance() {
        if (instance == null) instance = new FilePathLoader();
        return instance;
    }

    public File getAnalyticFile(String name) {
        return files.containsKey(name + textFileExtension) ? files.get(name + textFileExtension) : createFile(analyticDirection, name + textFileExtension);
    }

    public File getHistoryFile() {
        return files.containsKey(historyFilePath) ? files.get(historyFilePath) : createFile(historyDirection, historyFilePath);
    }

    public File getHistoryDirection(int year, int month) {
        return new File(toParentDirection + "history" + File.separator + year + "-0" + month);
    }

    public File getBackupAnalyticFileByDate(LocalDate date, String name) {
        return new File(historyDirection, date + name + textFileExtension);
    }

    public File getCurrentSavedFile() {
        String currentSavedFileName = savedFileName + StringDefaultValue.OLD_SPACE + LocalDate.now().getDayOfMonth() + StringDefaultValue.OLD_SPACE + LocalDate.now().getMonthValue() + StringDefaultValue.OLD_SPACE + LocalDate.now().getYear() + textFileExtension;
        return files.containsKey(currentSavedFileName) ? files.get(currentSavedFileName) : createFile(savedDirection, currentSavedFileName);
    }

    public File getKeyFile() {
        return files.containsKey(keyFilePath) ? files.get(keyFilePath) : createFile(null, keyFilePath);
    }

    public File getUserScriptsFile() {
        return files.containsKey(userScriptsFilePath) ? files.get(userScriptsFilePath) : createFile(scriptsDirection, userScriptsFilePath);
    }

    public File getCallButtonNamesFile() {
        return files.containsKey(callButtonNamesPath) ? files.get(callButtonNamesPath) : createFile(scriptsDirection, callButtonNamesPath);
    }

    public File createFile(File parentDirection, String name) {
        File file;
        if (parentDirection == null) file = new File(name);
        else file = new File(parentDirection, name);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        files.put(file.getAbsolutePath(), file);
        return file;
    }
}
