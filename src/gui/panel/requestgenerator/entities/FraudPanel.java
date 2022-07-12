package gui.panel.requestgenerator.entities;

import gui.component.content.LabelForContentPanel;
import gui.panel.requestgenerator.RequestPanelWithCardNumber;

import javax.swing.*;

public class FraudPanel extends RequestPanelWithCardNumber {
    private final JTextArea blockReasonArea;
    private final String BLOCK_REASON_TEXT;

    {
        BLOCK_REASON_TEXT = "Причина блокування/комментар:";
        blockReasonArea = getTextArea();
    }

    public FraudPanel() {
        super("Фрод");
        nameForAnalyticKey = panelName;
        add(new LabelForContentPanel(BLOCK_REASON_TEXT));
        add(blockReasonArea);
    }

    @Override
    public String getAllText() {
        textBuilder
                .append(nameField.getText())
                .append(idField.getText())
                .append(phoneNumberField.getText())
                .append(cardNumberField.getText())
                .append(blockReasonArea.getText());
        return textBuilder.toString();
    }
}
