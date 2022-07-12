package gui.panel.percentageresponse;

import boot.GUIComponentsParameter;
import gui.component.content.VerticalPanelForContentPanel;
import gui.component.control.ButtonForControlPanel;
import gui.component.control.ControlPanel;
import gui.frame.FrameFactory;
import gui.panel.MainPanel;
import util.file.Saver;

import javax.swing.*;

public class PercentageResponseMainPanel extends VerticalPanelForContentPanel {
    public static PercentageResponseMainPanel instance;
    private final MainPanel panel;
    private final JPanel bottomPanel;

    private PercentageResponseMainPanel() {
        setName("Генератор відповіді по відсоткам");
        bottomPanel = new ControlPanel();
        panel = new PercentageResponseLogicPanel();

        JButton copyToBufferButton = new ButtonForControlPanel("Копіювати");
        copyToBufferButton.addActionListener(l -> {
            Saver.saveToBuffer(panel);
        });
        JButton copyToFileButton = new ButtonForControlPanel("Перегляд");
        copyToFileButton.addActionListener(l -> {
            RawResultPanel rawPanel = RawResultPanel.getInstance();
            rawPanel.setText(panel.getAllText());
            FrameFactory.getFrame(rawPanel).setVisible(true);
        });
        JButton cleanButton = new ButtonForControlPanel("Очистити");
        cleanButton.addActionListener(l -> {
            panel.cleanAllFields();
        });

        bottomPanel.setBackground(GUIComponentsParameter.contentPanelBackgroundColor);
        bottomPanel.add(copyToBufferButton);
        bottomPanel.add(copyToFileButton);
        bottomPanel.add(cleanButton);

        setBackground(GUIComponentsParameter.frameBackgroundColor);
        add(panel);
        add(bottomPanel);
    }

    public static PercentageResponseMainPanel getInstance() {
        if (instance == null) instance = new PercentageResponseMainPanel();
        return instance;
    }
}