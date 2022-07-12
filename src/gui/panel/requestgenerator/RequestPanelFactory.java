package gui.panel.requestgenerator;

import util.analytic.AnalyticsContainer;
import boot.AnalyticCollector;
import gui.component.content.VerticalPanelForContentPanel;
import gui.component.control.ButtonForControlPanel;
import gui.component.control.ControlPanel;
import gui.panel.MainPanel;
import gui.panel.requestgenerator.entities.*;
import util.file.Saver;

import javax.swing.*;
import java.util.*;

public class RequestPanelFactory {
    private static List<JPanel> panels;
    private static final Map<MainPanel, JPanel> generatedPanels = new TreeMap<>();

    public static JPanel getPanel(MainPanel mainPanel) {
        if (generatedPanels.containsKey(mainPanel)) return generatedPanels.get(mainPanel);
        JPanel panel = new PanelBuilder(mainPanel);
        panel.setName(mainPanel.getName());
        generatedPanels.put(mainPanel, panel);
        return panel;
    }

    public static List<JPanel> getPanels() {
        if(panels == null){
            panels = new ArrayList<>();
            panels.add(getPanel(new MainRequestPanel()));
            panels.add(getPanel(new VerificationPanel()));
            panels.add(getPanel(new ReferralPanel()));
            panels.add(getPanel(new CashBackPanel()));
            panels.add(getPanel(new ClosingAccountPanel()));
            panels.add(getPanel(new FraudPanel()));
            panels.add(getPanel(new EnquiryPanel()));
            panels.add(getPanel(new DeliveryPanel()));
            panels.add(getPanel(new OtherRequestPanel()));
        }
        return panels;
    }

    private static class PanelBuilder extends VerticalPanelForContentPanel {
        PanelBuilder(MainPanel mainPanel) {
            JPanel bottomPanel = new ControlPanel();
            AnalyticsContainer collector = AnalyticCollector.getInstance().getAnalytic().getAnalyticContainer("Згенеровані через додаток запити в групи");

            JButton copyToBufferButton = new ButtonForControlPanel("Копіювати");
            copyToBufferButton.addActionListener(l -> {
                Saver.saveToBuffer(mainPanel);
                collector.collect(mainPanel.getName());
            });

            JButton copyToFileButton = new ButtonForControlPanel("Зберегти");
            copyToFileButton.addActionListener(l -> Saver.saveToFile(mainPanel, (mainPanel.getName())));

            JButton cleanButton = new ButtonForControlPanel("Очистити");
            cleanButton.addActionListener(l -> mainPanel.cleanAllFields());

            bottomPanel.add(copyToBufferButton);
            bottomPanel.add(copyToFileButton);
            bottomPanel.add(cleanButton);
            add(mainPanel);
            add(bottomPanel);
        }
    }
}
