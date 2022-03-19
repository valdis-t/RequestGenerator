package requestgenerator.gui.panel.entities;

import common.gui.panel.MainPanel;
import component.content.LabelForContentPanel;

import javax.swing.*;

public class ReferralPanel extends MainPanel {
    private static ReferralPanel panel;

    private final JTextField clientNumberField;
    private final JTextField friendNumberField;
    private final JTextField referralLinkField;
    private final JTextField chatLinkField;

    private ReferralPanel() {
        super("Реферальный бонус");
        JLabel clientNumberFieldLabel = new LabelForContentPanel("Номер клиента:");
        JLabel friendNumberFieldLabel = new LabelForContentPanel("Номер друга:");
        JLabel referralLinkFieldLabel = new LabelForContentPanel("Реферральная ссылка:");
        JLabel chatLinkFieldLabel = new LabelForContentPanel("Ссылка на чат:");

        clientNumberField = getTextField();
        friendNumberField = getTextField();
        referralLinkField = getTextField();
        chatLinkField = getTextField();

        add(clientNumberFieldLabel);
        add(clientNumberField);
        add(friendNumberFieldLabel);
        add(friendNumberField);
        add(referralLinkFieldLabel);
        add(referralLinkField);
        add(chatLinkFieldLabel);
        add(chatLinkField);
    }

    public static ReferralPanel getInstance() {
        if (panel == null) panel = new ReferralPanel();
        return panel;
    }

    @Override
    public String getAllText() {
        textBuilder
                .append("пригласивший ", clientNumberField.getText())
                .append("приглашенный ", friendNumberField.getText())
                .append(referralLinkField.getText())
                .append(chatLinkField.getText());
        return textBuilder.toString();
    }
}
