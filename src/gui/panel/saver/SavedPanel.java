package gui.panel.saver;

import boot.GUIComponentsParameter;

import javax.swing.*;

public class SavedPanel extends JPanel {
    private final static String DIVIDER = "\n***********************************\n";
    private static SavedPanel instance;
    private static JTextArea textArea;

    private SavedPanel() {
        setName("Збережене");
        textArea = GUIComponentsParameter.getTextAreaForLogger();
        add(new JScrollPane(textArea));
        setLocation(GUIComponentsParameter.LOGGER_FRAME_X, 0);
    }

    public static SavedPanel getInstance() {
        if (instance == null) {
            instance = new SavedPanel();
        }
        return instance;
    }

    public void removeText() {
        textArea.setText("");
    }

    public void setText(String text) {
        textArea.append(DIVIDER);
        textArea.append(text);
    }
}
