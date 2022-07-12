package gui.panel.requestgenerator.entities;

import gui.component.content.LabelForContentPanel;
import gui.panel.MainPanel;

import javax.swing.*;

public class ReferralPanel extends MainPanel {
    private final JTextField clientNumberField;
    private final JTextField friendNumberField;
    private final JTextField referralLinkField;
    private final JTextField chatLinkField;

    public ReferralPanel() {
        super("Реферальный бонус");
        JLabel clientNumberFieldLabel = new LabelForContentPanel("Номер кліента:");
        JLabel friendNumberFieldLabel = new LabelForContentPanel("Номер друга:");
        JLabel referralLinkFieldLabel = new LabelForContentPanel("Реферальне посилання:");
        JLabel chatLinkFieldLabel = new LabelForContentPanel("Посилання на чат:");

        nameForAnalyticKey = panelName;
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

    @Override
    public String getAllText() {
        textBuilder
                .append("клієнт ", clientNumberField.getText())
                .append("запрошений друг ", friendNumberField.getText())
                .append(referralLinkField.getText())
                .append(chatLinkField.getText());
        return textBuilder.toString();
    }
}
