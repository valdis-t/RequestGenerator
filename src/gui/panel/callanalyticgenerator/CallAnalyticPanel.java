package gui.panel.callanalyticgenerator;

import util.analytic.AnalyticsContainer;
import boot.AnalyticCollector;
import boot.GUIComponentsParameter;
import gui.component.content.ButtonForScriptPanel;
import gui.component.content.LabelForContentPanel;
import util.file.FileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CallAnalyticPanel extends JPanel {
    private final AnalyticsContainer collector;
    public static final String NAME = "Звернення в дзвінках";

    public CallAnalyticPanel() {
        collector = AnalyticCollector.getInstance().getAnalytic().getAnalyticContainer(NAME);
        initialize();
    }

    private void initialize() {
        List<JButton> buttons = new ArrayList<>();
        String[] buttonTexts = FileManager.getManager().getCallButtonNames().split("\n");
        for (String current : buttonTexts) {
            JButton button = new ButtonForScriptPanel(current);
            button.addActionListener(l -> {
                collector.collect(current);
            });
            buttons.add(button);
        }

        Dimension dimension = GUIComponentsParameter.getScriptPanelDimension(buttons.size());
        if (dimension == null) {
            setPreferredSize(new Dimension(200, 150));
            add(new LabelForContentPanel("Скрипт з панелями пуст, заповнений неправильно або відстуній.\nЗаполвніть за зразком:\nКожне ім'я з нового рядку!"));
            return;
        }
        setName(NAME);
        setBackground(GUIComponentsParameter.contentPanelBackgroundColor);
        setPreferredSize(dimension);
        setLayout(new FlowLayout());
        buttons.forEach(this::add);
    }

    public void actionOnClose() {
        collector.backup();
    }
}
