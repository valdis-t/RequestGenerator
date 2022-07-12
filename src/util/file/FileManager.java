package util.file;

import util.text.StringDefaultValue;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private static FileManager manager;

    private FileManager() {
    }

    public static FileManager getManager() {
        if (manager == null) manager = new FileManager();
        return manager;
    }

    public void writeToHistory(String text) {
        write(FilePathLoader.getInstance().getHistoryFile(), text, true);
    }

    public void writeIntoSaved(String text) {
        write(FilePathLoader.getInstance().getCurrentSavedFile(), text, true);
    }

    public void writeIntoSaved(String text, String prefixedText) {
        writeIntoSaved(prefixedText + StringDefaultValue.NEW_LINE_TEXT + text + StringDefaultValue.DIVIDER);
    }

    public String getKey() {
        return read(FilePathLoader.getInstance().getKeyFile());
    }

    public String getUserScript() {
        return read(FilePathLoader.getInstance().getUserScriptsFile());
    }

    public String getCallButtonNames() {
        return read(FilePathLoader.getInstance().getCallButtonNamesFile());
    }

    public String read(File file) {
        try (FileReader reader = new FileReader(file)) {
            int symbol;
            StringBuilder builder = new StringBuilder();
            while ((symbol = reader.read()) != -1) {
                builder.append((char) symbol);
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void write(File targetFile, String text, boolean append) {
        try (FileWriter writer = new FileWriter(targetFile, append)) {
            targetFile.createNewFile();
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
