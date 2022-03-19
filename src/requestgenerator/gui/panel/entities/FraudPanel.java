package requestgenerator.gui.panel.entities;

import component.content.LabelForContentPanel;
import requestgenerator.form.RequestPanelWithCardNumber;

import javax.swing.*;

public class FraudPanel extends RequestPanelWithCardNumber {
    private static FraudPanel panel;

    private final JTextArea blockReasonArea;

    private final String BLOCK_REASON_TEXT;

    {
        BLOCK_REASON_TEXT = "Причина блокироваки/комментарий:";
        blockReasonArea = getTextArea();
    }

    private FraudPanel() {
        super("Фрод");
        add(new LabelForContentPanel(BLOCK_REASON_TEXT));
        add(blockReasonArea);
    }

    public static FraudPanel getInstance() {
        if (panel == null) panel = new FraudPanel();
        return panel;
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
