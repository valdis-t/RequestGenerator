package swing.code.gui.frame;

import swing.code.form.MainPanel;
import swing.code.gui.layout.SecondaryPanelLayoutManager;
import swing.code.gui.panel.CashBackPanel;
import swing.code.gui.panel.OldMainRequestPanel;
import swing.code.gui.panel.PanelFactory;
import swing.code.gui.panel.ReferralPanel;
import swing.code.gui.layout.MainPanelLayoutManager;
import swing.code.form.ComponentSize;
import swing.code.util.Saver;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
    private JPanel bottomPanel;
    private JPanel topPanel;
    private MainPanel lastUsedPanel;

    public AppFrame(){
        initializeMainPanel();
//        initializeTopPanel();
        initializeRequestsPanel();
        initializeBottomPanel();
        initializeFrame();
    }

    private void initializeMainPanel(){
        lastUsedPanel = OldMainRequestPanel.getInstance();
    }

    private void initializeBottomPanel(){
        bottomPanel = new JPanel(new SecondaryPanelLayoutManager());
        bottomPanel.setBackground(Color.PINK);

        JButton copyToBufferButton = new JButton("В БУФЕР");
        copyToBufferButton.setSize(ComponentSize.CONTROL_BUTTON_WIDTH,ComponentSize.CONTROL_BUTTON_HEIGHT);
        copyToBufferButton.addActionListener(l -> {
            Saver.saveToBuffer(lastUsedPanel);
        });
        JButton copyToFileButton = new JButton("В ФАЙЛ");
        copyToFileButton.setSize(ComponentSize.CONTROL_BUTTON_WIDTH,ComponentSize.CONTROL_BUTTON_HEIGHT);
        copyToFileButton.addActionListener(l -> {
            Saver.saveToFile(lastUsedPanel);
        });
        JButton cleanButton = new JButton("ОЧИСТИТЬ");
        cleanButton.setSize(ComponentSize.CONTROL_BUTTON_WIDTH,ComponentSize.CONTROL_BUTTON_HEIGHT);
        cleanButton.addActionListener(l -> {
            lastUsedPanel.cleanAllFields();
        });

        bottomPanel.add(copyToBufferButton);
        bottomPanel.add(copyToFileButton);
        bottomPanel.add(cleanButton);
    }

    private void initializeFrame(){
        this.setBounds(10,10,ComponentSize.WINDOWS_WIDTH,ComponentSize.WINDOWS_HEIGHT);
        this.setLayout(new MainPanelLayoutManager());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(topPanel);
        this.add(lastUsedPanel);
        this.add(bottomPanel);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }

    private void initializeRequestsPanel() {
        topPanel = new JPanel(new SecondaryPanelLayoutManager());
        topPanel.setBackground(Color.ORANGE);

        for (MainPanel panel : PanelFactory.getPanels()) {
            JButton panelButton = new JButton(panel.getClass().getSimpleName());
            panelButton.addActionListener(l -> setFrame(panel));
            topPanel.add(panelButton);
        }
    }

    private void initializeTopPanel(){
        topPanel = new JPanel(new SecondaryPanelLayoutManager());
        topPanel.setBackground(Color.ORANGE);

        JButton mainPanelButton = new JButton("ОСНОВНОЙ");
        JButton referralPanelButton = new JButton("РЕФЕРАЛЬНЫЙ");
        JButton cashBackButton = new JButton("КЕШБЕК");

        mainPanelButton.addActionListener(l -> {
            setFrame(OldMainRequestPanel.getInstance());
        });

        referralPanelButton.addActionListener(l -> {
            setFrame(ReferralPanel.getInstance());
        });

        cashBackButton.addActionListener(l -> {
            setFrame(CashBackPanel.getInstance());
        });

        topPanel.add(mainPanelButton);
        topPanel.add(cashBackButton);
        topPanel.add(referralPanelButton);
    }

    private void setFrame(MainPanel panel){
        this.remove(bottomPanel);
        this.remove(lastUsedPanel);
        lastUsedPanel = panel;
        this.add(lastUsedPanel);
        this.add(bottomPanel);
        this.revalidate();
        this.repaint();
    }

}
