package gui.panel.percentageresponse;

import boot.GUIComponentsParameter;
import gui.component.control.ButtonForControlPanel;
import gui.component.control.ControlPanel;
import gui.layout.VerticalLayoutManager;
import gui.panel.Readable;
import util.file.Saver;

import javax.swing.*;

public class RawResultPanel extends JPanel implements Readable {
    private static RawResultPanel instance;
    private final JTextArea textArea;

    private RawResultPanel() {
        setName("Попередній результат ЗЗ");
        textArea = GUIComponentsParameter.getTextAreaForRawResultPanel();

        JButton copyToLogButton = new ButtonForControlPanel("Зверегти");
        JButton copyToBufferButton = new ButtonForControlPanel("Копіювати");
        copyToLogButton.addActionListener(l -> Saver.saveToFile(this, getName()));
        copyToBufferButton.addActionListener(l -> Saver.saveToBuffer(this));

        JPanel buttonPanel = new ControlPanel();
        buttonPanel.add(copyToBufferButton);
        buttonPanel.add(copyToLogButton);
        setBackground(GUIComponentsParameter.frameBackgroundColor);
        setPreferredSize(GUIComponentsParameter.getRawResultPanelDimension());
        setLayout(new VerticalLayoutManager(GUIComponentsParameter.getRawResultPanelDimension()));
        add(new JScrollPane(textArea));
        add(buttonPanel);
    }

    public static RawResultPanel getInstance() {
        if (instance == null) instance = new RawResultPanel();
        return instance;
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    @Override
    public String getAllText() {
        return textArea.getText();
    }

    @Override
    public void cleanAllFields() {
        textArea.setText("");
    }
}