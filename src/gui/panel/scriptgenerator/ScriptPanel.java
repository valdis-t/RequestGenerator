package gui.panel.scriptgenerator;

import util.analytic.AnalyticsContainer;
import boot.AnalyticCollector;
import boot.GUIComponentsParameter;
import gui.component.content.ButtonForScriptPanel;
import gui.component.content.LabelForContentPanel;
import util.script.ScriptContainer;
import util.script.UserScriptReader;
import util.file.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;

public class ScriptPanel extends JPanel {
    private final AnalyticsContainer collector;
    public static final String NAME = "Використані у додатку скрипти";

    public ScriptPanel() {
        setBackground(GUIComponentsParameter.contentPanelBackgroundColor);
        setName(NAME);
        collector = AnalyticCollector.getInstance().getAnalytic().getAnalyticContainer(NAME);
        initialize();
    }

    private void initialize() {
        List<JButton> buttons = new ArrayList<>();
        for (ScriptContainer current : new UserScriptReader(FileManager.getManager().getUserScript()).getScripts()) {
            JButton button = new ButtonForScriptPanel(current.getName());
            button.addActionListener(l -> {
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(current.getBody()), null);
                collector.collect(current.getName());
            });
            buttons.add(button);
        }

        Dimension dimension = GUIComponentsParameter.getScriptPanelDimension(buttons.size());
        if (dimension == null) {
            setPreferredSize(new Dimension(400, 200));
            add(new LabelForContentPanel("Скрипт з панелями пуст, заповнений неправильно або відстуній.\nЗаполвніть за зразком:\nname=ім'я скрипту\nbody=текст для клиєнта"));
            return;
        }
        setPreferredSize(dimension);
        setLayout(new FlowLayout());
        buttons.forEach(this::add);
    }

    public void actionOnClose() {
        collector.backup();
    }
}
