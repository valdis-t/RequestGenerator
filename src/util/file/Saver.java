package util.file;

import gui.panel.Readable;
import gui.panel.saver.SavedPanel;
import util.file.FileManager;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class Saver {
    private static final FileManager manager = FileManager.getManager();
    private static final SavedPanel logger = SavedPanel.getInstance();

    public static void saveToFile(Readable readable, String additionalText) {
        String string;
        if (readable != null) {
            string = readable.getAllText();
        } else string = "Ошибка! Пустой объект.";
        logger.setText(string);
        manager.writeToHistory(string);
        manager.writeIntoSaved(string, additionalText);
    }

    public static void saveToBuffer(Readable readable) {
        String string;
        if (readable != null) {
            string = readable.getAllText();
        } else string = "Ошибка! Пустой объект.";
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(string), null);
        manager.writeToHistory(string);
    }
}
