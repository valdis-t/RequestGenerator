package requestgenerator.form;

import component.content.LabelForContentPanel;

import javax.swing.*;

public abstract class RequestPanelWithCardNumber extends RequestPanel {
    protected final JTextField cardNumberField;

    protected RequestPanelWithCardNumber(String panelName) {
        super(panelName);
        cardNumberField = getTextField();

        add(new LabelForContentPanel(CARD_NUMBER_LABEL_TEXT));
        add(cardNumberField);
    }

    public abstract String getAllText();
}
