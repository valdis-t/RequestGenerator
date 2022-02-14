package swing.code.gui.frame;

import swing.code.gui.layout.SecondaryPanelLayoutManager;
import swing.code.gui.panel.CashBackPanel;
import swing.code.gui.panel.OldMainRequestPanel;
import swing.code.gui.panel.ReferralPanel;
import swing.code.gui.layout.MainPanelLayoutManager;
import swing.code.form.ComponentSize;
import swing.code.form.Readable;
import swing.code.util.Saver;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
    private JPanel bottomPanel;
    private JPanel topPanel;
    private JPanel lastUsedPanel;

    private JButton copyToBufferButton;
    private JButton copyToFileButton;
    private JButton cleanButton;

    private JButton mainPanelButton;
    private JButton referralPanelButton;
    private JButton cashBackButton;

    private Readable source;

    public AppFrame(){
        initializeMainPanel();
        initializeTopPanel();
        initializeBottomPanel();
        initializeFrame();
    }

    private void initializeMainPanel(){
        source = OldMainRequestPanel.getInstance();
        lastUsedPanel = OldMainRequestPanel.getInstance();
    }

    private void initializeBottomPanel(){
        bottomPanel = new JPanel(new SecondaryPanelLayoutManager());
        bottomPanel.setBackground(Color.PINK);

        copyToBufferButton = new JButton("В БУФЕР");
        copyToBufferButton.setSize(ComponentSize.CONTROL_BUTTON_WIDTH,ComponentSize.CONTROL_BUTTON_HEIGHT);
        copyToBufferButton.addActionListener(l -> {
            Saver.saveToBuffer(source);
        });
        copyToFileButton = new JButton("В ФАЙЛ");
        copyToFileButton.setSize(ComponentSize.CONTROL_BUTTON_WIDTH,ComponentSize.CONTROL_BUTTON_HEIGHT);
        copyToFileButton.addActionListener(l -> {
            Saver.saveToFile(source);
        });
        cleanButton = new JButton("ОЧИСТИТЬ");
        cleanButton.setSize(ComponentSize.CONTROL_BUTTON_WIDTH,ComponentSize.CONTROL_BUTTON_HEIGHT);
        cleanButton.addActionListener(l -> {
            source.cleanAllFields();
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

    private void initializeTopPanel(){
        topPanel = new JPanel(new SecondaryPanelLayoutManager());
        topPanel.setBackground(Color.ORANGE);

        mainPanelButton = new JButton("ОСНОВНОЙ");
        referralPanelButton = new JButton("РЕФЕРАЛЬНЫЙ");
        cashBackButton = new JButton("КЕШБЕК");

        mainPanelButton.addActionListener(l -> {
            source = OldMainRequestPanel.getInstance();
            setFrame(OldMainRequestPanel.getInstance());
        });

        referralPanelButton.addActionListener(l -> {
            source = ReferralPanel.getInstance();
            setFrame(ReferralPanel.getInstance());
        });

        cashBackButton.addActionListener(l -> {
            source = CashBackPanel.getInstance();
            setFrame(CashBackPanel.getInstance());
        });

        topPanel.add(mainPanelButton);
        topPanel.add(cashBackButton);
        topPanel.add(referralPanelButton);
    }

    private void setFrame(JPanel panel){
        this.remove(bottomPanel);
        this.remove(lastUsedPanel);
        lastUsedPanel = panel;
        this.add(lastUsedPanel);
        this.add(bottomPanel);
        this.revalidate();
        this.repaint();
    }

}
