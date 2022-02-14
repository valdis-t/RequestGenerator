package swing.code.gui.panel;

import swing.code.form.ComponentSize;
import swing.code.form.MainPanel;
import swing.code.gui.layout.MainPanelLayoutManager;

import javax.swing.*;

public class ReferralPanel extends MainPanel {
    private static ReferralPanel panel;

    private JTextField clientNumberField;
    private JTextField friendNumberField;
    private JTextField referralLinkField;
    private JTextField chatLinkField;

    private ReferralPanel(){
        JLabel clientNumberFieldLabel = new JLabel("Номер клиента:");
        JLabel friendNumberFieldLabel = new JLabel("Номер друга:");
        JLabel referralLinkFieldLabel = new JLabel("Реферральная ссылка:");
        JLabel chatLinkFieldLabel = new JLabel("Ссылка на чат:");

        clientNumberField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        friendNumberField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        referralLinkField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        chatLinkField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);

        this.setSize(ComponentSize.WINDOWS_WIDTH,ComponentSize.MAIN_PANEL_HEIGHT);
        this.setLayout(new MainPanelLayoutManager());
        this.add(clientNumberFieldLabel);
        this.add(clientNumberField);
        this.add(friendNumberFieldLabel);
        this.add(friendNumberField);
        this.add(referralLinkFieldLabel);
        this.add(referralLinkField);
        this.add(chatLinkFieldLabel);
        this.add(chatLinkField);
    }

    public static ReferralPanel getInstance(){
        if(panel == null) panel = new ReferralPanel();
        return panel;
    }

    @Override
    public String getAllText() {
        if(
                        clientNumberField.getText().trim().equals(EMPTY) ||
                        friendNumberField.getText().trim().equals(EMPTY) ||
                        referralLinkField.getText().trim().equals(EMPTY) ||
                        chatLinkField.getText().trim().equals(EMPTY)
        ) return "Некорректный запрос!";
        StringBuilder buffer = new StringBuilder();
        buffer
                .append(clientNumberField.getText())
                .append(" пригласивший")
                .append("\n")
                .append(friendNumberField.getText())
                .append(" приглашенный")
                .append("\n")
                .append("\n")
                .append(referralLinkField.getText())
                .append("\n")
                .append(chatLinkField.getText());
        return buffer.toString();
    }

    @Override
    public void cleanAllFields() {
        clientNumberField.setText(EMPTY);
        friendNumberField.setText(EMPTY);
        referralLinkField.setText(EMPTY);
        chatLinkField.setText(EMPTY);
    }
}
